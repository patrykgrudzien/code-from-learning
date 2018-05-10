package com.jurik99.Strategy;

public class PayPalStrategy implements PaymentStrategy
{
	private String emailId;
	private String password;

	public PayPalStrategy(final String emailId, final String password)
	{
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public void pay(final int amount)
	{
		System.out.println(amount + " paid using PayPal.");
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(final String emailId)
	{
		this.emailId = emailId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}
}
