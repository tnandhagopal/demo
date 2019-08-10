package com.example.demo.admin;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.employee.Employee;
import com.example.demo.employee.MyUserDetailsService;
import com.example.demo.login.UserPrincipal;
import com.example.demo.project.Project;
import com.example.demo.project.ProjectService;

@Controller
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private MyUserDetailsService employeeService;

	@GetMapping("/projects")
	public String getProjects(Principal principal, Model model) {

		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();

		Employee employee = ((UserPrincipal) userDetails).getUser();

		model.addAttribute("username",
				employee.getFirstName() + " " + employee.getSecondName() + " ( " + employee.getUserName() + " )");

		model.addAttribute("projects", projectService.getAll());
		return "admin/projects";

	}

	@GetMapping("/employees")
	public String getEmployees(Principal principal, Model model) {

		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();

		Employee employee = ((UserPrincipal) userDetails).getUser();

		model.addAttribute("username",
				employee.getFirstName() + " " + employee.getSecondName() + " ( " + employee.getUserName() + " )");

		model.addAttribute("employees", employeeService.getAllEmployee());
		return "admin/employees";

	}

	@GetMapping("/project/create")
	public String addProject(Principal principal, Model model) {

		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();

		Employee employee = ((UserPrincipal) userDetails).getUser();

		model.addAttribute("username",
				employee.getFirstName() + " " + employee.getSecondName() + " ( " + employee.getUserName() + " )");

		model.addAttribute("project", new Project());

		return "admin/createProject";

	}

	@PostMapping("/project/create")
	public String saveProject(@ModelAttribute Project project, Principal principal, Model model) {
		project.setCreatedBy(principal.getName());
		project.setCreatedDate(LocalDate.now());
		project.setCode(project.getCode().toUpperCase());
		if (projectService.save(project))
			return "redirect:/admin/projects";
		else
			return "redirect:/admin/project/create";

	}
}
