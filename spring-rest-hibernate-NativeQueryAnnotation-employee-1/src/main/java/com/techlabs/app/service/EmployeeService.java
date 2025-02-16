package com.techlabs.app.service;

import java.util.List;

import com.techlabs.app.dto.EmployeeDTO;
import com.techlabs.app.dto.EmployeeResponseDTO;
import com.techlabs.app.entity.Employee;
import com.techlabs.app.utils.PagedResponse;

import jakarta.validation.Valid;

public interface EmployeeService {
	
	Employee saveAndUpdate(Employee employee);

	  //Employee getEmployeeById(int id);
	  EmployeeResponseDTO getEmployeeById(int id);

	 // void deleteEmployee(Employee employee);
	  void deleteEmployee(Employee employee);
	  List<Employee> findEmployeeByName(String name);

	  Employee findEmployeeByEmail(String email);

	  List<Employee> findAllActiveEmployees();

	  List<Employee> findEmployeesByNameStartingWith(String prefix);

	  List<Employee> findEmployeesBySalaryGreaterThanAndDesignation(double salary, String designation);

	  List<Employee> findEmployeesBySalaryBetween(double startSalary, double endSalary);

	  List<Employee> findActiveEmployeesWithSalaryGreaterThan(double salary); // New method

	  long countActiveEmployees();

	  long countEmployeesByDesignation(String designation);

	  EmployeeResponseDTO convertEmployeeToResponseDTO(Employee employee);
	  EmployeeResponseDTO saveAndUpdate(@Valid EmployeeDTO employeeDTO);

	void deleteEmployee(EmployeeResponseDTO employee);

	PagedResponse<EmployeeResponseDTO> getAllEmployees(int page, int size,String sortBy,String direction);

	//EmployeeDTO getEmployeeById(Long id);

//	EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

	//EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

	void deleteEmployee(Long id);

}
