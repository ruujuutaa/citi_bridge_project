package com.citibridge.controller;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpSession;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citibridge.entities.Account;
//import com.citibridge.entities.Account;
import com.citibridge.service.AccountService;

@RestController
@CrossOrigin("*")	//provide support to any domain
@RequestMapping("/api/user")
public class AccountController {
	/*@RequestMapping("/home")
	public String getHomePage() {
		return "index";
	}*/

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/login")
	public int login(@RequestBody Account account) {
			return accountService.login(account.getUserName(), account.getPassword());
			
		
	}
	@GetMapping("/update/{stock}/{username}")
	@ResponseBody
	public int addStocks(@PathVariable("stock") String stock, @PathVariable("username") String username) 
	{
		System.out.println(stock + username);
		return accountService.addStocks(stock,username);
	}
	
	@GetMapping("/remove/{stock}/{username}")
	@ResponseBody
	public int removeStock(@PathVariable("stock") String stock, @PathVariable("username") String username) 
	{
		System.out.println(stock + username);
		return accountService.removeStock(stock,username);
	}
	
	
}

	
	


