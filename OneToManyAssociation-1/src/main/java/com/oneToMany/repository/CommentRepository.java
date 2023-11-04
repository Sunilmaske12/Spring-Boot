package com.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneToMany.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
