package com.src.creditcard.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="CreditCard")
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
	@Id
	@Column(columnDefinition = "card_name")
    private String cardName;
	
	@Column(columnDefinition = "card_number")
    private long cardNumber;
	
	@Column(columnDefinition = "card_balance")
    private double cardBalance;
	
	@Column(columnDefinition = "card_limit")
    private int cardLimit;

}
