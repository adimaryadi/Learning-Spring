package com.learning.postgres.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learning.postgres.entity.Employee;
import com.learning.postgres.mapper.EmployeeRowMapper;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	private static final Gson GSON 	 =  new GsonBuilder().setPrettyPrinting().create();
	
	public EmployeeDaoImpl(NamedParameterJdbcTemplate template) {
		this.template 	 	= 	 template;
	}
	
	NamedParameterJdbcTemplate template;
	
	
	public List<Employee> findAll() {
		return template.query("select * from employee", new EmployeeRowMapper());
	}
	
	public void insertEmployee(Employee emp) {
		final String sql 	 	 	= 	"insert into employee(employeeName,employeeAddress,employeeEmail) values(:employeeName,:employeeAddress,:employeeEmail)";
		
		KeyHolder holder 	 	 	= 	new GeneratedKeyHolder();
		SqlParameterSource 	 param  =  	new MapSqlParameterSource()
				.addValue("employeeName", emp.getEmployeeName())
				.addValue("employeeAddress", emp.getEmployeeAddress())
				.addValue("employeeEmail", emp.getEmployeeEmail());
		template.update(sql,param,holder);
//		System.out.print("tempalte = ");
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		final String sql  	 		 = 	"update employee set employeeName=:employeeName, employeeAddress=:employeeAddress,employeeEmail=:employeeEmail where employeeId=:employeeId";
//		System.out.print(GSON.toJson(emp));
		KeyHolder holder 	 		 = 	new GeneratedKeyHolder();
		SqlParameterSource 	param 	 = 	new MapSqlParameterSource()
				.addValue("employeeName", emp.getEmployeeName())
				.addValue("employeeAddress", emp.getEmployeeAddress())
				.addValue("employeeEmail", emp.getEmployeeEmail())
				.addValue("employeeId", emp.getEmployeeId());
		template.update(sql, param, holder);
	}

	@Override
	public void excecuteUpdateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		final String sql 	 	 	 	 = 	"update employee set employeeName=:employeeName, employeeAddress=:employeeAddress,employeeEmail=:employeeEmail where employeeId=:employeeId";
		
		Map<String,Object> map 	= 	new HashMap<String, Object>();
		map.put("employeeName", emp.getEmployeeName());
		map.put("employeeAddress", emp.getEmployeeAddress());
		map.put("employeeEmail", emp.getEmployeeEmail());
		map.put("employeeId", emp.getEmployeeId());
//		System.out.println("executeUpdateEmployee = "+ GSON.toJson(map));
		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException , DataAccessException {
				return ps.executeUpdate();
			}
		});
	}

	@Override
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		final String sql 	 	 	 = 	 "delete from employee where employeeId=:employeeId";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("employeeId", emp.getEmployeeId());
		
		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
//				System.out.println(ps);
				return ps.executeUpdate();
			}
		});
	}
}
