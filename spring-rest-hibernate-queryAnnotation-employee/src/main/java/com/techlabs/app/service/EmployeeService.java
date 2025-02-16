package com.techlabs.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.techlabs.app.entity.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {
	
	Optional<Employee> findByName(String name);

   
    Optional<Employee> findByEmail(String email);

   
    List<Employee> findAllActive();

    List<Employee> findByNameStartingWithS();

    List<Employee> findBySalaryGreaterThanAndDepartment(double salary, String department);

    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

    List<Employee> findAllActiveAndSalaryGreaterThan(double salary);

    Long countActiveEmployees();


    
	Employee saveEmployee(Employee employee);


	Employee updateEmployee(Long id, Employee employee);


	//void deleteEmployee(Long id);


	//void deleteEmployee(Integer id);


//	void deleteEmployee(Long id);


	Employee getEmployeeById(int id);


	void deleteEmployee(Employee employee1);

	List<Employee> getAllEmployees(Employee employee);


	//Employee getAllEmployees();


	

//    Long countEmployeesInSalesDepartment();


}
