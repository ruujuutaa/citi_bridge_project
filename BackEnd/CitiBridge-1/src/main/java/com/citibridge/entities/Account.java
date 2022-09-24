package com.citibridge.entities;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class Account {
	private String userName;
	private String password;
	private String[] stocks;
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

}
