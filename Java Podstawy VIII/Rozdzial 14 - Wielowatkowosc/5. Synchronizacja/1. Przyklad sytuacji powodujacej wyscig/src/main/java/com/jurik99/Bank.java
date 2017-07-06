package com.jurik99;

public class Bank
{
	private final double[] accouts;

	/**
	 * Tworzy bank.
	 * @param howManyAccounts liczba kont
	 * @param initialBalance saldo poczatkowe na kazdym koncie
	 */
	public Bank(final int howManyAccounts, final double initialBalance)
	{
		accouts = new double[howManyAccounts];

		for (int i = 0; i < accouts.length; i++)
		{
			accouts[i] = initialBalance;
		}
	}

	/**
	 * Zwraca sume sald wszystkich kont.
	 * @return saldo ogolne
	 */
	public double getTotalBalance()
	{
		double sum = 0;

		for (final double balance : accouts)
		{
			sum += balance;
		}
		return sum;
	}

	/**
	 * Zwraca liczbe kont w banku.
	 * @return liczba kont
	 */
	public int size()
	{
		return accouts.length;
	}

	/**
	 * Przelewa pieniadze pomiedzy kontami.
	 * @param from konto, z ktorego ma nastapic przelew
	 * @param to konto, na ktore maja zostac przelane srodki
	 * @param amount kwota do przelania
	 */
	public void transfer(final int from, final int to, final double amount)
	{
		if (accouts[from] < amount)
			return;

		System.out.println(
				"(ID: " + Thread.currentThread().getId() + ") : (Name: " + Thread.currentThread().getName() + ")");

		accouts[from] -= amount;
		System.out.printf("Transfer %.2f z konta %d na konto %d. ", amount, from, to);
		accouts[to] += amount;
		System.out.printf("Saldo ogolne na wszystkich kontach łącznie: %.2f%n", getTotalBalance());
	}
}
