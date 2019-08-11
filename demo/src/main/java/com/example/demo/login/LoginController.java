package com.example.demo.login;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.employee.Employee;

@Controller
@PreAuthorize("hasAnyRole('USER')")
public class LoginController {

	@RequestMapping("/home")
	@GetMapping
	public String login(Principal principal, Model model) {
		System.out.println("home");
		boolean hasAdminRole = false;
		try {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			hasAdminRole = authentication.getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
			if (hasAdminRole) {
				UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();

				Employee employee = ((UserPrincipal) userDetails).getUser();
				model.addAttribute("username", employee.getFirstName() + " " + employee.getSecondName() + " ( "
						+ employee.getUserName() + " )");

				return "home/adminHome";
			} else {
				return "redirect:/weekview/edit";
			}
		} catch (Exception e) {
			return "redirect:/home";
		}

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
