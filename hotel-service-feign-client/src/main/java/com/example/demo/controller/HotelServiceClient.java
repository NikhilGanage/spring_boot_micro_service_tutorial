package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelServiceClient {

	@GetMapping(path = "/api/v1/hotels")
	public String getAllHotels();
}
