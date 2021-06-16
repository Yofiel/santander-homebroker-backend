package com.pedrogobira.santanderhomebrokerbackend.exceptions;

import com.pedrogobira.santanderhomebrokerbackend.util.MessageUtils;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		super(MessageUtils.NOT_RECORDS_FOUND);
	}

}
