
package com.techlabs.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.techlabs.app.dto.EmployeeDTO;
import com.techlabs.app.dto.EmployeeResponseDTO;
import com.techlabs.app.entity.Employee;
import com.techlabs.app.util.PagedResponse;

import jakarta.validation.Valid;

public interface EmployeeService {

 // PagedResponse<EmployeeResponseDTO> getAllEmployees();

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

}




































/*package com.techlabs.app.service;

import java.util.List;

import com.techlabs.app.entity.Employee;

public interface EmployeeService {

 public	List<Employee> getAllEmployees();

public Employee getEmployeeById(int id);

public Employee saveAndUpdate(Employee employee);

public void deleteStudent(Employee employee);

public List<Employee> findEmployeeByName(String name);

public List<Employee> findEmployeeByEmail(String email);



public List<Employee> findByNameStartingWith(String prefix);



//public List<Employee> findByActiveAndSalaryGreaterThan(boolean b, double salary);

public int countActiveEmployees();



public List<Employee> getEmployeesGreaterThanAndDesignation(double salary, String designation);

public List<Employee> getEmployeeSalaryBetween(Double startSalary, Double endSalary);





List<Employee> findByActiveAndSalaryGreaterThan(boolean b, double salary);

public int getEmployeeCountAndDesignation(String designation);

List<Employee> findEmployeeByActive();



}*/
