package com.techlabs.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.app.repository.EmployeeRepository;
import com.techlabs.entity.Employee;

@Service

public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee findByEmail(String email) {
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
    public List<Employee> findAllActiveEmployeesWithSalaryGreaterThan(double salary) {
        return employeeRepository.findAllActiveEmployeesWithSalaryGreaterThan(salary);
    }

    @Override
    public long countActiveEmployees() {
        return employeeRepository.countActiveEmployees();
    }

 /*   @Override
    public long countEmployeesInSalesDepartment() {
        return employeeRepository.countEmployeesInSalesDepartment();
    }
*/
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            employeeRepository.save(employee);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


}
