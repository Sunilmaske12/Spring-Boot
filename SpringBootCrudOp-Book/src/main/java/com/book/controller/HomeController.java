package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.repo.BookRepository;

@RestController
public class HomeController {

	@Autowired
	private BookRepository bookRepo;
	
	@PostMapping("/insertbook")
	public String insertBook(@RequestBody Book book) {
		Book book1 = bookRepo.save(book);
		return "book inserted "+book1;
	}
	
	@GetMapping("/getBooks")
	public List<Book> getBook(){
		return bookRepo.findAll();
	}

	@PostMapping("/insertbooks")
	public String insertBooks(@RequestBody List<Book> book) {
		List<Book> book1 = bookRepo.saveAll(book);
		return "book inserted "+book1.size();
	}

	
}
