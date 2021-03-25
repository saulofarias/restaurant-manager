package com.indracompany.customerserver.service;

import java.util.List;

import com.indracompany.customerserver.model.Product;
import com.indracompany.customerserver.model.ProductDTO;
import com.indracompany.customerserver.model.ProductResponseDTO;

public interface IProductService {

	List<ProductResponseDTO> findAll();
	Product getById(Long id);
	ProductDTO toDTO(Product product);
}
