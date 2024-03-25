package com.quantrics.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class MediaWiki {
	
	private QueryResult query;

	public QueryResult getQuery() {
		return query;
	}

	public void setQuery(QueryResult query) {
		this.query = query;
	}
	
	
	
	

}
