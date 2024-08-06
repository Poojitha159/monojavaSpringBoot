package com.techlabs.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techlabs.demo.dao.EmployeeDao;

import com.techlabs.demo.entity.Employee;


@SpringBootApplication
public class Application implements CommandLineRunner{

	private EmployeeDao employeeDao;
	
	
	
	public Application(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("HelloWorld");
		//addEmployee();
		//getAllEmployees();
		//getEmployeeById();
		//getEmployeeByName();
		//getEmployeesBySalary();
		//updateEmployeeWithoutQuery();
		//updateEmployeeWithQuery();
		deleteEmployeesAboveEight();
		
		
	}

	

	private void deleteEmployeesAboveEight() {
		employeeDao.deleteEmployeesAboveEight(8);	
		
	}


	private void updateEmployeeWithQuery() {
		Employee employee=new Employee(8,"Sushma",(double) 15000);
		employeeDao.updateEmployeeWithQuery(employee);
	}


	private void updateEmployeeWithoutQuery() {
		Employee employee=new Employee(6,"prateekNarayan",(double) 12000);
		employeeDao.updateEmployeeWithoutQuery(employee);
		
	}


	private void getEmployeesBySalary() {
		List<Employee> employee=employeeDao.getEmployeesBySalary(12000);
		for(Employee e:employee) {
			System.out.println(e);
		}
		
	}


	private void getEmployeeByName() {
		List<Employee> employee=employeeDao.getEmployeeByName("Lakshmi");
		for(Employee e:employee) {
			System.out.println(e);
		}
	}


	private void getEmployeeById() {
	
		Employee employee=employeeDao.getEmployeeById(5);
		if(employee!=null) {
			System.out.println(employee);
		}
		else {
			System.out.println("not found employee by this ID");
		}
	}


	private void getAllEmployees() {
		List<Employee> employee=employeeDao.getAllEmployees();
		for(Employee e:employee) {
			System.out.println(e);
		}
		
	}
	private void addEmployee() {
		Employee employee=new Employee("Lakshmi",10000);
		employeeDao.save(employee);
		
	}


}
