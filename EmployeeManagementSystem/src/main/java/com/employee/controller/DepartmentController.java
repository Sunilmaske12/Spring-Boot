package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Department;
import com.employee.repository.DeptRepo;

@RestController
public class DepartmentController {
	
	
	@Autowired
	private DeptRepo deprepo;
	
	@GetMapping("/getAllDep")
	public List<Department> getAllDept(){
		return deprepo.findAll();
	}
	
	@GetMapping("/getDep/{id}")
	public ResponseEntity<Department> getDep(@PathVariable int id ) {
		Optional<Department> dep = deprepo.findById(id);
		if(dep.isPresent()) {
			return new ResponseEntity<Department>(dep.get(), HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/insertDep")
	public Department insertDep(@RequestBody Department dep){
		return deprepo.save(dep);
	}
	
	@PutMapping("/updateDep/{id}")
	public String updateDep(@PathVariable int id, @RequestBody Department dep) {
		Optional<Department> dep1 = deprepo.findById(id); 
		if(dep1.isPresent()) {
			Department dep2 = dep1.get();
			dep2.setDeptName(dep.getDeptName());
			dep2.setRole(dep.getRole());
			
			deprepo.save(dep2);
			return "Department details against is "+id+" is updated";
		}
		else {
			return "Department details does not exist for id "+id;
					
		}
		
	}


}
