package com.sunil.springBoot.SpringBootRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sunil.springBoot.SpringBootRestApi.entity.Customer;
import com.sunil.springBoot.SpringBootRestApi.service.CustomerService;

@Controller
public class MyController {
	
	@Autowired
	private CustomerService customerService;
	
	
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
	
	@GetMapping("/customer")
	public String AllStudent(Model model) {
		List<Customer> customer = customerService.findAll();
		model.addAttribute("customer", customer);		
		return "customer";
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		Customer c=new Customer();
		model.addAttribute("customer", c);
		return "insertCustomer";
	}
	
	@PostMapping("/insertData")
	public String insertData(@ModelAttribute("customer") Customer theCustomer) {
		//save data
		customerService.save(theCustomer);
		
		//use redirect to avoid duplicate data
		return "redirect:/customer";
	}
	
	@GetMapping("/stu")
	public String student(Model model) {
		String name="sunil";
		model.addAttribute("name", name);
		return "ram";
	}

	
	
}
