package com.jurik99.Strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCard
{
	// --- List of items ---
	private List<Item> items;

	public ShoppingCard()
	{
		this.items = new ArrayList<>();
	}

	public void addItem(final Item item)
	{
		this.items.add(item);
	}

	public void removeItem(final Item item)
	{
		this.items.remove(item);
	}

	private int calculateTotal()
	{
		int sum = 0;
		for (final Item item : items)
		{
			sum += item.getPrice();
		}
		return sum;
	}

	public void pay(final PaymentStrategy paymentStrategy)
	{
		final int amount = calculateTotal();
		paymentStrategy.pay(amount);
	}
}
