package com.inditex.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.dtos.PriceDto;
import com.inditex.entities.Prices;
import com.inditex.repository.PricesRepository;

@Service
public class PricesServiceImpl implements PricesService{
	
	@Autowired
	private PricesRepository repository;
	
	@Override
	public PriceDto getPriceDataInfo(LocalDateTime date, Integer productId, Integer brandId) {	
		
		List<Prices> priceProductDataInfo = repository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		return parseResponse(priceProductDataInfo, date);
		
	}
	
	private PriceDto parseResponse (List<Prices> prices, LocalDateTime date) {
		
		PriceDto response = new PriceDto();
		
		if (prices.isEmpty()) throw new NoSuchElementException("Price not found");
		
		Prices finalPrice = prices.stream().findFirst().get();
		
		response.setProductId(finalPrice.getProductId());
		response.setBrandId(finalPrice.getBrandId());
		response.setDate(date);
		response.setFinalPrice(finalPrice.getPrice());
		
		return response;
	}
	

}
