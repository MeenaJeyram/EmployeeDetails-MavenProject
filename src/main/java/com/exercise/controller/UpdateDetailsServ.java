package com.exercise.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercise.handler.EmployeeDetailsHandler;

@WebServlet("/UpdateDetailsServ")
public class UpdateDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		EmployeeDetailsHandler employeeHandler = new EmployeeDetailsHandler();
		int i = employeeHandler.employeeRegisterHandler(request);
		
		if(i==1) 
		{
			 RequestDispatcher requestdispatcher = request.getRequestDispatcher("updateMsg.jsp");
		     requestdispatcher.forward(request, response);
		}
		else {
			 RequestDispatcher requestdispatcher = request.getRequestDispatcher("searchList.jsp");
		     requestdispatcher.forward(request, response);
		}
	}
}
