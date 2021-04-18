package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelClientController {
	
	@Autowired
	private HotelServiceClient client;

	@GetMapping(path = "/client/hotels")
	public String getAllHotels(){
		return this.client.getAllHotels();
	}
}
