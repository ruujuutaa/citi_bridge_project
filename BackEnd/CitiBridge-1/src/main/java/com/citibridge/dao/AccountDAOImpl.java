package com.citibridge.dao;

import org.springframework.stereotype.Repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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

}
