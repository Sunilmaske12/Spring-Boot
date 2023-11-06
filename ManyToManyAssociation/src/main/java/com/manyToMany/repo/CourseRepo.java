package com.manyToMany.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manyToMany.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {
	
		List<Course> findByFeesLessThan(double fees);

}
