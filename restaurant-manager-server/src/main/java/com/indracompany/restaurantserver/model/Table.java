package com.indracompany.restaurantserver.model;

import javax.persistence.Entity;

public class Table {

	private String name;
	private Integer value;

	public Table() {
	}

	public Table(String name, Integer value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}


}
