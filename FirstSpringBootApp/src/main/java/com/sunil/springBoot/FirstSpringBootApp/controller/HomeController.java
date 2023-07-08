package com.sunil.springBoot.FirstSpringBootApp.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String home() {
		return "hello this is correct time "+LocalDateTime.now();
	}
	
	@GetMapping("/fortune")
	public String fortune() {
		return "hello this is fortune service";
	}
	
	@GetMapping("/a")
	public String a() {
		return "hello this is a service";
	}
	
	@GetMapping("/b")
	public String b() {
		return "hello this is b service";
	}
	
	@GetMapping("/team")
	public String myTeam() {
		return "Team Name : "+teamName+"  , Coach Name : "+coachName;
	}
}
