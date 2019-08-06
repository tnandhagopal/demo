package com.example.demo.employeetimesheet;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.employeeproject.EmployeeProject;

public interface EmployeeTimeSheetRepository extends CrudRepository<EmployeeTimeSheet, String> {
	List<EmployeeTimeSheet> findByEmployeeProject(EmployeeProject employeeProject);

	List<EmployeeTimeSheet> findByEmployeeProjectAndDateBetween(EmployeeProject employeeProject, LocalDate startDate,
			LocalDate endDate);

}
