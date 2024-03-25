package com.quantrics.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class OpenNotify {
	
	private Position iss_position;
	
	private String message;

	public Position getIss_position() {
		return iss_position;
	}

	public void setIss_position(Position iss_position) {
		this.iss_position = iss_position;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
