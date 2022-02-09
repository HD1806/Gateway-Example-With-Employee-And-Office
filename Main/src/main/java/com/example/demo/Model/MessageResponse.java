package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {
	
	private String Message;
	private int status;
	private Object response;
	public MessageResponse(String message, int status, Object response) {
		super();
		Message = message;
		this.status = status;
		this.response = response;
	}
	public MessageResponse(String message, int status) {
		super();
		Message = message;
		this.status = status;
	}

}
