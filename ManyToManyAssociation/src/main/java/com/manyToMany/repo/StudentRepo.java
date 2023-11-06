package com.manyToMany.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manyToMany.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	//List<Student> findByNameCotaining(String name);

}
