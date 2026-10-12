package EmployeeManagement.OpertionServlet;

import EmployeeManagement.EMdbService;
import EmployeeManagement.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/EmplyeeUPT")
public class InsertServlet extends HttpServlet {

    private EMdbService emdbService ;

    public void init(){
        emdbService = new EMdbService();
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            // Get values from the HTML form
            String action = request.getParameter("action");
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String salary = request.getParameter("salary");
            String department = request.getParameter("department");
            String email = request.getParameter("email");

            // Check whether ID and salary are empty
            if (id == null || id.isBlank() ||
                    salary == null || salary.isBlank()) {

                response.getWriter().println("Error: ID and salary are required.");
                return;
            }

            // Convert String into numeric values
            int empId = Integer.parseInt(id);
            double empSalary = Double.parseDouble(salary);

            // Create Employee object
            Employee employee = new Employee(
                    empId, name, empSalary, department, email
            );

            if ("update".equalsIgnoreCase(action)) { /// update is value in 'html'
                boolean updated = emdbService.updateEmployee(employee);
                if (updated) {
                    response.getWriter().println(
                            "<script>alert('Employee updated successfully!');" +
                                    "window.location='Main.html';</script>"
                    );
                } else {
                    response.getWriter().println(
                            "<script>alert('Employee not found for update!');" +
                                    "window.location='Main.html';</script>"
                    );
                }
            } else {
                // Insert into database
                emdbService.insertEmployee(employee);

                response.getWriter().println(
                        "<script>alert('Employee inserted successfully!');" +
                                "window.location='Main.html';</script>"
                );
            }

        } catch (NumberFormatException e) {

            response.getWriter().println(
                    "Error: ID must be an integer and salary must be a valid number."
            );

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error inserting employee. Check the Tomcat console for details."
            );
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

}
