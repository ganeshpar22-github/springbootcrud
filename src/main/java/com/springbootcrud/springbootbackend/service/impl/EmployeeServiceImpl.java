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



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		/*first we are checking that employee with given id is present
		or not in the database*/
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "Id", id));
		
		//here we set the field which need to update
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setAddress(employee.getAddress());
		
		
		//to save the changes
		
		employeeRepository.save(existingEmployee);
		
		
		return existingEmployee;
	}



	@Override
	public void deleteEmployee(long id) {
		
		//first we have to give condition that the id we are passing is
		//present or not in the database
		
		employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
		
		
	}

	
	
}
