package com.learning.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.postgres.entity.Employee;
import com.learning.postgres.service.EmployeeService;


@RestController
@RequestMapping("/")
public class ApplicationController {
	
	@Resource
	EmployeeService employeeService;
	
	@GetMapping("/employeeList")
	public JSONObject getEmployee() {
		JSONObject objJSON 	 	= 	  new JSONObject();
		objJSON.put("code", "00");
		objJSON.put("status", "success");
		objJSON.put("message", "Data Save successful");
		objJSON.put("data", employeeService.findAll());
		return objJSON;
	}
	
	@PostMapping(value = "/createEmp")
	public JSONObject createEmployee(@RequestBody Employee emp) {
		 employeeService.insertEmployee(emp);
		 
		 JSONObject objJSON  	= 	 new JSONObject();
		 objJSON.put("code", "00");
		 objJSON.put("status", "success");
		 objJSON.put("message", "Data Save successful");
		 return objJSON;
	}
	@PutMapping(value = "/updateEmp")
	public JSONObject updateEmployee(@RequestBody Employee emp) {
		 employeeService.updateEmployee(emp);
		 
		 JSONObject objJSON 	= 	new JSONObject();
		 objJSON.put("code", "00");
		 objJSON.put("status", "success");
		 objJSON.put("message", "Update data successful");
		 
		 return objJSON;
	}
	@PutMapping(value = "/executeUpdateEmp")
	public JSONObject executeUpdateEmployee(@RequestBody Employee emp) {
		 employeeService.executeUpdateEmployee(emp);

		 JSONObject objJSON 	= 	new JSONObject();
		 objJSON.put("code", "00");
		 objJSON.put("status", "success");
		 objJSON.put("message", "Update data successful");
		 
		 return objJSON;
	}
	
	@DeleteMapping(value = "/deleteEmpById")
	public JSONObject deleteEmployee(@RequestBody Employee emp) {
		 employeeService.deleteEmployee(emp);
		 JSONObject objJSON 	= 	new JSONObject();
		 objJSON.put("code", "00");
		 objJSON.put("status", "success");
		 objJSON.put("message", "Delete data successful");
		 
		 return objJSON;
	}
}
