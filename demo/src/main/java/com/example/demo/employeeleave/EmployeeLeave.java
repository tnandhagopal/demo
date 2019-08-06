package com.example.demo.employeeleave;

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

import com.example.demo.employee.Employee;

@Entity
@Table(name = "Employee_Leave")
public class EmployeeLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "el_id")
	private int id;

	@Basic
	@Column(name = "el_date")
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "el_emp_id", referencedColumnName = "emp_id")
	private Employee employee;

	@Basic
	@Column(name = "el_status")
	private String status;

	@Basic
	@Column(name = "el_created_date")
	private LocalDate createdDate;

	@Basic
	@Column(name = "el_created_by")
	private String createdBy;

	@Basic
	@Column(name = "el_updated_date")
	private LocalDate updatedDate;

	@Basic
	@Column(name = "el_updated_by")
	private String updatedBy;

	public EmployeeLeave(int id, LocalDate date, Employee employee, String status, LocalDate createdDate,
			String createdBy, LocalDate updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.date = date;
		this.employee = employee;
		this.status = status;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
