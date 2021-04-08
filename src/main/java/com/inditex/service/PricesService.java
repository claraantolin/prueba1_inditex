package com.inditex.service;

import java.time.LocalDateTime;

import com.inditex.dtos.PriceDto;

public interface PricesService {
	
	PriceDto getPriceDataInfo(LocalDateTime date, Integer productId, Integer brandId);

}
