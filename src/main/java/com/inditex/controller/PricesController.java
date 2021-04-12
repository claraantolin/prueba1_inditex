package com.inditex.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.dto.PriceDto;
import com.inditex.exception.ErrorResponse;
import com.inditex.service.PricesService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "/prices", tags = "Prices Controller")
@RestController
@RequestMapping("/prices")
public class PricesController {
	
	@Autowired
	private PricesService service;

	@ApiOperation(value = "Get the prices of a product in a concrete date", response = PriceDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = PriceDto.class),
			@ApiResponse(code = 404, message = "Price not found", response = ErrorResponse.class)
	})
	@GetMapping(value="/product/{productId}/brand/{brandId}/{date}")
	public PriceDto getProductDataInfo(
			@PathVariable Integer productId, 
			@PathVariable Integer brandId,
			@PathVariable(value="date") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date) {
		
		return service.getPriceDataInfo(date, productId, brandId);
	}
		
}