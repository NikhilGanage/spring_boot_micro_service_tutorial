package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/v1/client")
public class HotelClientController {

	private WebClient webClient;

	public HotelClientController(WebClient webClient) {
		super();
		this.webClient = webClient;
	}


	@GetMapping(path = "/hotels")
	public Flux<String> getAllHotels() {
		
		return webClient
		.get()
		.uri("lb://HOTEL-SERVICE/api/v1/hotels")
		.retrieve()
		.bodyToFlux(String.class);
	}
	
	@GetMapping(path = "/hotels/{id}")
	public Mono<String> getAllHotelById(@PathVariable("id") int id) {
		
		return webClient
		.get()
		.uri("lb://HOTEL-SERVICE/api/v1/hotels/"+id)
		.retrieve()
		.bodyToMono(String.class);
	}
}
