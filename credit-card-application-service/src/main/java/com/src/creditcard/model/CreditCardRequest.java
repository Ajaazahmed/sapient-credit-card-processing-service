package com.src.creditcard.model;

import lombok.Value;

@Value
public class CreditCardRequest {
	
	private String name;
	private String cardNumber;
	private String limit;

}
