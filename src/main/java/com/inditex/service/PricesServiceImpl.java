package com.inditex.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.entities.Prices;
import com.inditex.models.GetPriceDataResponse;
import com.inditex.repository.PricesRepository;

@Service
public class PricesServiceImpl implements PricesService{
	
	@Autowired
	private PricesRepository repo;
	
	@Override
	public GetPriceDataResponse getPriceDataInfo(LocalDateTime date, Integer productId, Integer brandId) {
		
		List<Prices> prices2 = repo.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		
		/*List<Prices> prices = repo.findAll()
				.stream()
				.filter(p -> p.getProductId().equals(productId) && p.getBrandId().equals(brandId) && p.getStartDate().isBefore(date) && p.getEndDate().isAfter(date))
				.sorted(Comparator.comparingInt(Prices::getPriority).reversed())
				.collect(Collectors.toList());*/
		
		return parseResponse(prices2, date);
	}
	
	private GetPriceDataResponse parseResponse (List<Prices> prices, LocalDateTime date) {
		
		GetPriceDataResponse response = new GetPriceDataResponse();
		
		if (prices.isEmpty()) throw new RuntimeException();
		
		Prices finalPrice = prices.stream().findFirst().get();
		
		response.setProductId(finalPrice.getProductId());
		response.setBrandId(finalPrice.getBrandId());
		response.setDate(date);
		response.setFinalPrice(finalPrice.getPrice());
		
		return response;
	}
	

}
