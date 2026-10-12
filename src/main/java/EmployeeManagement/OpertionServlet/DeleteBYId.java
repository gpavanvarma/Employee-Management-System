package EmployeeManagement.OpertionServlet;

import EmployeeManagement.EMdbService;
import EmployeeManagement.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/delete")
public class DeleteBYId extends HttpServlet {
    EMdbService emdbService;
    public void init() {
        emdbService = new EMdbService();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = emdbService.deleteEmployee(new Employee(id, null, 0.0, null, null));

            response.getWriter().println(
                    "<script>alert('Employee deleted successfully!');" + "window.location='Main.html';</script>"
            );
        }catch (Exception ex){
            ex.printStackTrace();
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Please enter a valid employee ID."
            );
            response.sendError(HttpServletResponse.SC_NOT_FOUND,"Employee not found.");
        }
    }

}
