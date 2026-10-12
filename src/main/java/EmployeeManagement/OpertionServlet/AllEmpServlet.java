package EmployeeManagement.OpertionServlet;

import EmployeeManagement.EMdbService;
import EmployeeManagement.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/allemp")
public class AllEmpServlet extends HttpServlet {

    private final EMdbService emdbService = new EMdbService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Retrieve all employees from the database
            List<Employee> employees = emdbService.viewstudent();

            // Send employee data to the JSP
            request.setAttribute("employees", employees);

            // Send success message
            request.setAttribute(
                    "message",
                    "Employee details retrieved successfully!"
            );

            // Forward the request to the JSP
            request.getRequestDispatcher("/AllEmp.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            throw new ServletException(
                    "Unable to retrieve employee details", e
            );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}