package com.exercise.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exercise.daoimpl.EmployeeDetailsDao;
import com.exercise.model.EmployeeDetails;

@WebServlet("/UpdateEmployeeServ")
public class UpdateEmployeeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		try {
			
			String empcode = request.getParameter("empcode");
			System.out.println(empcode);
		
			EmployeeDetailsDao employeedao = new EmployeeDetailsDao();
			
			List<EmployeeDetails> employeelist = employeedao.employeeLists(empcode);
			
			request.setAttribute("emplist", employeelist);
			
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("updateEmployees.jsp");
			requestdispatcher.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
