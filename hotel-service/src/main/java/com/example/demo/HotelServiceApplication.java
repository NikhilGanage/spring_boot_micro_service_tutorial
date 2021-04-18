package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Hotel;
import com.example.demo.repo.HotelRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			HotelRepository hotelRepository;
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				hotelRepository.save(new Hotel(101,"Sheraton","Pune"));
				hotelRepository.save(new Hotel(201,"Westin","Chennai"));
				hotelRepository.save(new Hotel(301,"Le Meridian","Mumbai"));
			}
		};
	}

}
