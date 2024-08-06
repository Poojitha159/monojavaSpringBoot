package com.techlabs.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techlabs.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query(value = "SELECT * FROM employees WHERE name = ?1", nativeQuery = true)
    List<Employee> findByName(String name);

    @Query(value = "SELECT * FROM employees WHERE email = ?1", nativeQuery = true)
    Employee findByEmail(String email);

    @Query(value = "SELECT * FROM employees WHERE active = true", nativeQuery = true)
    List<Employee> findAllActive();

    @Query(value = "SELECT * FROM employees WHERE name LIKE 'S%'", nativeQuery = true)
    List<Employee> findByNameStartingWithS();

    @Query(value = "SELECT * FROM employees WHERE salary > 10000 AND department = 'HR'", nativeQuery = true)
    List<Employee> findBySalaryGreaterThanAndDepartment(double salary, String department);

    @Query(value = "SELECT * FROM employees WHERE salary BETWEEN 5000 AND 15000", nativeQuery = true)
    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

    @Query(value = "SELECT * FROM employees WHERE active = true AND salary > 10000", nativeQuery = true)
    List<Employee> findAllActiveEmployeesWithSalaryGreaterThan(double salary);

    @Query(value = "SELECT COUNT(*) FROM employees WHERE active = true", nativeQuery = true)
    long countActiveEmployees();

//    @Query(value = "SELECT COUNT(*) FROM employees WHERE department = 'Sales'", nativeQuery = true)
 //   long countEmployeesInSalesDepartment();

}
