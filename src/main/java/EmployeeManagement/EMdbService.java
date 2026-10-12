package EmployeeManagement;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.List;

public class EMdbService {

    public Employee insertEmployee(Employee e) throws Exception {

        Connection conn = null;
        try {
            conn = EmployeeConntion.getDs().getConnection();
            conn.setAutoCommit(false);
            try (PreparedStatement pt = conn.prepareStatement(EmpQuery.insertEmpQuery())
            ) {
                pt.setInt(1, e.id());
                pt.setString(2, e.name());
                pt.setDouble(3, e.salary());
                pt.setString(4, e.department());
                pt.setString(5, e.email());
                int row = pt.executeUpdate();
                if (row > 0) {
                    conn.commit();
                    System.out.println("Employee inserted successfully");
                } else {
                    System.out.println("Failed to insert employee");
                }
            }
        } catch (Exception ex) {
            try {
                conn.rollback();
            } catch (SQLException exc) {
                throw new RuntimeException(exc);
            }
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }/// end of insert employee


    /// --------------------------------------------------------------------///
    public Employee SearchEmployeeBYID(Employee e) throws Exception {
        Connection conn = null;
        try {
            conn = EmployeeConntion.getDs().getConnection();
            conn.setAutoCommit(false);
            try (PreparedStatement preparedStatement = conn.prepareStatement(EmpQuery.SearchbyIDEmpQuery())) {
                preparedStatement.setInt(1, e.id());
                ResultSet rs = preparedStatement.executeQuery();
               if (rs.next()) {
                   int id = rs.getInt("id");
                   String name = rs.getString("name");
                   double salary = rs.getDouble("salary");
                   String department = rs.getString("department");
                   String email = rs.getString("email");

                   return new Employee(
                           id, name, salary, department, email
                   );
               }
               conn.commit();
            }
        } catch (Exception ex) {
            try {
                conn.rollback();
                System.out.println("Unable to search employee.");
            } catch (SQLException exc) {
                throw new RuntimeException(exc);
            }
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }/// ------------------End of By ID --------------------------------

    public List<Employee> viewstudent() throws Exception {

        List<Employee> employees = new java.util.ArrayList<>();


        try (
                Connection connection = EmployeeConntion.getDs().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet =
                        statement.executeQuery(EmpQuery.ViewEmpAll());
        ) {
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("department"),
                        resultSet.getString("email")
                ));
            }

        }

        return employees;
    }
    /// ------------------End of viewstudent

    /// -------------------Delete employee by id------------------------///
    public Employee deleteEmployee(Employee e) throws Exception {
        Connection conn = null;
        try {
            conn = EmployeeConntion.getDs().getConnection();
            conn.setAutoCommit(false);
            try(PreparedStatement preparedStatement=conn.prepareStatement(EmpQuery.DeleteEmpQuery())){
                preparedStatement.setInt(1, e.id());
                int row=preparedStatement.executeUpdate();
                conn.commit();
                System.out.println("Employee deleted successfully");
            }
        }catch (Exception ex){
            try {
                conn.rollback();
                System.out.println("Delete operation failed: " + ex.getMessage());
            }catch (SQLException exc) {
                throw new RuntimeException(exc);
            }
            throw new RuntimeException(ex);
        }
        finally {
            try {
                conn.close();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public boolean updateEmployee(Employee e) throws Exception {
        Connection conn = null;
        try {
            conn = EmployeeConntion.getDs().getConnection();
            conn.setAutoCommit(false);
            try (PreparedStatement preparedStatement = conn.prepareStatement(EmpQuery.UpdateEmpQuery())) {
                preparedStatement.setString(1, e.name());
                preparedStatement.setDouble(2, e.salary());
                preparedStatement.setString(3, e.department());
                preparedStatement.setString(4, e.email());
                preparedStatement.setInt(5, e.id());

                int row = preparedStatement.executeUpdate();
                conn.commit();
                return row > 0;
            }
        } catch (Exception ex) {
            try {
                conn.rollback();
                System.out.println("Unable to update employee.");
            } catch (SQLException exc) {
                throw new RuntimeException(exc);
            }
            throw new RuntimeException(ex);
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}//end of class