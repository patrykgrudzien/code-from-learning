package com.jurik99;

public class AccountWithDouble
{
	public static void main(final String[] args)
	{
		double accountBalance = 0.0;

		for (int i = 0; i < 100; i++)
		{
			accountBalance += 0.01;
		}

		System.out.println("Na koncie znajduje się " + accountBalance + " zł");

		/*
		 * Okazuje sie, że na koncie znajduje się "1.0000000000000007 zł" zamiast JEDNEJ złotówki.
		 *
		 * Spowodowane jest to tym, że liczba taka jak "0.01" zapisana w systemie dziesiętnym i
		 * NIE DA SIĘ JEJ ZAPISAĆ W SYSTEMIE BINARNYM !!!
		 * Komputer przechowuje wszystkie wartości w postaci ZER-JEDYNEK.
		 *
		 *
		 */
	}
}
