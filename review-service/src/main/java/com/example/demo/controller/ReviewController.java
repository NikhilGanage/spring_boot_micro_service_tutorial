package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ReviewController {
	
	@GetMapping(path = "/reviews")
	public String getReview() {
		return "Average rating";
	}

}
