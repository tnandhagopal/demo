package com.example.demo.weekview;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.employeeproject.EmployeeProjectService;
import com.example.demo.employeetimesheet.EmployeeTimeSheetService;
import com.example.demo.project.Project;
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

	public void save(Employee employee, WeekViewDto weekviewdto) {

		System.out.println("firstOfCurrentWeek : " + firstOfCurrentWeek);
		List<WeekView> getList = getByEmployee(employee, null);
		if (weekviewdto != null)
			System.out.println("form.getWeekviews().size() = " + weekviewdto.getWeekviews().size());
		weekviewdto.getWeekviews().stream().forEach(e -> {

			Project pro = e.getProject();
			if (pro != null) {
				System.out.println("pro_id=" + e.getProject().getId());
				System.out.println("pro_name=" + e.getProject().getName());
				// getList.stream().filter(weekview -> e.getProject().getId().equals(weekview.)
				WeekView weekview = getList.stream().filter(x -> (e.getProject().getId() == x.getProject().getId()))
						.findAny().orElse(null);
				if (weekview != null) {
					if (weekview.getSun() != e.getSun()) {
						System.out.println("Sun day not matched");
						update(employee, weekview.getProject(), DayOfWeek.SUNDAY, e.getSun());
					}
					if (weekview.getMon() != e.getMon()) {
						System.out.println("Mon day not matched");
						update(employee, weekview.getProject(), DayOfWeek.MONDAY, e.getMon());
					}
					if (weekview.getTus() != e.getTus()) {
						System.out.println("Tus day not matched");
						update(employee, weekview.getProject(), DayOfWeek.TUESDAY, e.getTus());
					}
					if (weekview.getWed() != e.getWed()) {
						System.out.println("Wed day not matched");
						update(employee, weekview.getProject(), DayOfWeek.WEDNESDAY, e.getWed());
					}
					if (weekview.getThu() != e.getThu()) {
						System.out.println("Thu day not matched");
						update(employee, weekview.getProject(), DayOfWeek.THURSDAY, e.getThu());
					}
					if (weekview.getFri() != e.getFri()) {
						System.out.println("Fri day not matched");
						update(employee, weekview.getProject(), DayOfWeek.FRIDAY, e.getFri());
					}
					if (weekview.getSat() != e.getSat()) {
						System.out.println("Sat day not matched");
						update(employee, weekview.getProject(), DayOfWeek.SATURDAY, e.getSat());
					}
				}

			}
			System.out.println(e.getFri());
		});

	}

	private void update(Employee employee, Project project, DayOfWeek dayOfWeek, int time) {

		LocalDate date = firstOfCurrentWeek.plusDays(dayOfWeek.getValue() - 1);
		employeeTimeSheetService.setEmployeeTimeSheet(
				employeeProjectService.getEmployeeProjectByEmployeeAndProject(employee, project), date, time);
	}

}
