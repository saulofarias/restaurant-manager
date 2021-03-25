package com.indracompany.restaurantserver.exception;

import com.indracompany.restaurantserver.constants.MessagesConst;

public class CustomerAlreadExistsException extends RuntimeException {

	public CustomerAlreadExistsException() {
		super(MessagesConst.CUSTOMER_ALREAD_EXISTS);
	}

}
