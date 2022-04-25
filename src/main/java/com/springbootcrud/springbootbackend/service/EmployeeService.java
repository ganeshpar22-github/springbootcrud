package com.springbootcrud.springbootbackend.service;

import java.util.List;

import com.springbootcrud.springbootbackend.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);

}
