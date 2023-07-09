package com.sunil.springBoot.SpringBootRestApi.service;

import java.util.List;

import com.sunil.springBoot.SpringBootRestApi.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();

	void save(Customer theCustomer);

}
