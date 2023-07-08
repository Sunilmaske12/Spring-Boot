package com.sunil.springBoot.SpringBootRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunil.springBoot.SpringBootRestApi.entity.Customer;
import com.sunil.springBoot.SpringBootRestApi.services.Services;

@RestController
@RequestMapping("/api")
public class MyController {
	
	@Autowired
	private Services cd;
	
	
	@GetMapping("/")
	public String home() {
		return "Welcome Mr.Sunil";
	}
	
	@GetMapping("/hi")
	public String say() {
		return "hi";
	}

	@GetMapping("/get/all")
	public List<Customer> getAll() {
		return cd.getAll();
	}
	
	@GetMapping("/get/{uid}")
	public Customer getOne(@PathVariable("uid") int id) {
		return cd.getById(id);
	}
	
	@GetMapping("/delete/{uid}")
	public int delete(@PathVariable("uid") int id) {
		return cd.delete(id);
	}
	
	@GetMapping("/get/{uid}/{name}/{village}")
	public Object insert(@PathVariable("uid") int id, @PathVariable("name") String name, @PathVariable("village") String village ) {
		Customer c=new Customer(id, name, village);
		return cd.insert(c);
	}
	
	
	
	
}
