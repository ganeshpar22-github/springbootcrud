package com.springbootcrud.springbootbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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

	
	
}
