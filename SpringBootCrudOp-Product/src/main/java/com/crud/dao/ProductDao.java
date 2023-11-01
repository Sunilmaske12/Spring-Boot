package com.crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.crud.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {

}
