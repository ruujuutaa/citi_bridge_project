package com.citibridge.service;

import java.util.List;

import com.citibridge.entities.StockWrapper;

public interface StockService {
	public List<StockWrapper> getStockData(String sector);
}
