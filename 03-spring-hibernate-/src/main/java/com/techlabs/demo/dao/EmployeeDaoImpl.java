package com.techlabs.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.techlabs.demo.entity.Employee;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	EntityManager entityManager;
	
	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Employee employee) {
		this.entityManager.persist(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e",Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(int i) {
		Employee employee = entityManager.find(Employee.class, i);
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> getEmployeeByName(String string) {
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where empName=?1",Employee.class);
		query.setParameter(1, string);
		return query.getResultList();
	}

	@Override
	public List<Employee> getEmployeesBySalary(double i) {
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where salary=?1",Employee.class);
		query.setParameter(1,i);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void updateEmployeeWithoutQuery(Employee employee) {
		Employee employee2 = entityManager.find(Employee.class, employee.getId());
		if(employee2!=null) {
			this.entityManager.merge(employee);
		}else {
			System.out.println("No Employee found with ID ");
		}
		
	}

	@Override
	@Transactional
	public void updateEmployeeWithQuery(Employee employee) {
		Employee employee2 = entityManager.find(Employee.class, employee.getId());
		if(employee2!=null) {
			Query query=entityManager.createQuery("update Employee e set  e.empName=?1 , e.salary=?2 where id=?3");
			query.setParameter(1, employee.getEmpName());
			query.setParameter(2,employee.getSalary());
			query.setParameter(3,employee.getId());
			
			int res=query.executeUpdate();
			System.out.println("no of rows effectefd "+res);
		}
		else {
		
			System.out.println("No Employee found with ID ");

		}
		
	}

	@Override
	@Transactional
	public void deleteEmployeesAboveEight(int id) {

		Query query=entityManager.createQuery("delete from Employee e where e.id>?1");
		query.setParameter(1, id);
		int res=query.executeUpdate();
		System.out.println("No oof rows effected"+res);
	
	}

	

}
