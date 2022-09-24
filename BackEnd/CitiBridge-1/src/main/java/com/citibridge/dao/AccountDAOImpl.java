package com.citibridge.dao;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.citibridge.entities.Account;
import com.citibridge.entities.StockWrapper;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public int login(String username, String password){
			Query query = new Query(Criteria.where("username").is(username));
			Account account = mongoTemplate.findOne(query,Account.class);
			//System.out.println(account);
			if(account!=null) {
				if(password.equals(account.getPassword()))
					return 1;
				else
					return 0;
							
			}
			else
				return 0;
				
	}
	@Override
	public int addStocks(String stock, String username) {
		Query query = new Query(Criteria.where("username").is(username));
		ArrayList<String> stocks = new ArrayList<String>();
		String[] prevStocks = mongoTemplate.findOne(query, Account.class).getStocks();
		stocks.addAll(Arrays.asList(prevStocks));
		stocks.add(stock);
		mongoTemplate.updateFirst(query,Update.update("stocks", stocks.toArray()), Account.class);	
		return 1;
	}
	@Override
	public int removeStock(String stock, String username) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("username").is(username));
		ArrayList<String> stocks = new ArrayList<String>();
		String[] prevStocks = mongoTemplate.findOne(query, Account.class).getStocks();
		stocks.addAll(Arrays.asList(prevStocks));
		stocks.remove(stock);
		mongoTemplate.updateFirst(query,Update.update("stocks", stocks.toArray()), Account.class);	
		return 1;
		
	}
	@Override
	public List<StockWrapper> getSavedStocks(String username) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("username").is(username));
		ArrayList<String> stocks = new ArrayList<String>();
		String[] savedStockNames = mongoTemplate.findOne(query, Account.class).getStocks();
		List<StockWrapper> savedStocks = new ArrayList<StockWrapper>();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.add(Calendar.DATE,-15);
		Stock stock;
		List<HistoricalQuote> history;
		for(int i=0;i<savedStockNames.length;i++)
		{
			try {
				stock = YahooFinance.get(savedStockNames[i],startDate,endDate,Interval.DAILY);
				history = stock.getHistory();
				StockWrapper st = new StockWrapper();
				st.setName(savedStockNames[i]);
				st.setPrice(stock.getQuote().getPrice());
				BigDecimal today=history.get(history.size()-1).getHigh();
				BigDecimal before=history.get(0).getHigh();
				BigDecimal gain=today.subtract(before).divide(before,4, RoundingMode.HALF_UP);
				st.setGain(gain);
				st.setPe(stock.getStats().getPe());
				savedStocks.add(st);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("server error");
			}
			
			
		}
		return savedStocks;
		
	}

}
