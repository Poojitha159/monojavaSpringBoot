package com.techlabs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techlabs.app.entity.Address;
import com.techlabs.app.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Employee save(Employee employee);

	//@Query("select e from Address e where e.address.id=:id")
	//Address findByAddressId(int id);

}
