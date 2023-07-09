package com.sunil.springBoot.SpringBootRestApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.springBoot.SpringBootRestApi.dao.Customer_Repository;
import com.sunil.springBoot.SpringBootRestApi.entity.Customer;

@Service
public class CustpomerServiceImpl implements CustomerService {
	
	@Autowired
	private Customer_Repository repository;
	
	@Override
	public List<Customer> findAll() {
	//	return repository.findAll();
	
		//getting sorted data by name in asscending order
		return repository.findAllByOrderByNameAsc();
	}

	@Override
	public void save(Customer theCustomer) {
		repository.save(theCustomer);
		
	}
	
	
	
}
