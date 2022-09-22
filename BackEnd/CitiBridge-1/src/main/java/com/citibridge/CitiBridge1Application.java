package com.citibridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import org.bson.Document;

import com.citibridge.entities.Account;
import com.citibridge.service.AccountService;
import com.mongodb.MongoClient;
@SpringBootApplication

public class CitiBridge1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext apc=
		SpringApplication.run(CitiBridge1Application.class, args);
		//AccountService accountService = (AccountService)apc;
		AccountService accountService = (AccountService) apc.getBean("accountService");
		//System.out.println(accountService.getClass().getName());
		System.out.println(accountService.login("ruju130301", "r78412p"));
		
	}
}

