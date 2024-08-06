package com.techlabs.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.app.entity.Address;
import com.techlabs.app.entity.Employee;
import com.techlabs.app.exception.EmployeeNotFoundException;
import com.techlabs.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.findAllEmployees();
	}
	
	@PostMapping
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.findById(id);
		
	}
	
	@PutMapping("/update/{id}")
	public  Employee updateEmployee(@RequestBody Employee employee) {
		Employee employee1=employeeService.getEmployeeById(employee.getId());
		if(employee1!=null) {
			return employeeService.saveEmployee(employee);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployeeByid(@PathVariable int id) {
		employeeService.deleteById(id);
	}
	
	@GetMapping("/address/{id}")
	public Employee getEmployeeByAddressId(@PathVariable int id) {
		return employeeService.getEmployeeByAddressId(id);
	}
	
}
