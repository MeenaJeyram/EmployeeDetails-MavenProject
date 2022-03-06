package com.exercise.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exercise.model.EmployeeDetails;
import com.exercise.util.ConnectionUtil;

public class EmployeeDetailsDao {
	
	public int insertEmployees(EmployeeDetails employee){
		String insertEmployee = "insert into employeeDetails (emp_name, emp_code, email, address1, address2, city, state, date_of_birth, joining_date) values(?,?,?,?,?,?,?,?,?)";
		int i = 0;
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(insertEmployee);
			p1.setString(1, employee.getEmpName());
			p1.setString(2, employee.getEmpCode());
			p1.setString(3, employee.getEmail());
			p1.setString(4, employee.getAddress1());
			p1.setString(5, employee.getAddress2());
			p1.setString(6, employee.getCity());
			p1.setString(7, employee.getState());
			p1.setDate(8, java.sql.Date.valueOf(employee.getDateOfBirth()));
			p1.setDate(9, java.sql.Date.valueOf(employee.getJoiningDate()));
			p1.executeUpdate();
			i = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);			
		}
		return i;
	}
	
	public List<EmployeeDetails> viewEmployee()
	{	
		List<EmployeeDetails> employeeList = new ArrayList<>();
		String viewQuery = "select emp_name, emp_code, email, address1, address2, city, state, date_of_birth, joining_date from employeeDetails";
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			 con = ConnectionUtil.getDbConnection();
			 statement = con.createStatement();
			 rs = statement.executeQuery(viewQuery);
			 while(rs.next()) {
				 EmployeeDetails employee = new EmployeeDetails(rs.getString("emp_name"), rs.getString("emp_code"), rs.getString("email"), 
						 rs.getString("address1"), rs.getString("address2"), rs.getString("city"), rs.getString("state"), rs.getDate("date_of_birth").toLocalDate(), rs.getDate("joining_date").toLocalDate());
				 employeeList.add(employee);
			 } 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.closeConnectionStatement(rs, statement, con);
		}
		return employeeList;
	}
	
	public List<EmployeeDetails> searchEmployees(String empCode, String city, String state, LocalDate fromDate, LocalDate toDate)
	{
		List<EmployeeDetails> searchList = new ArrayList<>();
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("select emp_code, emp_name, email, city, state from employeeDetails");
		        
		if(!empCode.equals("")  &&  !city.equals("") && !state.equals("") && ! fromDate.equals("") && !toDate.equals(""))
		{
			sqlQuery.append(" where emp_code= " + "'" + empCode +"'" + "and city=" + "'" + city+ "'" + "and state =" +"'"+state+"'");
	        sqlQuery.append(" and to_char(joining_date,'yyyy-mm-dd') between " + "'" +  fromDate  + "'"+ " and " +"'"+  toDate + "'");
		}
		else if (!empCode.equals("") ||  !city.equals("") || !state.equals("") || !fromDate.equals("") || !toDate.equals("")) 
		{
			sqlQuery.append(" where ");
			if (!empCode.equals("")) 
			{
				sqlQuery.append(" emp_code= "+"'" + empCode +"'" );
			}
			if (!city.equals("")) 
			{
				if (empCode.equals("")) {
					sqlQuery.append(" lower(city) like " + "'" + city.toLowerCase() + "%'");
				} else {
					sqlQuery.append(" and lower(city) like " + "'" +  city.toLowerCase() + "%'");
				}
			}
			if (!state.equals("")) 
			{
				if (empCode.equals("") && city.equals("")) {
					sqlQuery.append(" lower(state) like " + "'" + state.toLowerCase() + "%'");
				} else if(empCode.equals("") || city.equals("")) {
					sqlQuery.append("and lower(state) like " + "'" + state.toLowerCase() + "%'");
				}else {
					sqlQuery.append("and lower(state) like " + "'" + state.toLowerCase() + "%'");
				}
			}
			
			if (fromDate!= null &&  toDate != null) 
			{
				if ( empCode.equals("") && ( city.equals("")) && ( state.equals(""))) {
					sqlQuery.append(" to_char(joining_date,'yyyy-mm-dd') between  " + "'" +  fromDate + "' and '" +  toDate + "'");
				} else {
					sqlQuery.append("and to_char(joining_date,'yyyy-mm-dd') between  " + "'" + fromDate + "' and '" +  toDate + "'");
				}
			} else if (fromDate != null) 
			{
				if ( empCode.equals("") && ( city.equals("")) && (state.equals(""))) {
					sqlQuery.append(" to_char(joining_date,'yyyy-mm-dd') =  " + "'" +  fromDate + "'");
				} else {
					sqlQuery.append("and to_char(joining_date,'yyyy-mm-dd')=  " + "'" +  fromDate + "'");
				}
			}
		}
		String query = sqlQuery.toString();
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			rs = p1.executeQuery();
			while(rs.next()) {
				EmployeeDetails employee = new EmployeeDetails(rs.getString("emp_code"), rs.getString("emp_name"), rs.getString("email"), rs.getString("city"), rs.getString("state"));
				searchList.add(employee);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return searchList;
	}
	
	public List<EmployeeDetails> employeeLists(String empcode) throws SQLException {
		List<EmployeeDetails> employeelist = new ArrayList<>();
		String query = "select emp_code, emp_name, email, address1, address2, city, state, date_of_birth, joining_date from EmployeeDetails where emp_code = ?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setString(1, empcode);	
			ResultSet rs = p1.executeQuery();
			while (rs.next()) {
				EmployeeDetails employee = new EmployeeDetails(rs.getString("emp_name"), rs.getString("emp_code"), rs.getString("email"), 
						 rs.getString("address1"), rs.getString("address2"), rs.getString("city"), rs.getString("state"), rs.getDate("date_of_birth").toLocalDate(), rs.getDate("joining_date").toLocalDate());
				 employeelist.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);			
		}
		return employeelist;
	}
	
	public int employeeDetailsUpdate(EmployeeDetails employee) throws SQLException {
		StringBuilder sqlQuery = new StringBuilder();
		String query = "update EmployeeDetails set emp_name=?, emp_code=?, email=?, address1=?, address2=?, city=?, state=?, date_of_birth=?, joining_date=? where emp_code =?";
		Connection con = null;
		PreparedStatement p1 = null;
		int i = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setString(1, employee.getEmpName());
			p1.setString(2, employee.getEmail());
			p1.setString(3, employee.getAddress1());
			p1.setString(4, employee.getAddress2());
			p1.setString(5, employee.getCity());
			p1.setString(6, employee.getState());
			p1.setDate(7, java.sql.Date.valueOf(employee.getDateOfBirth()));
			p1.setDate(8, java.sql.Date.valueOf(employee.getJoiningDate()));
			p1.executeUpdate();
			i = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);			
		}
		return i;
	}
	
	public List<EmployeeDetails> updateEmployee(String empcode)
	{
		String Query = "select emp_name, emp_code, email, address1, address2, city, state, date_of_birth, joining_date from employeeDetails where emp_code = ?";
		List<EmployeeDetails> updateList = new ArrayList<>();
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(Query);
			p1.setString(1, empcode);
			rs = p1.executeQuery();
			while(rs.next()){
				EmployeeDetails employeeList = new EmployeeDetails(rs.getString("emp_name"), rs.getString("emp_code"), rs.getString("email"), 
						 rs.getString("address1"), rs.getString("address2"), rs.getString("city"), rs.getString("state"), rs.getDate("date_of_birth").toLocalDate(), rs.getDate("joining_date").toLocalDate());
				updateList.add(employeeList);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return updateList;
	}
}
