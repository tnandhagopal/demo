package com.example.demo.weekview;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.employeeproject.EmployeeProjectService;
import com.example.demo.employeetimesheet.EmployeeTimeSheetService;
import com.example.demo.project.ProjectService;

@Service
public class WeekViewService {

	@Autowired
	private EmployeeTimeSheetService employeeTimeSheetService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private EmployeeProjectService employeeProjectService;

	private LocalDate firstOfCurrentWeek = LocalDate.now().with(ChronoField.DAY_OF_WEEK, 1);

	public LocalDate getFirstOfCurrentWeek() {
		return firstOfCurrentWeek;
	}

	public List<WeekView> getAll() {

		List<WeekView> retList = new ArrayList<WeekView>();

		projectService.getAll().stream().forEach(pro -> retList
				.add(new WeekView(employeeTimeSheetService.getAllEmployeeTimeSheet(), pro, firstOfCurrentWeek)));
		return retList;

	}

	public List<WeekView> getByEmployee(Employee employee, String action) {

		System.out.println(action + " : " + firstOfCurrentWeek);

		if (action == null) {
			firstOfCurrentWeek = LocalDate.now().with(ChronoField.DAY_OF_WEEK, 1);
		} else if (action.equalsIgnoreCase("next")) {
			firstOfCurrentWeek = firstOfCurrentWeek.plusWeeks(1);
		} else if (action.equalsIgnoreCase("previous")) {
			firstOfCurrentWeek = firstOfCurrentWeek.minusWeeks(1);
		} else {
			firstOfCurrentWeek = LocalDate.now().with(ChronoField.DAY_OF_WEEK, 1);
		}

		System.out.println(action + " : " + firstOfCurrentWeek);

		List<WeekView> retList = new ArrayList<WeekView>();

		employeeProjectService.getEmployeeProjectByEmployee(employee).stream()
				.forEach(employeeProject -> retList.add(new WeekView(
						employeeTimeSheetService.getEmployeeTimeSheetByEmpoyeeProjectAndDate(employeeProject,
								firstOfCurrentWeek, firstOfCurrentWeek.plusDays(6)),
						employeeProject.getProject(), firstOfCurrentWeek)));
		;

		return retList;

	}

}
