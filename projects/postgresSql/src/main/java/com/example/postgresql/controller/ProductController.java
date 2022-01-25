package com.example.postgresql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresql.repository.ProductRespository;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductRespository productRespository;

	public ProductController(ProductRespository productRepository) {
		this.productRespository = productRepository;
	}

@GetMapping
	public ResponseEntity getAllProducts() {
	return ResponseEntity.ok(this.productRespository.findAll());
}
	
	
}
