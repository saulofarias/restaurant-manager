package com.indracompany.customerserver.model;

public class ProductDTO {

	private Long id;

	public ProductDTO() {
	}

	public ProductDTO(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + "]";
	}



}
