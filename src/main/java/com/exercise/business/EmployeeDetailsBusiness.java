package com.exercise.business;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.exercise.daoimpl.EmployeeDetailsDao;
import com.exercise.model.EmployeeDetails;

public class EmployeeDetailsBusiness {
	
	public int registerEmployee(EmployeeDetails employee) 
	{
		
		EmployeeDetailsDao employeedetails = new EmployeeDetailsDao();
		int i = employeedetails.insertEmployees(employee);
		return i;	
	}
	
	public List<EmployeeDetails> searchList(String empcode, String city, String state, LocalDate fromDate, LocalDate toDate){
		
		EmployeeDetailsDao employeedetails = new EmployeeDetailsDao();
		
		List<EmployeeDetails> employeelist = employeedetails.searchEmployees(empcode, city, state, fromDate, toDate);
		
		return employeelist;
	}
	
	public List<EmployeeDetails> updateEmployee(String empcode)
	{
		List<EmployeeDetails> updateList = null;
		try {
			EmployeeDetailsDao employeedao = new EmployeeDetailsDao();
			updateList = employeedao.employeeLists(empcode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateList;
	}

}
