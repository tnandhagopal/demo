package com.example.demo.employeeproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.employee.Employee;
import com.example.demo.project.Project;

@Repository
public interface EmployeeProjectRepository extends CrudRepository<EmployeeProject, String> {
	List<EmployeeProject> findByEmployee(Employee employee);

	EmployeeProject findByEmployeeAndProject(Employee employee, Project project);
}
