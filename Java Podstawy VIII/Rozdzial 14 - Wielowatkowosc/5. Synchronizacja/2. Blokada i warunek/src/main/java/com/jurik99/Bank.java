package com.jurik99;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("FieldCanBeLocal")
public class Bank
{
	private final double[] accounts;

	private Lock bankLock;
	private Condition sufficientFunds;

	/**
	 * Tworzy bank.
	 * @param n liczba kont
	 * @param initialBalance saldo poczatkowe na kazdym koncie
	 */
	public Bank(final int n, final double initialBalance)
	{
		accounts = new double[n];

		for (int i = 0; i < accounts.length; i++)
		{
			accounts[i] = initialBalance;
		}
		bankLock = new ReentrantLock();

		/*
		 * Condition newCondition()
		 * Zwraca obiekt warunku zwiazany z blokada.
		 */
		sufficientFunds = bankLock.newCondition();
	}

	/**
	 * Przelewa pieniadze pomiedzy kontami.
	 * @param from konto, z ktorego ma nastapic przelew
	 * @param to konto, na ktore maja zostac przelane srodki
	 * @param amount kwota do przelania
	 */
	public void transfer(final int from, final int to, final double amount) throws InterruptedException
	{
		bankLock.lock();

		try
		{
			while (accounts[from] < amount)
			{
				sufficientFunds.await();
				/*
				 * void await()
				 * Umieszcza watek w kolejce oczekujacych do warunku.
				 */
			}

			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf("Transfer %.2f z konta %d na konto %d. ", amount, from, to);
			accounts[to] += amount;
			System.out.printf("Saldo ogolne na wszystkich kontach łącznie: %.2f%n", getTotalBalance());

			/*
			 * void signalAll()
			 * Odblokowuje wszystkie watki znajdujace sie w kolejce oczekujacych do warunku.
			 */
			sufficientFunds.signalAll();
		}
		finally
		{
			bankLock.unlock();
		}
	}

	/**
	 * Zwraca sume sald wszystkich kont.
	 * @return saldo ogolne
	 */
	public double getTotalBalance()
	{
		bankLock.lock();

		try
		{
			double sum = 0;

			for (final double a : accounts)
			{
				sum += a;
			}
			return sum;
		}
		finally
		{
			bankLock.unlock();
		}
	}

	/**
	 * Zwraca liczbe kont w banku.
	 * @return liczba kont
	 */
	public int size()
	{
		return accounts.length;
	}
}
