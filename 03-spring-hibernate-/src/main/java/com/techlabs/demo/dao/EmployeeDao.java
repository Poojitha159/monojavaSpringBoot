package com.techlabs.demo.dao;

import java.util.List;

import com.techlabs.demo.entity.Employee;

public interface EmployeeDao {

	public void save(Employee employee) ;

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int i);

	public List<Employee> getEmployeeByName(String string);

	public List<Employee> getEmployeesBySalary(double i);

	public void updateEmployeeWithoutQuery(Employee employee);

	public void updateEmployeeWithQuery(Employee employee);

	public void deleteEmployeesAboveEight(int i);

}
