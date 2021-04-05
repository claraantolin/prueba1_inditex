package com.inditex.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inditex.entities.Prices;
import com.inditex.models.ProductDataInfo;

@SpringBootTest
public class PricesServiceImplTest {

	@Autowired
	private PricesServiceImpl service = new PricesServiceImpl();
	
	// mocks
	//private IPricesRepo repoMock = Mockito.mock(IPricesRepo.class);
	
	// parameters
	ProductDataInfo response;	
	private LocalDateTime date;
	private Integer productId;
	private Integer brandId;
	
	@BeforeEach
	void setUp() {
		//Mockito.when(repoMock.findAll()).thenReturn(getPrices());
		
		productId = 35455;
		brandId = 1;
	}
	
	@Test
	void getProductDataInfoTest1() {
		date = LocalDateTime.parse("2020-06-14T10:00:00");
		try {
			response = service.getProductDataInfo(date, productId, brandId);
		} catch (Exception e) {}
		
		Assertions.assertEquals(response.getFinalPrice(), 35.5);
	}
	
	@Test
	void getProductDataInfoTest2() {
		date = LocalDateTime.parse("2020-06-14T16:00:00");
		
		try {
			response = service.getProductDataInfo(date, productId, brandId);
		} catch (Exception e) {}
		
		Assertions.assertEquals(response.getFinalPrice(), 25.45);
	}
	
	@Test
	void getProductDataInfoTest3() {
		date = LocalDateTime.parse("2020-06-14T21:00:00");
		try {
			response = service.getProductDataInfo(date, productId, brandId);
		} catch (Exception e) {}
		
		Assertions.assertEquals(response.getFinalPrice(), 35.5);
	}
	
	@Test
	void getProductDataInfoTest4() {
		date = LocalDateTime.parse("2020-06-15T10:00:00");
		try {
			response = service.getProductDataInfo(date, productId, brandId);
		} catch (Exception e) {}
		
		Assertions.assertEquals(response.getFinalPrice(), 30.5);
	}
	
	@Test
	void getProductDataInfoTest5() {
		date = LocalDateTime.parse("2020-06-16T21:00:00");
		try {
			response = service.getProductDataInfo(date, productId, brandId);
		} catch (Exception e) {}
		
		Assertions.assertEquals(response.getFinalPrice(), 38.95);
	}
	
	private List<Prices> getPrices() {
		List<Prices> response = new ArrayList<Prices>();

		response.add(new Prices(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, 35.5, "EUR"));
		response.add(new Prices(2, 1, LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"), 35455, 1, 35.5, "EUR"));
		response.add(new Prices(3, 1, LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"), 35455, 1, 35.5, "EUR"));
		response.add(new Prices(4, 1, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 1, 35.5, "EUR"));
		
		return response;
	}
}
