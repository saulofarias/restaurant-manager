package com.indracompany.customerserver.exception;

import com.indracompany.customerserver.constants.MessagesConst;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String id) {
		super(MessagesConst.CUSTOMER_NOT_FOUND + id);
	}

}
