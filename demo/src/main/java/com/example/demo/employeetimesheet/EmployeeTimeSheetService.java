package com.example.demo.employeetimesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

	public boolean setEmployeeTimeSheet(EmployeeProject employeeProject, LocalDate date, int time) {
		String txt = null;
		boolean save = false;

		System.out.println("setEmployeeTimeSheet : " + employeeProject + " : " + date + " : " + time);

		EmployeeTimeSheet employeeTimeSheet = etsRepo.findByEmployeeProjectAndDate(employeeProject, date);
		System.out.println("setEmployeeTimeSheet : " + employeeTimeSheet);

		if (employeeTimeSheet == null & time > 0) {
			employeeTimeSheet = new EmployeeTimeSheet(employeeProject, date, time);
			txt = "created";
			save = true;
		} else if (employeeTimeSheet != null) {

			if (employeeTimeSheet.getTime() != time & time < 24) {
				employeeTimeSheet.setTime(time);
				employeeTimeSheet.setUpdatedBy("ADMIN");
				employeeTimeSheet.setUpdatedDate(LocalDateTime.now());
				txt = "updated";
				save = true;
			}
		}

		if (save) {
			employeeTimeSheet = etsRepo.save(employeeTimeSheet);
			System.out.println(txt + " employeeTimeSheet id : " + employeeTimeSheet.getId());
		} else if (employeeTimeSheet != null) {
			System.out.println("not updated/inserted employeeTimeSheet id : " + employeeTimeSheet.getId());
		} else {
			System.out.println("not updated/inserted employeeTimeSheet id : ");
		}

		return true;
	}
}
