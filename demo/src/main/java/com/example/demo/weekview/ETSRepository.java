package com.example.demo.weekview;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.employeedetails.EmployeeTimeSheet;

public interface ETSRepository extends JpaRepository<EmployeeTimeSheet, Long> {
		
}
