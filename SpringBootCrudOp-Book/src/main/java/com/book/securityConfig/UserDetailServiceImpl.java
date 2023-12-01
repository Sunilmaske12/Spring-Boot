package com.book.securityConfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.book.entity.Book;
import com.book.repo.BookRepository;

public class UserDetailServiceImpl implements UserDetailsService {
	
	private BookRepository bookRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Book book = this.bookRepo.findBybookName(username);
		if(book==null) {
			System.out.println("Book not found");
			throw new UsernameNotFoundException("No book found");
		}
		return (UserDetails) book;
	}

}
