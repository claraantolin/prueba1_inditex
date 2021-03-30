package com.inditex.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.entities.Prices;
import com.inditex.service.IPricesService;

@RestController
@RequestMapping("/prices")
public class PricesController {
	
	@Autowired
	private IPricesService service;
	
	@GetMapping(value="/list")
	public List<Prices> getPrices() {
		return service.getPrices();
	}
	
	
}