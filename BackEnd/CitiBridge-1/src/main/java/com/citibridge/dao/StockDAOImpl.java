package com.citibridge.dao;

import java.io.IOException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citibridge.StockComparator;
import com.citibridge.entities.StockWrapper;
import com.mongodb.client.MongoCollection;

import lombok.AllArgsConstructor;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import yahoofinance.quotes.stock.StockStats;
@AllArgsConstructor
@Repository("stockDAO")

public class StockDAOImpl implements StockDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<StockWrapper> getStockData(String sector)  {
		String[] stockNames= {
				"ACC.NS",
				"ADANIENT.NS",
				"ADANIGREEN.NS",
				"ADANIPORTS.NS",
				"ADANITRANS.NS",
				"AMBUJACEM.NS",
				"APOLLOHOSP.NS",
				"ASIANPAINT.NS",
				"DMART.NS",
				"AXISBANK.NS",
				"BAJAJ-AUTO.NS",
				"BAJFINANCE.NS",
				"BAJAJFINSV.NS",
				"BAJAJHLDNG.NS",
				"BANDHANBNK.NS",
				"BANKBARODA.NS",
				"BERGEPAINT.NS",
				"BPCL.NS",
				"BHARTIARTL.NS",
				"BIOCON.NS",
				"BOSCHLTD.NS",
				"BRITANNIA.NS",
				"CHOLAFIN.NS",
				"CIPLA.NS",
				"COALINDIA.NS",
				"COLPAL.NS",
				"DLF.NS",
				"DABUR.NS",
				"DIVISLAB.NS",
				"DRREDDY.NS",
				"EICHERMOT.NS",
				"NYKAA.NS",
				"GAIL.NS",
				"GLAND.NS",
				"GODREJCP.NS",
				"GRASIM.NS",
				"HCLTECH.NS",
				"HDFCAMC.NS",
				"HDFCBANK.NS",
				"HDFCLIFE.NS",
				"HAVELLS.NS",
				"HEROMOTOCO.NS",
				"HINDALCO.NS",
				"HINDUNILVR.NS",
				"HDFC.NS",
				"ICICIBANK.NS",
				"ICICIGI.NS",
				"ICICIPRULI.NS",
				"ITC.NS",
				"IOC.NS",
				"INDUSTOWER.NS",
				"INDUSINDBK.NS",
				"NAUKRI.NS",
				"INFY.NS",
				"INDIGO.NS",
				"JSWSTEEL.NS",
				"JUBLFOOD.NS",
				"KOTAKBANK.NS",
				"LTI.NS",
				"LT.NS",
				"LUPIN.NS",
				"M&M.NS",
				"MARICO.NS",
				"MARUTI.NS",
				"MINDTREE.NS",
				"MUTHOOTFIN.NS",
				"NMDC.NS",
				"NTPC.NS",
				"NESTLEIND.NS",
				"ONGC.NS",
				"PAYTM.NS",
				"PIIND.NS",
				"PIDILITIND.NS",
				"PEL.NS",
				"POWERGRID.NS",
				"PGHH.NS",
				"PNB.NS",
				"RELIANCE.NS",
				"SBICARD.NS",
				"SBILIFE.NS",
				"SRF.NS",
				"SHREECEM.NS",
				"SIEMENS.NS",
				"SBIN.NS",
				"SAIL.NS",
				"SUNPHARMA.NS",
				"TCS.NS",
				"TATACONSUM.NS",
				"TATAMOTORS.NS",
				"TATASTEEL.NS",
				"TECHM.NS",
				"TITAN.NS",
				"TORNTPHARM.NS",
				"UPL.NS",
				"ULTRACEMCO.NS",
				"MCDOWELL-N.NS",
				"VEDL.NS",
				"WIPRO.NS",
				"ZOMATO.NS",
				"ZYDUSLIFE.NS",
	};
	String[] sectors = {
				"Construction Materials",
				"Metals & Mining",
				"Power",
				"Services",
				"Power",
				"Construction Materials",
				"Healthcare",
				"Consumer Durables",
				"Consumer Services",
				"Financial Services",
				"Automobile and Auto Components",
				"Financial Services",
				"Financial Services",
				"Financial Services",
				"Financial Services",
				"Financial Services",
				"Consumer Durables",
				"Oil Gas & Consumable Fuels",
				"Telecommunication",
				"Healthcare",
				"Automobile and Auto Components",
				"Fast Moving Consumer Goods",
				"Financial Services",
				"Healthcare",
				"Oil Gas & Consumable Fuels",
				"Fast Moving Consumer Goods",
				"Realty",
				"Fast Moving Consumer Goods",
				"Healthcare",
				"Healthcare",
				"Automobile and Auto Components",
				"Consumer Services",
				"Oil Gas & Consumable Fuels",
				"Healthcare",
				"Fast Moving Consumer Goods",
				"Construction Materials",
				"Information Technology",
				"Financial Services",
				"Financial Services",
				"Financial Services",
				"Consumer Durables",
				"Automobile and Auto Components",
				"Metals & Mining",
				"Fast Moving Consumer Goods",
				"Financial Services",
				"Financial Services",
				"Financial Services",
				"Financial Services",
				"Fast Moving Consumer Goods",
				"Oil Gas & Consumable Fuels",
				"Telecommunication",
				"Financial Services",
				"Consumer Services",
				"Information Technology",
				"Services",
				"Metals & Mining",
				"Consumer Services",
				"Financial Services",
				"Information Technology",
				"Construction",
				"Healthcare",
				"Automobile and Auto Components",
				"Fast Moving Consumer Goods",
				"Automobile and Auto Components",
				"Information Technology",
				"Financial Services",
				"Metals & Mining",
				"Power",
				"Fast Moving Consumer Goods",
				"Oil Gas & Consumable Fuels",
				"Financial Services",
				"Chemicals",
				"Chemicals",
				"Financial Services",
				"Power",
				"Fast Moving Consumer Goods",
				"Financial Services",
				"Oil Gas & Consumable Fuels",
				"Financial Services",
				"Financial Services",
				"Chemicals",
				"Construction Materials",
				"Capital Goods",
				"Financial Services",
				"Metals & Mining",
				"Healthcare",
				"Information Technology",
				"Fast Moving Consumer Goods",
				"Automobile and Auto Components",
				"Metals & Mining",
				"Information Technology",
				"Consumer Durables",
				"Healthcare",
				"Chemicals",
				"Construction Materials",
				"Fast Moving Consumer Goods",
				"Metals & Mining",
				"Information Technology",
				"Consumer Services",
				"Healthcare",

		};
		StockWrapper[] Nifty100 = new StockWrapper[stockNames.length];
		int num=stockNames.length;
		for(int i=0;i<num;i++) {
			StockWrapper stock = new StockWrapper();
			stock.setName(stockNames[i]);
			stock.setSector(sectors[i]);
			Nifty100[i]=stock;
		}
		List<StockWrapper> stocks = new ArrayList<StockWrapper>();
		for(int i=0;i<num;i++) {
			
			if(Nifty100[i].getSector().equals(sector))
			{
				stocks.add(Nifty100[i]);
			}
		}
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.add(Calendar.DATE,-15);
		Stock stock;
		List<HistoricalQuote> history;
		for(int i=0;i<stocks.size();i++)
		{
			
			try {
				stock = YahooFinance.get(stocks.get(i).getName(),startDate,endDate,Interval.DAILY);
				history = stock.getHistory();
				stocks.get(i).setPrice(stock.getQuote().getPrice());
				BigDecimal today=history.get(history.size()-1).getHigh();
				BigDecimal before=history.get(0).getHigh();
				BigDecimal gain=today.subtract(before).divide(before,4, RoundingMode.HALF_UP);
				stocks.get(i).setGain(gain);
				stocks.get(i).setPe(stock.getStats().getPe());
			} catch (IOException e) {
				System.out.println("server error");
			}
			
			/*for(HistoricalQuote quote : history)
			{
				System.out.println(quote.getHigh() );
				System.out.println(quote.getDate().getTime());
			}*/
			
		}
		Collections.sort(stocks,new StockComparator());
		List<StockWrapper> top5= new ArrayList<StockWrapper>();
		for(int i=0;i<5;i++)
		{
			top5.add(stocks.get(i));
		}
		return top5; 
		
	}
	
	public void addTop5(ArrayList<StockWrapper> stocks) {
		
		//Query query = new Query();
		for(int i=0;i<5;i++)
		{
			mongoTemplate.insert(stocks.get(i),"AutoComponents");
		}
	}
	
	public List<StockWrapper> getTop5(String collectionName){
		List<StockWrapper> top5  = new ArrayList<StockWrapper>();
		top5=mongoTemplate.findAll(StockWrapper.class, collectionName);
		return top5;
	}
		
		
		
		
		
	
	
	
	
	
	
	
}
