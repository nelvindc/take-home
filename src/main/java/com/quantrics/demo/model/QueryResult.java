package com.quantrics.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class QueryResult {
	
	private List<GeoSearch> geosearch;

	public List<GeoSearch> getGeosearch() {
		return geosearch;
	}

	public void setGeosearch(List<GeoSearch> geosearch) {
		this.geosearch = geosearch;
	}
	
	

}
