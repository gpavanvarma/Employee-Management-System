package EmployeeManagement;

public class EmpQuery {

    static String insertEmpQuery(){
        return "insert into empserv values (?,?,?,?,?)";
    }

    static String SearchbyIDEmpQuery(){

        return "SELECT * FROM empserv WHERE id = ?";
    }

    static String ViewEmpAll(){

        return "SELECT * FROM empserv";
    }

    static String DeleteEmpQuery(){
        return "DELETE FROM empserv WHERE id = ?";
    }

    static String UpdateEmpQuery() {
        return "UPDATE empserv SET name = ?, salary = ?, department = ?, email = ? WHERE id = ?";
    }
}
