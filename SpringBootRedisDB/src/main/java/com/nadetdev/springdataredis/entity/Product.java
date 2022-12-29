package com.nadetdev.springdataredis.entity;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RedisHash("Product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = -4589772895553570361L;
	
	@Id
	private int id;
	private String name;
	private int qty;
	private long price;
}
