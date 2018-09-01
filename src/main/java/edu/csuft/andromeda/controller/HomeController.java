package edu.csuft.andromeda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register.html";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/rating")
	public String rating() {
		return "rating.html";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add.html";
	}
	
	@GetMapping("/exam")
	public String exam() {
		return "exam.html";
	}
	
	@GetMapping("/quiz")
	public String quiz() {
		return "quiz.html";
	}
}
