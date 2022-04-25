package com.springbootcrud.springbootbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootcrud.springbootbackend.exception.ResourceNotFoundException;
import com.springbootcrud.springbootbackend.model.Employee;
import com.springbootcrud.springbootbackend.repository.EmployeeRepository;
import com.springbootcrud.springbootbackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
		
		
		//instead of above if-else we can also use lambda expression
		
//		return employeeRepository.findById(id).orElseThrow(()->
//		new ResourceNotFoundException("Employee", "Id", id));
		
	}

	
	
}
