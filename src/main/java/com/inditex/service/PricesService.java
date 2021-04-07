package com.inditex.service;

import java.time.LocalDateTime;

import com.inditex.models.GetPriceDataInfo;

public interface PricesService {
	
	GetPriceDataInfo getProductDataInfo(LocalDateTime date, Integer productId, Integer brandId);

}
