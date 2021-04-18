package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.repo.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> getAllHotels(){
		
		return hotelRepository.findAll();
	}
	
	
	public Hotel findHotelById(Integer id) {
		
		return hotelRepository.findById(id).get();
	}
}
