package com.example.demo.employeedetails;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.login.Employee;

@Entity
@Table(name = "Employee_Project")
public class EmployeeProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ep_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ep_emp_id", referencedColumnName="emp_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "ep_pro_id" , referencedColumnName="pro_id")
	private Project project;

	@Basic
	@Column(name = "ep_start_date")
	private LocalDate startDate;

	@Basic
	@Column(name = "ep_end_date")
	private LocalDate endtDate;

	@Basic
	@Column(name = "ep_created_date")
	private LocalDate createdDate;

	@Basic
	@Column(name = "ep_created_by")
	private String createdBy;

	@Basic
	@Column(name = "ep_updated_date")
	private LocalDate updatedDate;

	@Basic
	@Column(name = "ep_updated_by")
	private String updatedBy;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEmdtDate() {
		return endtDate;
	}

	public void setEmdtDate(LocalDate endtDate) {
		this.endtDate = endtDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
