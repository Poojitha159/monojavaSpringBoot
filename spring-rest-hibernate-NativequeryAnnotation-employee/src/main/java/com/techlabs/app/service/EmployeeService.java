package com.techlabs.app.service;

import java.util.List;

import com.techlabs.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findByName(String name);
    Employee findByEmail(String email);
    List<Employee> findAllActive();
    List<Employee> findByNameStartingWithS();
    List<Employee> findBySalaryGreaterThanAndDepartment(double salary, String department);
    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);
    List<Employee> findAllActiveEmployeesWithSalaryGreaterThan(double salary);
    long countActiveEmployees();
    
    // Add, update, delete
    void addEmployee(Employee employee);
    void updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);

}
