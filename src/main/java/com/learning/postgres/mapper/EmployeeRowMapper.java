package com.learning.postgres.mapper;

import java.sql.SQLException;
import java.sql.ResultSet;
//import javax.resource.cci.ResultSet;

import org.springframework.jdbc.core.RowMapper;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.learning.postgres.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
//	private static final Gson GSON  	= 	 new GsonBuilder().setPrettyPrinting().create();
	
	public Employee mapRow(ResultSet rs, int args1) throws SQLException {
		Employee emp 	 	= 		 new Employee();
		emp.setEmployeeId(rs.getInt("employeeId"));
		emp.setEmployeeName(rs.getString("employeeName"));
		emp.setEmployeeEmail(rs.getString("employeeEmail"));
		emp.setEmployeeAddress(rs.getString("employeeAddress"));
//		System.out.println("RowMapper = "+ GSON.toJson(emp));
		return emp;
	}
	
}
