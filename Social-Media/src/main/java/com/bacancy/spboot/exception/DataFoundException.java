package com.bacancy.spboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class DataFoundException extends RuntimeException {

	public DataFoundException(String message) {
		super(message);
	}

}

