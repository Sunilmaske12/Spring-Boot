package com.sunil.springBoot.SpringBootRestApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunil.springBoot.SpringBootRestApi.dao.CustomerDao;
import com.sunil.springBoot.SpringBootRestApi.entity.Customer;

@Service
public class ServicesImpl implements Services{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	@Override
	public Customer getById(int id) {
		return customerDao.getById(id);
	}

	@Override
	@Transactional
	public Object insert(Customer customer) {
		return customerDao.insert(customer);
	}

	@Override
	@Transactional
	public int delete(int id) {
		return customerDao.delete(id);
	}
	
	
	
}
