package com.example.demo.login;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.employee.Employee;

@Controller
@ResponseBody
public class LoginController {

	@RequestMapping("/login")
	public String login(Principal principal, Model model) {

		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();

		Employee employee = ((UserPrincipal) userDetails).getUser();

		System.out.println("login");
		return "hello";

	}

//
//	@RequestMapping("/")
//	public String home(Principal principal, Model model) {
//
//		//UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
//	
//		//userDetails.
//		
//		//Employee employee = ((UserPrincipal) userDetails).getUser();
//
//		return "forward:/admin/projects";
//
//	}

}
