package com.indracompany.restaurantserver.model;

import java.util.List;

public class OrderResponseDTO {

	private Long id;
	private Double amount;
	private Integer number;
	private Long numTable;
	private String status;
	private List<OrderedItemDTO> items;

	public OrderResponseDTO() {
	} 

	public OrderResponseDTO(Long id, Double amount, Integer number, Long numTable, List<OrderedItemDTO> items, String status) {
		this.id = id;
		this.amount = amount;
		this.number = number;
		this.numTable = numTable;
		this.items = items;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getNumTable() {
		return numTable;
	}

	public void setNumTable(Long numTable) {
		this.numTable = numTable;
	}

	public List<OrderedItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderedItemDTO> items) {
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 


}
