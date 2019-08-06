package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Long> {
	Employee findByUserName(String username);
	
	
}
