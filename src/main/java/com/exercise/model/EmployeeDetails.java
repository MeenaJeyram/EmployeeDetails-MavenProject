package com.exercise.model;

import java.time.LocalDate;

public class EmployeeDetails {
	private String empName;
	private String empCode;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private LocalDate dateOfBirth;
	private LocalDate joiningDate;
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public EmployeeDetails() {
		super();
	}
	public EmployeeDetails(String empName, String empCode, String email, String address1, String address2, String city,
			String state, LocalDate dateOfBirth, LocalDate joiningDate) {
		super();
		this.empName = empName;
		this.empCode = empCode;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.dateOfBirth = dateOfBirth;
		this.joiningDate = joiningDate;
	}
		
	public EmployeeDetails(String empCode, String empName, String email, String city, String state) {
		super();
		this.empName = empName;
		this.empCode = empCode;
		this.email = email;
		this.city = city;
		this.state = state;
	}
	
	public EmployeeDetails(String empName, String email, String city, String state, LocalDate dateOfBirth) {
		super();
		this.empName = empName;
		this.email = email;
		this.city = city;
		this.state = state;
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empName=" + empName + ", empCode=" + empCode + ", email=" + email + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", dateOfBirth="
				+ dateOfBirth + ", joiningDate=" + joiningDate + "]";
	}
		
}
