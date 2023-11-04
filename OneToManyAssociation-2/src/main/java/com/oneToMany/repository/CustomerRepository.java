package com.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneToMany.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
