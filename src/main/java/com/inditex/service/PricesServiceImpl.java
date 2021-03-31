package com.inditex.service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.entities.Prices;
import com.inditex.models.ProductDataInfo;
import com.inditex.repository.IPricesRepo;

@Service
public class PricesServiceImpl implements IPricesService{
	
	@Autowired
	private IPricesRepo repo;
	
	@Override
	public List<Prices> getPrices() {
		return (List<Prices>) repo.findAll();
	}

	@Override
	public ProductDataInfo getProductDataInfo(Date date, Integer productId, Integer brandId) {
		ProductDataInfo response = new ProductDataInfo();
		
		List<Prices> prices = repo.findAll()
				.stream()
				.filter(p -> p.getProductId().equals(productId) && p.getBrandId().equals(brandId) && p.getStartDate().compareTo(date) <= 0 && p.getEndDate().compareTo(date) >= 0)
				.sorted(Comparator.comparingInt(Prices::getPriority).reversed())
				.collect(Collectors.toList());
		
		if (prices.isEmpty()) return null;
		
		Prices finalPrice = prices.stream().findFirst().get();
		
		response.setProductId(finalPrice.getProductId());
		response.setBrandId(finalPrice.getBrandId());
		response.setDate(date);
		response.setFinalPrice(finalPrice.getPrice());
		 
		return response;
	}
	
	

}
