package com.techlabs.app.controller;
import com.techlabs.app.service.EmployeeService;


import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.techlabs.app.entity.Employee;
import com.techlabs.app.exception.EmployeeNotFoundException;
import com.techlabs.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public  ResponseEntity<List<Employee>> getAllEmployees(Employee employee){
		//System.out.println(page);
		//System.out.println(size);
		List<Employee> employees = employeeService.getAllEmployees(employee);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee employee = employeeService.getEmployeeById(id);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	@PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

  /*  @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
    */

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
		Employee employee1 = employeeService.getEmployeeById(id);
		if (employee1 == null) {
			throw new EmployeeNotFoundException("Employee with ID " + id + " not found for deletion");
		}
		employeeService.deleteEmployee(employee1);
		return new ResponseEntity<>(HttpStatus.OK);
	}
    
	@GetMapping("/name/{name}")
	public ResponseEntity<Optional<Employee>> getEmployeeByName(@PathVariable String name){
		return ResponseEntity.ok(employeeService.findByName(name));
		
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Optional<Employee>> getEmployeeByEmail(@PathVariable String email){
		return ResponseEntity.ok(employeeService.findByEmail(email));
		
	}
	
	@GetMapping("/active")
    public ResponseEntity<List<Employee>> getAllActiveEmployees() {
        return ResponseEntity.ok(employeeService.findAllActive());
    }

    @GetMapping("/name-starts-with-s")
    public ResponseEntity<List<Employee>> getEmployeesNameStartingWithS() {
        return ResponseEntity.ok(employeeService.findByNameStartingWithS());
    }

    @GetMapping("/salary/{salary}/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesBySalaryAndDepartment(@PathVariable double salary, @PathVariable String department) {
        return ResponseEntity.ok(employeeService.findBySalaryGreaterThanAndDepartment(salary, department));
    }

    @GetMapping("/salary-range")
    public ResponseEntity<List<Employee>> getEmployeesBySalaryRange(@RequestParam double minSalary, @RequestParam double maxSalary) {
        return ResponseEntity.ok(employeeService.findBySalaryBetween(minSalary, maxSalary));
    }

    @GetMapping("/salaryBetween/{startSalary}/{endSalary}")
	public ResponseEntity<List<Employee>> findEmployeesBySalaryBetween(@PathVariable("startSalary") double startSalary,
			@PathVariable("endSalary") double endSalary) {
		List<Employee> employees = employeeService.findEmployeesBySalaryBetween(startSalary, endSalary);
		if (employees.isEmpty()) {
			throw new EmployeeNotFoundException(
					"No employees found with salary between " + startSalary + " and " + endSalary);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
    @GetMapping("/active-and-salary-greater-than/{salary}")
    public ResponseEntity<List<Employee>> getActiveEmployeesWithSalaryGreaterThan(@PathVariable double salary) {
        return ResponseEntity.ok(employeeService.findAllActiveAndSalaryGreaterThan(salary));
    }

    @GetMapping("/count-active")
    public ResponseEntity<Long> countActiveEmployees() {
        return ResponseEntity.ok(employeeService.countActiveEmployees());
    }


}
