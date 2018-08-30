package com.order.demo.exception;

import java.util.Date;
import java.util.List;

public class ExceptionResponse {
	private Date timestamp;
	private List<String> message;
	
	public ExceptionResponse(Date timestamp, List<String> message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public List<String> getMessage() {
		return message;
	}
}
