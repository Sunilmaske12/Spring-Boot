package com.manyToMany.conntroller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manyToMany.entity.Course;
import com.manyToMany.entity.Student;
import com.manyToMany.repo.CourseRepo;
import com.manyToMany.repo.StudentRepo;

@RestController
@RequestMapping("/student/course")
public class StudentController {
	

	private CourseRepo courseRepo;
	private StudentRepo studRepo;

	public StudentController(StudentRepo srepo, CourseRepo crepo) {
		this.studRepo = srepo;
		this.courseRepo = crepo;
	}

	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) {
			return studRepo.save(student);
	}
	
	@GetMapping("/getStudent")
	public List<Student> getStudent(){
		return studRepo.findAll();
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getSTudentById(@PathVariable int id) {
		return studRepo.findById(id).orElse(null);
	}
	
//	@GetMapping("getStudent/{name}")
//	public List<Student> getSTudentByName(@PathVariable String name) {
//		return studRepo.findByNameCotaining(name);
//	}
	
	@GetMapping("/search/{price}")
	public List<Course> findCourseLessThanPrice(double price){
		return courseRepo.findByFeesLessThan(price);
	}

}
