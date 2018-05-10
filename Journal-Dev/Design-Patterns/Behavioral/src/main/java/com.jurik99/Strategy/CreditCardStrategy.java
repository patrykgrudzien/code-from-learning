package com.jurik99.Strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreditCardStrategy implements PaymentStrategy {

	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	@Override
	public void pay(final int amount) {
		System.out.println(amount + " paid with credit/debit card.");
	}
}
