package com.revature.cardex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userInput = request.getParameter("searchName");


        response.setContentType("html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("{\"staus\":\"ok\"}");
    }
}
