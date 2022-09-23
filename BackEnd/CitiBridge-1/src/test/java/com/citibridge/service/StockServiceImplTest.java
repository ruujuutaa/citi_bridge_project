package com.citibridge.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citibridge.entities.StockWrapper;
@SpringBootTest
class StockServiceImplTest {
	@Autowired
	private StockServiceImpl stockService;

	@Test
	void invoke() throws IOException {
		//final StockWrapper stock = stockService.findstock("UU.L");
		//System.out.println(stock.getStock());
		//final BigDecimal price = stockService.findPrice(stock);
		//System.out.println(price);
	}

}
