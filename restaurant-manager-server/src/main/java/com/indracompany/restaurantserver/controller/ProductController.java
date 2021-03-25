package com.indracompany.restaurantserver.controller;

import java.util.List;

import com.indracompany.restaurantserver.model.Product;
import com.indracompany.restaurantserver.model.ProductResponseDTO;
import com.indracompany.restaurantserver.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/products")
public class ProductController {

	@Autowired
	IProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> findAll() {
		return ResponseEntity.ok().body(productService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productService.getById(id));
	}
}
