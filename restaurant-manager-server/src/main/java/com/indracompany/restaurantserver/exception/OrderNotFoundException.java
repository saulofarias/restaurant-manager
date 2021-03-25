package com.indracompany.restaurantserver.exception;

import com.indracompany.restaurantserver.constants.MessagesConst;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String id) {
		super(MessagesConst.CUSTOMER_NOT_FOUND + id);
	}

}
