package com.citibridge.service;

import com.citibridge.entities.Account;

import java.util.List;

import com.citibridge.entities.*;
public interface AccountService {
	public int login(String username, String password);
	public int addStocks(String stock, String username);
	public int removeStock(String stock, String username);
	public List<StockWrapper> getSavedStocks(String username);
}
