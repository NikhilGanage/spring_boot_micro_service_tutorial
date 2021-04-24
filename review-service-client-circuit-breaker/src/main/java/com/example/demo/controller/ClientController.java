package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ClientController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping(path = "/client")
	@CircuitBreaker(fallbackMethod = "fallback", name = "reviewservice")
	public ResponseEntity<String> getReviews() {
		String response = template.getForObject("http://REVIEW-SERVICE/api/v1/reviews", String.class);
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<String> fallback(Exception e){
		return new ResponseEntity<String>("Reiew service is down."+e.getMessage(),HttpStatus.OK);
	}
	
	
}
