package com.sunil.springBoot.SpringBootRestApi.dao;

import java.util.List;

import com.sunil.springBoot.SpringBootRestApi.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getAll();

	public Customer getById(int id);
	
	public Object insert(Customer customer);
	
	public int delete(int id);

	//public Customer getById(int id);
}
