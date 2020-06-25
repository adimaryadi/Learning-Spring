package com.learning.postgres.entity;

public class Employee {
	 int employeeId;
	 String employeeName;
	 String employeeEmail;
	 String employeeAddress;
	 
	 public String getEmployeeEmail() {
		 return employeeEmail;
	 }
	 
	 public void setEmployeeEmail(String employeeEmail) {
		 this.employeeEmail 	= 	 	employeeEmail;
	 }
	 
	 public int getEmployeeId() {
		 return employeeId;
	 }
	 
	 public void setEmployeeId(int employeeId) {
		 this.employeeId 	 	= 	 	employeeId;
	 }
	 
	 public String getEmployeeName() {
		 return employeeName;
	 }
	 
	 public void setEmployeeName(String employeeName) {
		 this.employeeName 	 	= 	 	employeeName;
	 }
	 
	 public String getEmployeeAddress() {
		 return employeeAddress;
	 }
	 
	 public void setEmployeeAddress(String employeeAddress) {
		 this.employeeAddress 	= 	 	employeeAddress;
	 }
}
