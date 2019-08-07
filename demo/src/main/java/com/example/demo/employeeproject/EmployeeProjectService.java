package com.example.demo.employeeproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.project.Project;

@Service
public class EmployeeProjectService {

	@Autowired
	private EmployeeProjectRepository employeeProjectRepository;

	public List<EmployeeProject> getEmployeeProjectByEmployee(Employee employee) {

		return employeeProjectRepository.findByEmployee(employee);

	}

	public EmployeeProject getEmployeeProjectByEmployeeAndProject(Employee employee, Project project) {
		return employeeProjectRepository.findByEmployeeAndProject(employee, project);
	}
}
