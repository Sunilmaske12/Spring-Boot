package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dao.ProductDao;
import com.crud.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@PostMapping("/insertProduct")
	public String insertProducts(@RequestBody List<Product> products) {
		productDao.saveAll(products);
		return "products inserted : "+products.size();
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProduct(){
		return (List<Product>) productDao.findAll();
	}
}
