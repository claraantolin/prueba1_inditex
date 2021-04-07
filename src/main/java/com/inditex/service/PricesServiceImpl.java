package com.inditex.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.entities.Prices;
import com.inditex.models.GetPriceDataInfo;
import com.inditex.repository.PricesRepository;

@Service
public class PricesServiceImpl implements PricesService{
	
	@Autowired
	private PricesRepository repo;
	
	@Override
	public GetPriceDataInfo getProductDataInfo(LocalDateTime date, Integer productId, Integer brandId) {
		GetPriceDataInfo response = new GetPriceDataInfo();
		
		List<Prices> prices = repo.findAll()
				.stream()
				.filter(p -> p.getProductId().equals(productId) && p.getBrandId().equals(brandId) && p.getStartDate().isBefore(date) && p.getEndDate().isAfter(date))
				.sorted(Comparator.comparingInt(Prices::getPriority).reversed())
				.collect(Collectors.toList());
		
		if (prices.isEmpty()) throw new RuntimeException();
		
		Prices finalPrice = prices.stream().findFirst().get();
		
		response.setProductId(finalPrice.getProductId());
		response.setBrandId(finalPrice.getBrandId());
		response.setDate(date);
		response.setFinalPrice(finalPrice.getPrice());
		 
		return response;
	}
	
	

}
