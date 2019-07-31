package com.example.demo.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		
		System.out.println("login");
		return "hello";
		
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("home");
		return "hello";
		
	}

}
