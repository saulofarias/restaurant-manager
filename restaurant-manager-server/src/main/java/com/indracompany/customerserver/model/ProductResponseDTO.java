package com.indracompany.customerserver.model;

public class ProductResponseDTO {

	private Long value;
	private String name;
	private Double price;

	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductResponseDTO() {
	}
	public ProductResponseDTO(Long value, String name, Double price) {
		this.value = value;
		this.name = name;
		this.price = price;
	}

}
