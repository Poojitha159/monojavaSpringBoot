package com.techlabs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.techlabs.app.service.EmployeeService;
import com.techlabs.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/findByName")
    public List<Employee> findByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/findByEmail")
    public Employee findByEmail(@RequestParam String email) {
        return employeeService.findByEmail(email);
    }

    @GetMapping("/findAllActive")
    public List<Employee> findAllActive() {
        return employeeService.findAllActive();
    }

    @GetMapping("/findByNameStartingWithS")
    public List<Employee> findByNameStartingWithS() {
        return employeeService.findByNameStartingWithS();
    }

    @GetMapping("/findBySalaryAndDepartment")
    public List<Employee> findBySalaryGreaterThanAndDepartment(@RequestParam double salary, @RequestParam String department) {
        return employeeService.findBySalaryGreaterThanAndDepartment(salary, department);
    }

    @GetMapping("/findBySalaryBetween")
    public List<Employee> findBySalaryBetween(@RequestParam double minSalary, @RequestParam double maxSalary) {
        return employeeService.findBySalaryBetween(minSalary, maxSalary);
    }

    @GetMapping("/findAllActiveEmployeesWithSalaryGreaterThan")
    public List<Employee> findAllActiveEmployeesWithSalaryGreaterThan(@RequestParam double salary) {
        return employeeService.findAllActiveEmployeesWithSalaryGreaterThan(salary);
    }

    @GetMapping("/countActiveEmployees")
    public long countActiveEmployees() {
        return employeeService.countActiveEmployees();
    }

   /* @GetMapping("/countEmployeesInSalesDepartment")
    public long countEmployeesInSalesDepartment() {
        return employeeService.countEmployeesInSalesDepartment();
    }
*/
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.ok("Employee added successfully.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok("Employee updated successfully.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}