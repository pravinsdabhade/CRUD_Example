package com.example.crudexample.service;

import java.util.List;

import com.example.crudexample.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int empId);
	
	public void save(Employee employee);
	
	public void deleteEmployeeById(int empId);
	
	
}
