package com.learning.postgres.service;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.learning.postgres.dao.EmployeeDao;
import com.learning.postgres.entity.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	@Resource
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeDao.insertEmployee(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(emp);
	}

	@Override
	public void executeUpdateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeDao.excecuteUpdateEmployee(emp);
	}

	@Override
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(emp);
	}
}
