package com.indracompany.customerserver.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double amount;
	private String status;
	private Integer number;
	private Long numTable;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<OrderedItem> items = new ArrayList<>();


	public Order() {
	}

	public Order(Double amount, String status, Integer number, Long numTable, List<OrderedItem> items) {
		this.amount = amount;
		this.status = status;
		this.number = number;
		this.numTable = numTable;
		this.items = items;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<OrderedItem> getItems() {
		return items;
	}

	public void setItems(List<OrderedItem> items) {
		this.items = items;
	}


}
