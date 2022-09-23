package com.citibridge.service;

import java.io.IOException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citibridge.StockComparator;
import com.citibridge.dao.StockDAOImpl;
import com.citibridge.entities.StockWrapper;
import com.mongodb.client.MongoCollection;

import lombok.AllArgsConstructor;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import yahoofinance.quotes.stock.StockStats;
@AllArgsConstructor
@Service("stockService")

public class StockServiceImpl {
	
	@Autowired
	private StockDAOImpl stockRepo;
	
	public List<StockWrapper> getStockData(String sector)  {
		
		return stockRepo.getStockData(sector); 
		
	}
	
	public void addTop5(ArrayList<StockWrapper> stocks) {
		
		stockRepo.addTop5(stocks);
		
	}
	
	public List<StockWrapper> getTop5(String collectionName){
		
		return stockRepo.getTop5(collectionName);
	}
		
		
		
		
		
	
	
	
	
	
	
	
}
