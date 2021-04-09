package com.inditex.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.dtos.PriceDto;
import com.inditex.entities.Prices;
import com.inditex.mappers.PriceMapper;
import com.inditex.repository.PricesRepository;

@Service
public class PricesServiceImpl implements PricesService{
	
	@Autowired
	private PricesRepository repository;
	
	@Autowired
	private PriceMapper mapper;
	
	@Override
	public PriceDto getPriceDataInfo(LocalDateTime date, Integer productId, Integer brandId) {	
		
		List<Prices> priceProductDataInfo = repository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		if (priceProductDataInfo.isEmpty()) throw new NoSuchElementException("Price not found");
		
		return mapper.toDTO(priceProductDataInfo.stream().findFirst().get(), date);
		
	}	

}
