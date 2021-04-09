package com.inditex.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inditex.dtos.PriceDto;

@SpringBootTest
public class PricesServiceImplTest {

	@Autowired
	private PricesService service;
		
	// parameters
	PriceDto response;	
	private LocalDateTime date;
	private Integer productId;
	private Integer brandId;
	
	
	@BeforeEach
	void setUp() {		
		productId = 35455;
		brandId = 1;
	}
	
	@Test
	void getProductDataInfoTestOK1() {
		date = LocalDateTime.parse("2020-06-14T10:00:00");
		response = service.getPriceDataInfo(date, productId, brandId);
		
		Assertions.assertEquals(response.getPrice(), 35.5);
	}
	
	@Test
	void getProductDataInfoTestOK2() {
		date = LocalDateTime.parse("2020-06-14T16:00:00");
		
		response = service.getPriceDataInfo(date, productId, brandId);
		
		Assertions.assertEquals(response.getPrice(), 25.45);
	}
	
	@Test
	void getProductDataInfoTestOK3() {
		date = LocalDateTime.parse("2020-06-14T21:00:00");
		
		response = service.getPriceDataInfo(date, productId, brandId);
		
		Assertions.assertEquals(response.getPrice(), 35.5);
	}
	
	@Test
	void getProductDataInfoTestOK4() {
		date = LocalDateTime.parse("2020-06-15T10:00:00");

		response = service.getPriceDataInfo(date, productId, brandId);
		
		Assertions.assertEquals(response.getPrice(), 30.5);
	}
	
	@Test
	void getProductDataInfoTestOK5() {
		date = LocalDateTime.parse("2020-06-16T21:00:00");
		
		response = service.getPriceDataInfo(date, productId, brandId);
		
		Assertions.assertEquals(response.getPrice(), 38.95);
	}
	
	@Test
	void getProductDataInfoTestKO6() {
		date = LocalDateTime.parse("2020-06-16T21:00:00");
		productId = 33333;
				
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			service.getPriceDataInfo(date, productId, brandId);
		});

	}
	
	@Test
	void getProductDataInfoTestKO7() {
		date = LocalDateTime.parse("2020-06-16T21:00:00");
		brandId = 2;
				
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			service.getPriceDataInfo(date, productId, brandId);
		});
	}
	
}
