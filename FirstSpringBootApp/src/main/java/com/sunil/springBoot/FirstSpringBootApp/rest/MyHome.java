package com.sunil.springBoot.FirstSpringBootApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHome {
	@GetMapping("/hello")
	public String home() {
		return "hello";
	}
}
