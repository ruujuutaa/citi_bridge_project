package com.citibridge.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.citibridge.entities.Account;
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

}
