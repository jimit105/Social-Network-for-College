package com.test.servlets;

public class Student {
	String firstname;
	String lastname;
	String email;
	String password;
	String year;
	String branch;
	String division;
	String interest;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + ", year=" + year + ", branch=" + branch + ", division=" + division + ", interest="
				+ interest + "]";
	}
	public Student(String firstname, String lastname, String email, String password, String year, String branch,
			String division, String interest) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.year = year;
		this.branch = branch;
		this.division = division;
		this.interest = interest;
	}
	public Student() {
		super();
	}
	
	
	
	
	
	

}
