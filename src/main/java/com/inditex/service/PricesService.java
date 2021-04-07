package com.inditex.service;

import java.time.LocalDateTime;

import com.inditex.models.GetPriceDataResponse;

public interface PricesService {
	
	GetPriceDataResponse getPriceDataInfo(LocalDateTime date, Integer productId, Integer brandId);

}
