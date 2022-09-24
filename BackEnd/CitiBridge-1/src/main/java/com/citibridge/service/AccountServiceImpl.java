package com.citibridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citibridge.dao.AccountDAO;
import com.citibridge.entities.Account;
import com.citibridge.entities.StockWrapper;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO;
	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		return accountDAO.login(username, password);
	}
	@Override
	public int addStocks(String stock, String username) {
		// TODO Auto-generated method stub
		return accountDAO.addStocks(stock,username);
	}
	@Override
	public int removeStock(String stock, String username) {
		// TODO Auto-generated method stub
		return accountDAO.removeStock(stock,username);
	}
	@Override
	public List<StockWrapper> getSavedStocks(String username) {
		// TODO Auto-generated method stub
		return accountDAO.getSavedStocks(username);
	}

}
