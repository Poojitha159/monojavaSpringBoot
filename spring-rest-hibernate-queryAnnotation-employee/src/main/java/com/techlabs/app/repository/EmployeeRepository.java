package com.techlabs.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techlabs.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query("SELECT e FROM Employee e WHERE e.name = ?1")
    Optional<Employee> findByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Optional<Employee> findByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.active = true")
    List<Employee> findAllActive();

    @Query("SELECT e FROM Employee e WHERE e.name LIKE 'S%'")
    List<Employee> findByNameStartingWithS();

    @Query("SELECT e FROM Employee e WHERE e.salary > 10000 AND e.department = ?1")
    List<Employee> findBySalaryGreaterThanAndDepartment(double salary, String department);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN 5000 AND 15000")
    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

    @Query("SELECT e FROM Employee e WHERE e.active = true AND e.salary > 10000")
    List<Employee> findAllActiveAndSalaryGreaterThan(double salary);

    @Query("SELECT COUNT(e) FROM Employee e WHERE e.active = true")
    Long countActiveEmployees();

	Optional<Employee> findById(Long id);

	@Query(value="insert into e (name,email,active,salary,department) values(:name,:email,:active,:salary,:department)",nativeQuery=true)
	void saveEmployee(@Param("name") String name,@Param("email") String email,@Param("active") boolean active,@Param("salary") double salary,@Param("department") String department);

	@Query(value = "UPDATE e SET name = :name, email = :email, active = :active, salary = :salary, department = :department WHERE id = :id", nativeQuery = true)
	void updateEmployee(@Param("id") Long id, @Param("name") String name, @Param("email") String email, @Param("active") boolean active,@Param("salary") double salary, @Param("department") String department);
 
	@Query(value = "DELETE FROM e WHERE id = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Long id);
	

 //   @Query("SELECT COUNT(e) FROM Employee e WHERE e.department = 'Sales'")
   // Long countEmployeesInSalesDepartment();

}
