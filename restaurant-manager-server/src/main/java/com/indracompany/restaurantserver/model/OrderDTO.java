package com.indracompany.restaurantserver.model;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

	private Long table;
	private Integer number;
	private List<ProductDTO> products = new ArrayList<>();

	public OrderDTO(){

	}

	public OrderDTO(Long table, Integer number, List<ProductDTO> products) {
		this.table = table;
		this.number = number;
		this.products = products;
	}

	public Long getTable() {
		return table;
	}

	public void setTable(Long table) {
		this.table = table;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderDTO [products=" + products + ", table=" + table + "]";
	}

	

}
