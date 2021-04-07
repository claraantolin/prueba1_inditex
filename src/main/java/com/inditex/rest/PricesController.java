package com.inditex.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.models.GetPriceDataResponse;
import com.inditex.service.PricesService;

@RestController
@RequestMapping("/prices")
public class PricesController {
	
	@Autowired
	private PricesService service;
	
	@GetMapping(value="/product/{productId}/brand/{brandId}/{date}")
	public GetPriceDataResponse getProductDataInfo(
			@PathVariable Integer productId, 
			@PathVariable Integer brandId,
			@PathVariable(value="date") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date) {
		
		return service.getPriceDataInfo(date, productId, brandId);
	}
	
}