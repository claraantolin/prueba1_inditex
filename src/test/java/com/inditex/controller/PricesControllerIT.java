package com.inditex.controller;
 
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.inditex.Inditex;
import com.inditex.dto.PriceDto;

@SpringBootTest(classes = Inditex.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class PricesControllerIT {

	@LocalServerPort
	private int port;
	
	@Autowired
    private TestRestTemplate restTemplate;
			
	@Test
	void getPriceDtoTestsOK() throws Exception {

		Integer productId = 35455;
		Integer brandId = 1;
		
		createTest(productId, brandId, "2020-06-14T10:00:00", productId, brandId, 35.5);
		createTest(productId, brandId, "2020-06-14T16:00:00", productId, brandId, 25.45);
		createTest(productId, brandId, "2020-06-14T21:00:00", productId, brandId, 35.5);
		createTest(productId, brandId, "2020-06-15T10:00:00", productId, brandId, 30.5);
		createTest(productId, brandId, "2020-06-16T21:00:00", productId, brandId, 38.95);
	}
	
	@Test
	void getPriceDtoTestsKO() throws Exception {
		createTest(35455, 2, "2020-06-16T21:00:00", null, null, null);	// with wrong brand id
		createTest(33333, 1, "2020-06-16T21:00:00", null, null, null);	// with wrong product id
		createTestKO("abc", 1, "2020-06-16T21:00:00", null, null, null);	// with wrong url because of productId
		createTestKO(33333, "abc", "2020-06-16T21:00:00", null, null, null);	// with wrong url because of brandId
		createTestKO(33333, 1, "2020-06-16", null, null, null);	// with wrong url because of date
	}
	
	
	private void createTest (Integer productId, Integer brandId, String date, Integer productIdExpected, Integer brandIdExpected, Double priceExpected) throws Exception {
		PriceDto dto = this.restTemplate.getForObject("http://localhost:" + port + "/prices/product/" + productId + "/brand/" + brandId + "/" + date, PriceDto.class);
		
		assertThat(dto.getProductId(), equalTo(productIdExpected));
		assertThat(dto.getBrandId(), equalTo(brandIdExpected));
		assertThat(dto.getPrice(), equalTo(priceExpected));
	}
	
	private void createTestKO (Object productId, Object brandId, Object date, Integer productIdExpected, Integer brandIdExpected, Double priceExpected) throws Exception {
		PriceDto dto = this.restTemplate.getForObject("http://localhost:" + port + "/prices/product/" + productId + "/brand/" + brandId + "/" + date, PriceDto.class);
		assertThat(dto, equalTo(null));
	}

}