package com.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneToMany.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
