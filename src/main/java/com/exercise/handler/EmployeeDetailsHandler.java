package com.exercise.handler;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import com.exercise.daoimpl.EmployeeDetailsDao;
import com.exercise.model.EmployeeDetails;


public class EmployeeDetailsHandler {

	public int employeeRegisterHandler(HttpServletRequest request) {
		
		String empname = request.getParameter("empname");
		String empcode = request.getParameter("empcode");
		String emailid = request.getParameter("email");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		LocalDate doj = LocalDate.parse(request.getParameter("doj"));
	
		EmployeeDetails employee = new EmployeeDetails(empname, empcode, emailid, address1, address2, city, state, dob, doj);
		
		EmployeeDetailsDao employeedetails = new EmployeeDetailsDao();
		
		int i = employeedetails.insertEmployees(employee);
		
		return i;
	}
	
	public List<EmployeeDetails> searchList(HttpServletRequest request){
		
		String empcode = request.getParameter("empcode");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String fDate = request.getParameter("fromDate");
		LocalDate fromDate = null;
		if(!fDate.equals("")) 
		{
			fromDate = LocalDate.parse(request.getParameter("fromDate"));
		}
		String tDate = request.getParameter("toDate");
		LocalDate toDate = null;
		if(!tDate.equals(""))
		{
			toDate = LocalDate.parse(request.getParameter("toDate"));
		}
		EmployeeDetailsDao employeedetails = new EmployeeDetailsDao();
	
		List<EmployeeDetails> employeelist = employeedetails.searchEmployees(empcode, city, state, fromDate, toDate);
		
		return employeelist;
	}
	
	public int employeeUpdate(HttpServletRequest request) throws SQLException
	{
			String empname = request.getParameter("empname");
			String empcode = request.getParameter("empcode");
			String emailid = request.getParameter("email");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			LocalDate dob = LocalDate.parse(request.getParameter("dateofbirth"));
			LocalDate doj = LocalDate.parse(request.getParameter("joiningdate"));
		
			EmployeeDetails employeeUpdate = new EmployeeDetails(empname, empcode, emailid, address1, address2, city, state, dob, doj);
			EmployeeDetailsDao employeedao = new EmployeeDetailsDao();
			int i = employeedao.employeeDetailsUpdate(employeeUpdate);
			return i;	
	}
}










