package com.sunil.springBoot.SpringBootRestApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.springBoot.SpringBootRestApi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	//here no need to write any code

}
