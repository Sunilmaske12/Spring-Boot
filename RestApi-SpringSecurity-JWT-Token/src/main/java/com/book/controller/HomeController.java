package com.book.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.User;
import com.book.repo.UserRepository;

@RestController
@RequestMapping("/home")
public class HomeController {

	
	@Autowired
	private UserRepository userRepo;
	
	
	
	@GetMapping("/test")
	public String testing() {
		return  "Working properly";
	}

	@GetMapping("/admin")
	public String testingA() {
		
		return  "Working properly == Admin";
	}
	
	
	@GetMapping("/current")
	public String getCurrentUser(Principal p) {
		return p.getName();
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	
}
