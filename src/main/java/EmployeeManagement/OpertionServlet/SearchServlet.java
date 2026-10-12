package EmployeeManagement.OpertionServlet;

import EmployeeManagement.EMdbService;
import EmployeeManagement.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private EMdbService emdbService;

    @Override
    public void init() throws ServletException {
        emdbService = new EMdbService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            // Get employee ID from the HTML form
            int id = Integer.parseInt(request.getParameter("id"));

            // Search employee in the database
            Employee employee = emdbService.SearchEmployeeBYID(
                    new Employee(id, null, 0.0, null, null)
            );

            // Check whether employee exists
            if (employee != null) {
                request.setAttribute("id", employee.id());
                request.setAttribute("name", employee.name());
                request.setAttribute("salary", employee.salary());
                request.setAttribute("department", employee.department());
                request.setAttribute("email", employee.email());

                request.setAttribute("message", "Employee found successfully!");

            } else {
                request.setAttribute("message", "Employee not found!");

            }

            request.getRequestDispatcher("/Result.jsp")
                    .forward(request, response);

        } catch (NumberFormatException e) {

            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Please enter a valid employee ID."
            );

        } catch (Exception e) {
            throw new ServletException("Unable to search employee.", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.sendError(
                HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                "Please submit the employee ID using the search form."
        );
    }
}