package com.quantrics.demo.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.quantrics.demo.model.MediaWiki;

import reactor.core.publisher.Mono;

@Component
public class MediaWikiAdapter {
	Log log = LogFactory.getLog(MediaWikiAdapter.class);

	private final WebClient webClient;

	public MediaWikiAdapter(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://en.wikipedia.org").build();
	}

	public Mono<String> someRestCall(String name) {
		return this.webClient.get().uri("/sample", name)
				.retrieve().bodyToMono(String.class);
	}

	public MediaWiki getPlaces(String latitude, String longitude) {

		StringBuffer coordinates = new StringBuffer(latitude);
		coordinates.append("|");
		coordinates.append(longitude);
		log.info("coordinates: " + latitude + " " + longitude);

		return this.webClient.get().uri(uriBuilder -> uriBuilder
				.path("/w/api.php")
				.queryParam("action", "query")
				.queryParam("list", "geosearch")
				.queryParam("gsradius", "10000")
				.queryParam("gslimit", "10")
				//.queryParam("gscoord", "37.786971|-122.399677")
				//.queryParam("gscoord", "15.8700|100.9925")
				.queryParam("gscoord", coordinates.toString())
				.queryParam("gsprop", "country")
				.queryParam("format", "json")
				.build())
				.retrieve()
				.bodyToMono(MediaWiki.class)
				.block();
	}
}
