package com.jurik99.Strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PayPalStrategy implements PaymentStrategy {

	private String emailId;
	private String password;

	@Override
	public void pay(final int amount) {
		System.out.println(amount + " paid using PayPal.");
	}
}
