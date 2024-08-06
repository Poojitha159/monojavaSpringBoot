package com.techlabs.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techlabs.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	
	    @Query("SELECT e FROM Employee e WHERE e.name = :name") List<Employee>
	    findByName(@Param("name") String name);
	    
	    @Query("SELECT e FROM Employee e WHERE e.email = :email") Employee
	    findByEmail(@Param("email") String email);
	    
	    @Query("SELECT e FROM Employee e WHERE e.active = true") List<Employee>
	    findAllActiveEmployees();
	    
	    @Query("SELECT e FROM Employee e WHERE e.name LIKE :prefix%") List<Employee>
	    findByNameStartingWith(@Param("prefix") String prefix);
	    
	    @Query("SELECT e FROM Employee e WHERE e.salary > :salary AND e.designation = :designation"
	    ) List<Employee> findBySalaryGreaterThanAndDesignation(@Param("salary")
	    double salary,
	    
	    @Param("designation") String designation);
	    
	    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :startSalary AND :endSalary"
	    ) List<Employee> findBySalaryBetween(@Param("startSalary") double
	    startSalary, @Param("endSalary") double endSalary);
	    
	    @Query("SELECT e FROM Employee e WHERE e.active = true AND e.salary > :salary"
	    ) List<Employee> findActiveEmployeesWithSalaryGreaterThan(@Param("salary")
	    double salary);
	    
	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.active = true") long
	    countActiveEmployees();
	    
	    @Query("SELECT COUNT(e) FROM Employee e WHERE e.designation = :designation")
	    long countEmployeesByDesignation(@Param("designation") String designation);
	  

	/*  @Query(value = "SELECT * FROM emp WHERE name = :name", nativeQuery = true)
	  List<Employee> findByName(@Param("name") String name);

	  @Query(value = "SELECT * FROM emp WHERE email = :email", nativeQuery = true)
	  Employee findByEmail(@Param("email") String email);

	  @Query(value = "SELECT * FROM emp WHERE active = true", nativeQuery = true)
	  List<Employee> findAllActiveEmployees();

	  @Query(value = "SELECT * FROM emp WHERE name LIKE :prefix%", nativeQuery = true)
	  List<Employee> findEmployeesByNameStartingWith(@Param("prefix") String prefix);

	  @Query(value = "SELECT * FROM emp WHERE salary > :salary AND designation = :designation", nativeQuery = true)
	  List<Employee> findBySalaryGreaterThanAndDesignation(@Param("salary") double salary,
	      @Param("designation") String designation);

	  @Query(value = "SELECT * FROM emp WHERE salary BETWEEN :startSalary AND :endSalary", nativeQuery = true)
	  List<Employee> findEmployeesBySalaryBetween(@Param("startSalary") double startSalary,
	      @Param("endSalary") double endSalary);

	  @Query(value = "SELECT * FROM emp WHERE active = true AND salary > :salary", nativeQuery = true)
	  List<Employee> findActiveEmployeesWithSalaryGreaterThan(@Param("salary") double salary);

	  @Query(value = "SELECT COUNT(*) FROM emp WHERE active = true", nativeQuery = true)
	  long countActiveEmployees();

	  @Query(value = "SELECT COUNT(*) FROM emp WHERE designation = :designation", nativeQuery = true)
	  long countEmployeesByDesignation(@Param("designation") String designation);

	  Optional<Employee> findById(Long id);

	//Employee findByEmail(String email);
	*/
}
