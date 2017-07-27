package com.jurik99;

public class Bank
{
	private final double[] accounts;

	/**
	 * Tworzy bank.
	 * @param howManyAccounts liczba kont
	 * @param initialBalance saldo poczatkowe na kazdym koncie
	 */
	public Bank(final int howManyAccounts, final double initialBalance)
	{
		accounts = new double[howManyAccounts];

		for (int i = 0; i < accounts.length; i++)
		{
			accounts[i] = initialBalance;
		}
	}

	/**
	 * Zwraca sume sald wszystkich kont.
	 * @return saldo ogolne
	 */
	public double getTotalBalance()
	{
		double sum = 0;

		for (final double balance : accounts)
		{
			sum += balance;
		}
		return sum;
	}

	/**
	 * Zwraca liczbe kont w banku.
	 * @return liczba kont
	 */
	public int getAccountsSize()
	{
		return accounts.length;
	}

	/**
	 * Przelewa pieniadze pomiedzy kontami.
	 * @param from konto, z ktorego ma nastapic przelew
	 * @param to konto, na ktore maja zostac przelane srodki
	 * @param amount kwota do przelania
	 */
	public void transfer(final int from, final int to, final double amount)
	{
		if (accounts[from] < amount)
			return;

		System.out.println(
				"(ID: " + Thread.currentThread().getId() + ") : (Name: " + Thread.currentThread().getName() + ")");

		accounts[from] -= amount;
		System.out.printf("Transfer %.2f z konta %d na konto %d. ", amount, from, to);
		accounts[to] += amount;
		System.out.printf("Saldo ogolne na wszystkich kontach łącznie: %.2f%n", getTotalBalance());
	}
}
