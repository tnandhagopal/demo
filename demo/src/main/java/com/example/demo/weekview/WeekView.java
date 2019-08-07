package com.example.demo.weekview;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.employeetimesheet.EmployeeTimeSheet;
import com.example.demo.project.Project;

public class WeekView {

	private int mon;
	private int tus;
	private int wed;
	private int thu;
	private int fri;
	private int sat;
	private int sun;

	private Project project;
	private int total;
	private LocalDate date;

	private List<EmployeeTimeSheet> employeeTimeSheet;

	public WeekView() {

	}

	public WeekView(int mon, int tus, int wed, int thu, int fri, int sat, int sun, Project project, int total,
			LocalDate date, List<EmployeeTimeSheet> employeeTimeSheet) {
		super();
		this.mon = mon;
		this.tus = tus;
		this.wed = wed;
		this.thu = thu;
		this.fri = fri;
		this.sat = sat;
		this.sun = sun;
		this.project = project;
		this.total = total;
		this.date = date;
		this.employeeTimeSheet = employeeTimeSheet;
	}

	public WeekView(List<EmployeeTimeSheet> employeeTimeSheet, Project project, LocalDate date) {

		System.out.println("employeeTimeSheet.size = " + employeeTimeSheet.size());

		this.employeeTimeSheet = employeeTimeSheet;

		this.sun = getTime(DayOfWeek.SUNDAY);

		this.mon = getTime(DayOfWeek.MONDAY);

		this.tus = getTime(DayOfWeek.TUESDAY);

		this.wed = getTime(DayOfWeek.WEDNESDAY);

		this.thu = getTime(DayOfWeek.THURSDAY);

		this.fri = getTime(DayOfWeek.FRIDAY);

		this.sat = getTime(DayOfWeek.SATURDAY);

		this.project = project;

		this.total = this.sun + this.mon + this.tus + this.wed + this.thu + this.fri + this.sat;

		this.date = date;
	}

	private int getTime(DayOfWeek dayOfWeek) {

		EmployeeTimeSheet retETS = employeeTimeSheet.stream()
				.filter(ets -> dayOfWeek.equals(ets.getDate().getDayOfWeek())).findFirst().orElse(null);

		if (retETS != null)
			return retETS.getTime();

		return 0;

	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSun() {
		return sun;
	}

	public void setSun(int sun) {
		this.sun = sun;
	}

	public int getMon() {
		return mon;
	}

	public void setMon(int mon) {
		this.mon = mon;
	}

	public int getTus() {
		return tus;
	}

	public void setTus(int tus) {
		this.tus = tus;
	}

	public int getWed() {
		return wed;
	}

	public void setWed(int wed) {
		this.wed = wed;
	}

	public int getThu() {
		return thu;
	}

	public void setThu(int thu) {
		this.thu = thu;
	}

	public int getFri() {
		return fri;
	}

	public void setFri(int fri) {
		this.fri = fri;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		this.sat = sat;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
