package com.citibridge.dao;

import com.citibridge.entities.Account;

public interface AccountDAO {
	public int login(String username, String password);
	public int addStocks(String stock, String username);
	public int removeStock(String stock, String username);
}
