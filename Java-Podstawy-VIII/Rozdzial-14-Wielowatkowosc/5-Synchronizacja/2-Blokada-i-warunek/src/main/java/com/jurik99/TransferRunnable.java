package com.jurik99;

@SuppressWarnings("ALL")
public class TransferRunnable implements Runnable
{
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private final int DELAY = 10;

	/**
	 * Tworzy obiekt Runnable do przelewania srodkow.
	 * @param bank bank, na ktorego kontach wykonywany jest przelew
	 * @param fromAccount konto, z ktorego maja byc przelane pieniadze
	 * @param maxAmount maksymalna suma, jaka moze zostac przelana za kazdym razem
	 */
	public TransferRunnable(final Bank bank, final int fromAccount, final double maxAmount)
	{
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAmount = maxAmount;
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				final int toAccount = (int) (bank.size() * Math.random());
				final double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((long) (DELAY * Math.random()));
			}
		}
		catch (final InterruptedException exception)
		{
			exception.printStackTrace();
		}
	}
}
