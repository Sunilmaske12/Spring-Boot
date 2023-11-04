package com.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneToMany.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
