package com.example.crudexample.dao;

import java.util.List;

import com.example.crudexample.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int empId);
	
	public void save(Employee employee);
	
	public void deleteById(Integer empId);
}
