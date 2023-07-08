package com.sunil.springBoot.SpringBootRestApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MyController {
	
		@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/hi")
	public String say() {
		return "helloworld";
	}
	

	@GetMapping("/i")
	public String index() {
		return "index";
	}
	
	@GetMapping("/name")
	public String name() {
		return "ram";
	}
	
	@GetMapping("/name2")
	public String name2() {
		return "ram2";
	}
	
	@GetMapping("/stu")
	public String student(Model model) {
		String name="sunil";
		String student[] = {"ajay", "ram", "vishal", "khushal" };
		model.addAttribute("name", name);
		model.addAttribute("student", student);
		return "ram";
	}

	
	
}
