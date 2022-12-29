package com.nadetdev.springdataredis.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.nadetdev.springdataredis.entity.Product;

@Repository
public class ProductDAO {

	private static final String HASH_KEY = "Product";

	@Autowired
	private RedisTemplate<String, Product> template;
	
	private List<Object> productList = new ArrayList<>();
	

	public Product save(Product product) {

		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}

	public List<Object> findAll() {
		
		productList = template.opsForHash().values(HASH_KEY);
		
		if(productList != null ) {
			return productList;
		}
		
		return productList;
	}

	public Product findById(int id) {
		Product product = (Product) template.opsForHash().get(HASH_KEY, id);
		
		if(product != null ) {
			return product;
		}
		
		return null;
	}

	public String delete(int id) {

		Product product = findById(id);

		if (product != null) {

			template.opsForHash().delete(HASH_KEY, id);
			return "Product deleted";
		}

		return "Product with id "+ id +" not exist";
	}

}
