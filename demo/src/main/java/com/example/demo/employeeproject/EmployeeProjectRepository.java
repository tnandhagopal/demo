package com.example.demo.employeeproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.employee.Employee;

public interface EmployeeProjectRepository extends CrudRepository<EmployeeProject, String> {
	List<EmployeeProject> findByEmployee(Employee employee);
}
