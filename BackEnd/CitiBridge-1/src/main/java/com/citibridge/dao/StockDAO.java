package com.citibridge.dao;

import java.util.List;

import com.citibridge.entities.StockWrapper;

public interface StockDAO {
	public List<StockWrapper> getStockData(String sector);
}
