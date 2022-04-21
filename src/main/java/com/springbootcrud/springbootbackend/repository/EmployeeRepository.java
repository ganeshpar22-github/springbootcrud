package com.springbootcrud.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootcrud.springbootbackend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
