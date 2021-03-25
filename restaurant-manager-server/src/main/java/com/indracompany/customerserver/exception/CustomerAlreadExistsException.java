package com.indracompany.customerserver.exception;

import com.indracompany.customerserver.constants.MessagesConst;

public class CustomerAlreadExistsException extends RuntimeException {

	public CustomerAlreadExistsException() {
		super(MessagesConst.CUSTOMER_ALREAD_EXISTS);
	}

}
