package com.exercise.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercise.daoimpl.EmployeeDetailsDao;
import com.exercise.handler.EmployeeDetailsHandler;
import com.exercise.model.EmployeeDetails;

@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		EmployeeDetailsHandler emphandler = new EmployeeDetailsHandler();
		
		List<EmployeeDetails> list = null;
		
		list = emphandler.searchList(request);
		
		request.setAttribute("searchlist", list);
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("searchList.jsp");
		requestdispatcher.forward(request, response);	
	}
}
