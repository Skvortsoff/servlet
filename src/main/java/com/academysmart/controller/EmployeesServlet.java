package com.academysmart.controller;

import com.academysmart.repository.EmployeeRepositorySingleton;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
public class EmployeesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    EmployeeRepositorySingleton ers = EmployeeRepositorySingleton.getRepository();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        //TODO implement logic to process GET requests
    request.setAttribute("employees", ers.getAllEmployees());
        request.getRequestDispatcher("employee.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {

        //TODO implement logic to process data that client sent to server with POST method.
        //It could include adding employee to repository,
        //validating email, redirecting client to a page where employee list is displayed etc.

        try {

                ers.addEmployee(request.getParameter("fname"), request.getParameter("lname"), request.getParameter("email"));



        } catch (com.academysmart.exception.ServletException e) {
            request.setAttribute("errMsg", e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.doGet(request,response);
    }
}
