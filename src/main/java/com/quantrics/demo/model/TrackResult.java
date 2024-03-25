package com.quantrics.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackResult {
	
	private List<TrackPlace> results;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<TrackPlace> getResults() {
		return results;
	}

	public void setResults(List<TrackPlace> results) {
		this.results = results;
	}
	
	

}
