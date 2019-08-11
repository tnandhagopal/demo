package com.example.demo.employee;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.role.Role;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Basic
	@Column(name = "emp_user_name", unique = true)
	private String userName;

	@Basic
	@Column(name = "emp_first_name")
	private String firstName;

	@Basic
	@Column(name = "emp_second_name")
	private String secondName;

	@Basic
	@Column(name = "emp_mail_id")
	private String mailId;

	@Basic
	@Column(name = "emp_contact_no")
	private String contactNo;

	@Basic
	@Column(name = "emp_dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@Basic
	@Column(name = "emp_password")
	private String password;

	@Basic
	@Column(name = "emp_status")
	private String status;

	@Basic
	@Column(name = "emp_created_date")
	private LocalDate createdDate;

	@Basic
	@Column(name = "emp_created_by")
	private String createdBy;

	@Basic
	@Column(name = "emp_updated_date")
	private LocalDate updatedDate;

	@Basic
	@Column(name = "emp_updated_by")
	private String updatedBy;

	@Basic
	@Column(name = "emp_is_enabled", columnDefinition = "tinyint(1) default 1")
	private boolean isEnabled;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_role",foreignKey = @ForeignKey(name = "er_uk"), joinColumns = @JoinColumn(name = "er_emp_id"), inverseJoinColumns = @JoinColumn(name = "er_role_id"))
	private Set<Role> roles;
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {

		System.out.println("status");
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
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
