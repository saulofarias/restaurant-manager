package com.indracompany.customerserver.service;

import java.util.ArrayList;
import java.util.List;

import com.indracompany.customerserver.model.Product;
import com.indracompany.customerserver.model.ProductDTO;
import com.indracompany.customerserver.model.ProductResponseDTO;
import com.indracompany.customerserver.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<ProductResponseDTO> findAll() {
		return toDTO(repository.findAll());
	}

	@Override
	public Product getById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	@Override	
	public ProductDTO toDTO(Product product){
		return new ProductDTO(product.getId());
	}

	public List<ProductResponseDTO> toDTO(List<Product> products){
		List<ProductResponseDTO> dtos = new ArrayList<>();
		for (Product product : products) {
			var dto = new ProductResponseDTO(product.getId(), product.getName(), product.getPrice());
			dtos.add(dto);
		}
		return dtos;

	}
}
