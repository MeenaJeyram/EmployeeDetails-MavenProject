package com.exercise.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("username : " +username);
		long phonenumber = Long.parseLong(request.getParameter("phonenumber"));
		String address = request.getParameter("address");
		String email = request.getParameter("address");
		String password = request.getParameter("address");
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("registerSuccess.jsp");
		requestdispatcher.forward(request, response);
	}

}
