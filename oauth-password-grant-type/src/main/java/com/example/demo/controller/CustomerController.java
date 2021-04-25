package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Customer;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private Customer customer;
	
	@GetMapping(path = "/api/v1/customer")
	public Customer getCustomer() {
		return this.customer;
	}
	
}
