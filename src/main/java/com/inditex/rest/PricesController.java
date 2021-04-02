package com.inditex.rest;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.entities.Prices;
import com.inditex.models.ProductDataInfo;
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
	
	@GetMapping(value="/product")
	public ProductDataInfo getProductDataInfo(@RequestParam String date, @RequestParam Integer productId, @RequestParam Integer brandId) throws ParseException {
		return service.getProductDataInfo(LocalDateTime.parse(date), productId, brandId);
	}
	
}