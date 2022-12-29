package com.nadetdev.springdataredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadetdev.springdataredis.entity.Product;
import com.nadetdev.springdataredis.repository.ProductDAO;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return productDAO.save(product);
	}
	
	@GetMapping
	public List<Object> getAllProducts() {
		List<Object> productList = productDAO.findAll();
		
		return productList;
	}
	
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return productDAO.findById(id);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productDAO.delete(id);
	}

}
