package com.example.demo.employeetimesheet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employeeproject.EmployeeProject;

@Service
public class EmployeeTimeSheetService {

	@Autowired
	private EmployeeTimeSheetRepository etsRepo;

	public List<EmployeeTimeSheet> getAllEmployeeTimeSheet() {
		List<EmployeeTimeSheet> retList = new ArrayList<EmployeeTimeSheet>();
		etsRepo.findAll().forEach(retList::add);
		return retList;
	}

	public List<EmployeeTimeSheet> getEmployeeTimeSheetByEmpoyeeProject(EmployeeProject employeeProject) {
		List<EmployeeTimeSheet> retList = new ArrayList<EmployeeTimeSheet>();
		etsRepo.findByEmployeeProject(employeeProject).forEach(retList::add);
		return retList;
	}

	public List<EmployeeTimeSheet> getEmployeeTimeSheetByEmpoyeeProjectAndDate(EmployeeProject employeeProject,
			LocalDate startDate, LocalDate endDate) {
		List<EmployeeTimeSheet> retList = new ArrayList<EmployeeTimeSheet>();
		etsRepo.findByEmployeeProjectAndDateBetween(employeeProject, startDate, endDate).forEach(retList::add);
		return retList;
	}

}
