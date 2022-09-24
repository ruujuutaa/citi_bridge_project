package com.citibridge.dao;

import java.util.List;

import com.citibridge.entities.Account;
import com.citibridge.entities.StockWrapper;

public interface AccountDAO {
	public int login(String username, String password);
	public int addStocks(String stock, String username);
	public int removeStock(String stock, String username);
	public List<StockWrapper> getSavedStocks(String username);
}
