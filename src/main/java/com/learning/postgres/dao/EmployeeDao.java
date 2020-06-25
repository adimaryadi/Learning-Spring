package com.learning.postgres.dao;

import java.util.List;

import com.learning.postgres.entity.Employee;

public interface EmployeeDao {
	List<Employee> findAll();
	
	void insertEmployee(Employee emp);
	
	void updateEmployee(Employee emp);
	
	void excecuteUpdateEmployee(Employee emp);
	
	public void deleteEmployee(Employee emp);
}
