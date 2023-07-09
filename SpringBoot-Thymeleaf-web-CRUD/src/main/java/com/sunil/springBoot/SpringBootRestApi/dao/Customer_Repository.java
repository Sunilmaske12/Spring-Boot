package com.sunil.springBoot.SpringBootRestApi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.springBoot.SpringBootRestApi.entity.Customer;

public interface Customer_Repository extends JpaRepository<Customer, Integer> {
	
	
	//sorting data by name
	public List<Customer> findAllByOrderByNameAsc();	
}
