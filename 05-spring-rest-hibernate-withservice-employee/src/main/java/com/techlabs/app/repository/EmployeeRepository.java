package com.techlabs.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.techlabs.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  List<Employee> findByName(String name);

  Employee findByEmail(String email);

  List<Employee> findByActive(boolean active);

  List<Employee> findByNameStartingWith(String prefix);

  List<Employee> findBySalaryGreaterThanAndDesignation(double salary, String designation);

  List<Employee> findBySalaryBetween(double startSalary, double endSalary);

  List<Employee> findByActiveAndSalaryGreaterThan(boolean active, double salary);

  long countByActive(boolean active);

  long countByDesignation(String designation);
}










































/*package com.techlabs.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techlabs.app.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	

	List<Employee> findByEmail(String email);

	List<Employee> findByActive(Boolean active);

	List<Employee> findByName(String name);
	List<Employee> findByNameStartingWith(String prefix);
	
	List<Employee> findBySalaryBetween(double start, double end);

	

	int countActiveEmployees();

	List<Employee> findBySalaryGreaterThanAndDesignation(double salary, String designation);

	List<Employee> findBySalaryGreaterThan(boolean b, double salary);


	List<Employee> findByActiveAndSalaryGreaterThan(boolean b, double salary);

	public int countByDesignation(String designation);

	int countByActive(boolean b);

}
*/