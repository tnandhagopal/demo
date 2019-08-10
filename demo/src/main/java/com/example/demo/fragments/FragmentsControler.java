package com.example.demo.fragments;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.employee.Employee;
import com.example.demo.login.UserPrincipal;

@Controller
@RequestMapping("/fragments")
@PreAuthorize("hasAnyRole('USER')")
public class FragmentsControler {

	@GetMapping("/header")
	public String getHeader(Principal principal, Model model) {

		
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();

		Employee employee = ((UserPrincipal) userDetails).getUser();

		System.out.println("fragments header call " + employee );
		model.addAttribute("username",
				employee.getFirstName() + " " + employee.getSecondName() + " ( " + employee.getUserName() + " )");

		return "fragments/header";
	}

}
