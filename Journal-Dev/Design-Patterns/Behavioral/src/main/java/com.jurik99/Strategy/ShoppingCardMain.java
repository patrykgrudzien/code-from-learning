package com.jurik99.Strategy;

public class ShoppingCardMain {

	public static void main(final String[] args) {
		final ShoppingCard card = new ShoppingCard();

		final Item item1 = new Item("1234", 10);
		final Item item2 = new Item("5678", 40);

		card.addItem(item1);
		card.addItem(item2);

		// --- pay by PayPal ---
		card.pay(new PayPalStrategy("myEmail@example.com", "password"));

		// --- pay by credit card ---
		card.pay(new CreditCardStrategy("JuRik99", "123456789", "000", "20/18"));

		/*
		 * Strategy pattern is useful when we have multiple Algorithms for specific task and we want our application
		 * to be flexible to choose any of the algorithm at RUNTIME for specific task.
		 */
	}
}
