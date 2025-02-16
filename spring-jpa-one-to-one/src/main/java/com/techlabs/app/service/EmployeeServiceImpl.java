package com.techlabs.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techlabs.app.entity.Address;
import com.techlabs.app.entity.Employee;
import com.techlabs.app.exception.ResourceNotFoundException;
import com.techlabs.app.repository.AddressRepository;
import com.techlabs.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	private AddressRepository addressRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.addressRepository = addressRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		return employeeRepository.findAll();
	}
	

	@Override
	public Employee findById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);	
	}

	@Override
	public Employee getEmployeeById(int id) {
		// Employee employee = employeeRepository.findById(id)
	      //        .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
	      //return Employee(employee);
		 return employeeRepository.findById(id).orElse(null);
	}


	@Override
	public Employee getEmployeeByAddressId(int id) {
		Optional<Address> optionalAsress=addressRepository.findById(id);
		if(optionalAsress.isPresent()) {
		
			Address addrees=optionalAsress.get();
			Employee employee=addrees.getEmployee();
			
			return employee;
		}
		
	
	return null;


	}
	}
