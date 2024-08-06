package com.techlabs.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.app.entity.Employee;
import com.techlabs.app.exception.EmployeeNotFoundException;
import com.techlabs.app.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private  EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Optional<Employee> findByName(String name) {
		
		return employeeRepository.findByName(name);
	}

	@Override
	public Optional<Employee> findByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

	@Override
	public List<Employee> findAllActive() {
		return employeeRepository.findAllActive();
	}

	@Override
	public List<Employee> findByNameStartingWithS() {
		
		return employeeRepository.findByNameStartingWithS();
	}

	@Override
	public List<Employee> findBySalaryGreaterThanAndDepartment(double salary, String department) {
		return employeeRepository.findBySalaryGreaterThanAndDepartment(salary, department);
	}

	@Override
	public List<Employee> findBySalaryBetween(double minSalary, double maxSalary) {
		
		return employeeRepository.findBySalaryBetween(minSalary, maxSalary);
	}

	@Override
	public List<Employee> findAllActiveAndSalaryGreaterThan(double salary) {
		
		return employeeRepository.findAllActiveAndSalaryGreaterThan(salary);
	}

	@Override
	public Long countActiveEmployees() {
		
		return employeeRepository.countActiveEmployees();
	}

	@Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        employeeRepository.findById(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setActive(employee.isActive());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }

  /*  @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
*/
	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteEmployee(Employee employee1) {
		employeeRepository.delete(employee1);
		
	}

	@Override
	public List<Employee> getAllEmployees(Employee employee) {
		if(((List<Employee>) employee).isEmpty()) {
			 throw new EmployeeNotFoundException("no emploee found add smeone");	  
	  }
		return employeeRepository.findAll();
	}
	/*@Override
	public Long countEmployeesInSalesDepartment() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
