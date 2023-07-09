package com.sunil.springBoot.SpringBootRestApi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sunil.springBoot.SpringBootRestApi.entity.Customer;

import jakarta.annotation.PostConstruct;
@Controller
public class MyController {
	List<Customer> list1;
	
	@PostConstruct
	public void common() {
	 list1=new ArrayList<Customer>();
	Customer c1=new Customer(1,"ajay", "nagpur");
	Customer c2=new Customer(2,"raj", "ramtek");
	Customer c3=new Customer(3,"sunil", "Maharashtra");
	Customer c4=new Customer(4,"aman", "khu");
	list1.add(c1);list1.add(c2);list1.add(c3);list1.add(c4);
	}
	
	
		@GetMapping("/")
	public String home() {
		return "index";
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
	
	@GetMapping("/student")
	public String AllStudent(Model model) {
		model.addAttribute("student", list1);		
		return "student";
	}
	
	@GetMapping("/stu")
	public String student(Model model) {
		String name="sunil";
		model.addAttribute("name", name);
		return "ram";
	}

	
	
}
