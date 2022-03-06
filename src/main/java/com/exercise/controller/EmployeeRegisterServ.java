package com.exercise.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exercise.handler.EmployeeDetailsHandler;


@WebServlet("/EmployeeRegisterServ")
public class EmployeeRegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeDetailsHandler emphandler = new EmployeeDetailsHandler();
		
		int i = emphandler.employeeRegisterHandler(request);
		
		if(i == 1)
		{
			response.sendRedirect("searchEmployee.jsp");
		}else {
			HttpSession session = request.getSession();
			
			session.setAttribute("insert", "Not Inserted");
			response.sendRedirect("employeeDetails.jsp");
		}
	}

}
