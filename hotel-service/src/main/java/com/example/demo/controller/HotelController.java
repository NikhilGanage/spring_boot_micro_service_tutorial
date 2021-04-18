package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;

@RestController
@RequestMapping(path="/api/v1")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping(path = "/hotels")
	public List<Hotel> getAllHotels(){
		
		return this.hotelService.getAllHotels();
	}
	
	@GetMapping(path = "/hotels/{id}")
	public Hotel getAllHotelById(@PathVariable("id") int id){
		
		Hotel hotel = this.hotelService.findHotelById(id);
		
		hotel.setId(Integer.parseInt(this.port));
		
		return hotel;
	}
}
