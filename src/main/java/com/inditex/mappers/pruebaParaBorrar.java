package com.inditex.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.inditex.dtos.PriceDto;
import com.inditex.entities.Prices;

@Component
public class pruebaParaBorrar {

	public PriceDto createDto (Prices price, LocalDateTime date) {
		
		PriceDto response = new PriceDto();
		response.setProductId(price.getProductId());
		response.setBrandId(price.getBrandId());
		response.setDate(date);
		response.setPrice(price.getPrice());
		
		return response;
	}
}
