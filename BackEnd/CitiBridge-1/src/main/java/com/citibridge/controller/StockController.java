package com.citibridge.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.citibridge.service.StockService;
import com.citibridge.entities.StockWrapper;
@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class StockController {
	@Autowired
	private StockService stockService;
	
	@GetMapping("/{sectorname}")
	public List<StockWrapper> getStocks(@PathVariable("sectorname") String sectorname) throws IOException {
			return stockService.getStockData(sectorname);
			
		
	}

}
