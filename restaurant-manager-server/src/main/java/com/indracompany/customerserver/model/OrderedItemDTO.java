package com.indracompany.customerserver.model;

public class OrderedItemDTO {

	private Long id;
	private String description;
	private Double price;
	private ProductDTO product;

	public OrderedItemDTO() {
	}		

	public OrderedItemDTO(Long id, String description, Double price, ProductDTO product) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}		


}
