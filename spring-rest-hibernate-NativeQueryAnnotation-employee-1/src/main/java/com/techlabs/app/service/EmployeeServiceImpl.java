package com.techlabs.app.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.app.dto.EmployeeDTO;
import com.techlabs.app.dto.EmployeeResponseDTO;
import com.techlabs.app.entity.Employee;
import com.techlabs.app.exception.EmployeeNotFoundException;
import com.techlabs.app.exception.ResourceNotFoundException;
import com.techlabs.app.repository.EmployeeRepository;
import com.techlabs.app.utils.PagedResponse;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	 @Autowired
	  private EmployeeRepository employeeRepository;
	   
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

	@Override
	public List<Employee> findAllActiveEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAllActiveEmployees();
	}

	@Override
	public List<Employee> findEmployeesByNameStartingWith(String prefix) {
		return employeeRepository.findByNameStartingWith(prefix);
	}

	@Override
	public List<Employee> findEmployeesBySalaryGreaterThanAndDesignation(double salary, String designation) {
		
		return employeeRepository.findBySalaryGreaterThanAndDesignation(salary, designation);
	}

	@Override
	public List<Employee> findEmployeesBySalaryBetween(double startSalary, double endSalary) {
		// TODO Auto-generated method stub
		return employeeRepository.findBySalaryBetween(startSalary, endSalary);
	}

	@Override
	public List<Employee> findActiveEmployeesWithSalaryGreaterThan(double salary) {
		return employeeRepository.findActiveEmployeesWithSalaryGreaterThan(salary);
	}

	@Override
	public long countActiveEmployees() {
		
		return employeeRepository.countActiveEmployees();
	}

	@Override
	public long countEmployeesByDesignation(String designation) {
		// TODO Auto-generated method stub
		return employeeRepository.countEmployeesByDesignation(designation);
	}

	public EmployeeResponseDTO saveAndUpdate(@Valid EmployeeDTO employeeDTO) {
	    Employee employee = convertEmployeeDtoToObject(employeeDTO);
	    Employee savedEmployee = employeeRepository.save(employee);
	    return convertEmployeeToResponseDTO(savedEmployee);
	  }

	  private Employee convertEmployeeDtoToObject(EmployeeDTO employeeDTO) {
	    Employee employee = new Employee();
	    if (employeeDTO.getId() != 0) {
	      employee.setId(employeeDTO.getId());
	    }
	    employee.setName(employeeDTO.getName());
	    employee.setEmail(employeeDTO.getEmail());
	    employee.setDesignation(employeeDTO.getDesignation());
	    employee.setSalary(employeeDTO.getSalary());
	    employee.setActive(employeeDTO.isActive());
	    return employee;
	  }

	  @Override
	  public EmployeeResponseDTO convertEmployeeToResponseDTO(Employee employee) {
	    EmployeeResponseDTO employeeDTO = new EmployeeResponseDTO();
	    employeeDTO.setName(employee.getName());
	    employeeDTO.setEmail(employee.getEmail());
	    employeeDTO.setDesignation(employee.getDesignation());
	    employeeDTO.setActive(employee.isActive());
	    return employeeDTO;
	  }

  @Override
  public PagedResponse<EmployeeResponseDTO> getAllEmployees(int page,int size,String sortBy,String direction) {
	  Sort sort = direction.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
	  Pageable pegeable= PageRequest.of(page, size,sort);
	  Page<Employee> page1=employeeRepository.findAll(pegeable);
	  List<Employee> employees=page1.getContent();
	//  List<EmployeeResponseDTO> responseList=getResponseList(employees);
	  List<EmployeeResponseDTO> list=page1.getContent().stream().map(this::convertEmployeeToResponseDTO).collect(Collectors.toList());
	  return new PagedResponse<>(list, page1.getNumber(),page1.getSize(),page1.getTotalElements(),page1.getTotalPages(),page1.isLast()); 
	  //return new PagedResponse<EmployeeResponseDTO>(( ((PagedResponse<EmployeeResponseDTO>) responseList).getContent(),
			//  page1.getNumber(),page1.getSize(),page1.getTotalElements(),page1.getTotalPages(),page1.isLast()); 
	  //List<Employee> employees=page1.getContent();
	  //if(employees.isEmpty()) {
		//  throw new EmployeeNotFoundException("no emploee found add smeone");
		  
//	  }
    //return (PagedResponse<Employee>) convertEmployeeToResponseDTO((Employee) employees);
}


	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(EmployeeResponseDTO employee) {
		// TODO Auto-generated method stub
		
	}

	 @Override
	  public EmployeeResponseDTO getEmployeeById(int id) {
		  
		  Employee employee = employeeRepository.findById(id)
	              .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
	      return convertEmployeeToResponseDTO(employee);
		  
	  //  return employeeRepository.findById(id).orElse(null);
	  }

	@Override
	public Employee saveAndUpdate(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	
	  	
	

	
	}