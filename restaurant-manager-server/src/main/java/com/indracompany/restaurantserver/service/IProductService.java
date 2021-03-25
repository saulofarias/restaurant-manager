package com.indracompany.restaurantserver.service;

import java.util.List;

import com.indracompany.restaurantserver.model.Product;
import com.indracompany.restaurantserver.model.ProductDTO;
import com.indracompany.restaurantserver.model.ProductResponseDTO;

public interface IProductService {

	List<ProductResponseDTO> findAll();
	Product getById(Long id);
	ProductDTO toDTO(Product product);
}
