package com.inditex.service;


import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.dto.PriceDto;
import com.inditex.entity.Prices;
import com.inditex.repository.PricesRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PricesServiceImplTest {

	@Autowired
	private PricesService service;
	
	@Mock
	private PricesRepository repositoryMock;
		
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
	void getPriceDtoTestOK() {
		date = LocalDateTime.parse("2020-06-14T10:00:00");
		response = service.getPriceDataInfo(date, productId, brandId);

		Assertions.assertEquals(response.getProductId(), productId);
		Assertions.assertEquals(response.getBrandId(), brandId);
		Assertions.assertEquals(response.getDate(), date);
	}
	
	@Test
	void getPriceDtoTestKO() {
		when(repositoryMock.findPriceByProductIdAndBrandIdIntoDate(Mockito.any(Integer.class), Mockito.any(Integer.class), Mockito.any(LocalDateTime.class))).thenReturn(new ArrayList<Prices>());
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			service.getPriceDataInfo(date, productId, brandId);
		});
	}
	
	
}
