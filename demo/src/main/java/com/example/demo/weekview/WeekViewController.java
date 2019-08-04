package com.example.demo.weekview;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeekViewController {

	@GetMapping("/weekview")
	public String getWeekView(Principal principal, Model model) {

		model.addAttribute("message", principal.getName());
		model.addAttribute("tasks", "sss");
		System.out.println("user :" + principal.getName());
		return "WeekView";

	}
}
