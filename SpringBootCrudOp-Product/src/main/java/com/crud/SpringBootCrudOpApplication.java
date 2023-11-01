package com.crud;

//Create a springboot app to save the entity product with the fields(id,pname,pamount,category) 
//apply PostMapping and GetMapping to the same

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudOpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOpApplication.class, args);
	}

}
