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

import com.inditex.entities.Prices;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PricesRepositoryTest {
	
	@Autowired
    private PricesRepository pricesRepository;
	
	List<Prices> response;	
	private LocalDateTime date;
	private Integer productId;
	private Integer brandId;
	
	@BeforeEach
	void setUp() {		
		productId = 35455;
		brandId = 1;
	}
	
	@Test
	void findPriceByProductIdAndBrandIdIntoDateTestOK1() {
		date = LocalDateTime.parse("2020-06-14T10:00:00");
		response = pricesRepository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		
		assertThat(response.stream().findFirst().get().getPrice(), equalTo(35.5));
	}
	
	@Test
	void findPriceByProductIdAndBrandIdIntoDateTestOK2() {
		date = LocalDateTime.parse("2020-06-14T16:00:00");
		response = pricesRepository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		
		assertThat(response.stream().findFirst().get().getPrice(), equalTo(25.45));
	}
	
	@Test
	void findPriceByProductIdAndBrandIdIntoDateTestOK3() {
		date = LocalDateTime.parse("2020-06-14T21:00:00");
		response = pricesRepository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		
		assertThat(response.stream().findFirst().get().getPrice(), equalTo(35.5));
	}
	
	@Test
	void findPriceByProductIdAndBrandIdIntoDateTestOK4() {
		date = LocalDateTime.parse("2020-06-15T10:00:00");
		response = pricesRepository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		
		assertThat(response.stream().findFirst().get().getPrice(), equalTo(30.5));
	}
	
	@Test
	void findPriceByProductIdAndBrandIdIntoDateTestOK5() {
		date = LocalDateTime.parse("2020-06-16T21:00:00");
		response = pricesRepository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);
		
		assertThat(response.stream().findFirst().get().getPrice(), equalTo(38.95));
	}
	
	@Test
	void findPriceByProductIdAndBrandIdIntoDateTestKO6() {
		productId = 33333;
		response = pricesRepository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);

		assertThat(response, IsEmptyCollection.empty());
	}
	
	@Test
	void findPriceByProductIdAndBrandIdIntoDateTestKO7() {
		brandId = 2;
		response = pricesRepository.findPriceByProductIdAndBrandIdIntoDate(productId, brandId, date);

		assertThat(response, IsEmptyCollection.empty());
	}
}
