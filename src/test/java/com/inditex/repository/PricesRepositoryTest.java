package com.inditex.repository;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.entity.Prices;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PricesRepositoryTest {
	
	@Autowired
    private PricesRepository pricesRepository;
	
	List<Prices> response;
	private Integer productId;
	private Integer brandId;
	
	@BeforeEach
	void setUp() {		
		productId = 35455;
		brandId = 1;
	}
	
	@Test
	void findPriceByProductIdAndBrandIdIntoDateTestOK() {
		createOKTest(productId, brandId, LocalDateTime.parse("2020-06-14T10:00:00"), 35.5);
		createOKTest(productId, brandId, LocalDateTime.parse("2020-06-14T16:00:00"), 25.45);
		createOKTest(productId, brandId, LocalDateTime.parse("2020-06-14T21:00:00"), 35.5);
		createOKTest(productId, brandId, LocalDateTime.parse("2020-06-15T10:00:00"), 30.5);
		createOKTest(productId, brandId, LocalDateTime.parse("2020-06-16T21:00:00"), 38.95);
	}
	
	
	@Test
	void findPriceByProductIdAndBrandIdIntoDateTestKO() {
		createKOTest(33333, brandId, LocalDateTime.parse("2020-06-16T21:00:00"));
		createKOTest(productId, 2, LocalDateTime.parse("2020-06-16T21:00:00"));
	}
	
	
	private void createOKTest (Integer productId, Integer brandId, LocalDateTime date, Double priceExpected) {
		response = pricesRepository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		assertThat(response.stream().findFirst().get().getPrice(), equalTo(priceExpected));
	}
	
	private void createKOTest (Integer productId, Integer brandId, LocalDateTime date) {
		response = pricesRepository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		assertThat(response, IsEmptyCollection.empty());
	}
}
