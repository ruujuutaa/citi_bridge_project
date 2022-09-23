package com.citibridge.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;
import yahoofinance.Stock;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class StockWrapper {
	private String name;
	private BigDecimal price;
	private BigDecimal gain;
	private String Sector;
	private BigDecimal pe;

}
