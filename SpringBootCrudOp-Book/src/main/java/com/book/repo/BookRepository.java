package com.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book findBybookName(String username);

}
