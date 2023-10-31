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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/emp")
public class EployeeController {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmp(){
		return emprepo.findAll();
	}
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Employee> getEmpl(@PathVariable int id ) {
		Optional<Employee> emp = emprepo.findById(id);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/insertEmp")
	public Employee insertEmp(@RequestBody Employee emp){
		return emprepo.save(emp);
	}
	
	@PutMapping("/updateEmp/{id}")
	public String updateEmp(@PathVariable int id, @RequestBody Employee emp) {
		Optional<Employee> emp1 = emprepo.findById(id); 
		if(emp1.isPresent()) {
			Employee emp2 = emp1.get();
			emp2.setFirstName(emp.getFirstName());
			emp2.setLastName(emp.getLastName());
			emp2.setEmailId(emp.getEmailId());
			
			emprepo.save(emp2);
			return "Employee details against is "+id+" is updated";
		}
		else {
			return "Employee details does not exist for id "+id;
					
		}
		
	}
}
