package com.example.demo.weekview;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.employee.Employee;
import com.example.demo.login.UserPrincipal;

@Controller
public class WeekViewController {

	@Autowired
	private WeekViewService weekViewService;

	@GetMapping("/weekview{action}")
	public String getWeekViewNext(@RequestParam(value = "action", required = false) String action, Principal principal,
			Model model) {

		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();

		Employee employee = ((UserPrincipal) userDetails).getUser();

		model.addAttribute("mon",
				"Mon " + weekViewService.getFirstOfCurrentWeek().format(DateTimeFormatter.ofPattern("dd")));
		model.addAttribute("tus",
				"Thu " + weekViewService.getFirstOfCurrentWeek().plusDays(1).format(DateTimeFormatter.ofPattern("dd")));
		model.addAttribute("wed",
				"Wed " + weekViewService.getFirstOfCurrentWeek().plusDays(2).format(DateTimeFormatter.ofPattern("dd")));
		model.addAttribute("thu",
				"Thu " + weekViewService.getFirstOfCurrentWeek().plusDays(3).format(DateTimeFormatter.ofPattern("dd")));
		model.addAttribute("fri",
				"Fri " + weekViewService.getFirstOfCurrentWeek().plusDays(4).format(DateTimeFormatter.ofPattern("dd")));
		model.addAttribute("sat",
				"Sat " + weekViewService.getFirstOfCurrentWeek().plusDays(5).format(DateTimeFormatter.ofPattern("dd")));
		model.addAttribute("sun",
				"Sun " + weekViewService.getFirstOfCurrentWeek().plusDays(6).format(DateTimeFormatter.ofPattern("dd")));
		model.addAttribute("date",
				"From " + weekViewService.getFirstOfCurrentWeek().format(DateTimeFormatter.ofPattern("dd MMM YYYY"))
						+ " to " + weekViewService.getFirstOfCurrentWeek().plusDays(6)
								.format(DateTimeFormatter.ofPattern("dd MMM YYYY")));

		model.addAttribute("weekviews", weekViewService.getByEmployee(employee, action));
		model.addAttribute("username",
				employee.getFirstName() + " " + employee.getSecondName() + " ( " + employee.getUserName() + " )");
		System.out.println("user :" + principal.getName());
		return "WeekView";

	}

}
