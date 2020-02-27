package com.example.crudexample.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudexample.entity.Employee;
import com.example.crudexample.service.EmployeeService;

@RestController
@RequestMapping("/restAPI")
public class EmployeeRestController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/employees/{empId}")
	public Employee getEmployeeById(@PathVariable int empId) {
		Employee employee = empService.getEmployeeById(empId);
		if (employee == null)
			throw new RuntimeException("Employee id not Found..." + empId);
		return employee;
	}

	@PostMapping(path = "/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		empService.save(employee);
		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		empService.save(employee);
		return employee;
	}

	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		Employee employeeById = empService.getEmployeeById(empId);
		if (employeeById == null) {
			throw new RuntimeException("Employee Id not found " + employeeById);
		}
		empService.deleteEmployeeById(empId);
		return "Deleted employee id " + empId;
	}

}
