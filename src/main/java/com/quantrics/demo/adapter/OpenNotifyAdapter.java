
package com.quantrics.demo.adapter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.quantrics.demo.model.OpenNotify;


@Component 
public class OpenNotifyAdapter {
	Log log = LogFactory.getLog(OpenNotifyAdapter.class);

	private final WebClient webClient;

	public OpenNotifyAdapter(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://api.open-notify.org").build();
	}

	public OpenNotify getIssLocation() throws Exception{
		return this.webClient.get().uri("/iss-now.json")
				.retrieve().bodyToMono(OpenNotify.class).block();
	}



}
