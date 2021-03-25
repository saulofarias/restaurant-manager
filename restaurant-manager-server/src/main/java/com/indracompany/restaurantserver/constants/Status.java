package com.indracompany.restaurantserver.constants;

public enum Status {
	NOVO("Novo"),
	CANCELADO("Cancelado"),
	CONCUIDO("Concluido"),
	FECHADO("Fechado");

	private String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}


}
