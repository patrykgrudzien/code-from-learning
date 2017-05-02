package com.jurik99;

import java.math.BigDecimal;

public class AccountWithBigDecimal
{
	public static void main(String[] args)
	{
		BigDecimal accountBalance = new BigDecimal(0.0);
		final BigDecimal point = new BigDecimal(0.01);

		for (int i = 0; i < 100; i++)
		{
			/*
			 * Za każdym razem kiedy chcemy zmienić BigDecimala, tak naprawdę NIE ZMIENIAMY go tylko
			 * TWORZYMY NA JEGO PODSTAWIE INNEGO !!!
			 */
			accountBalance = accountBalance.add(point);
		}

		System.out.println("Na koncie znajduje się " + accountBalance + "zł");

		/*
		 * Okazuje się, że na konie NIE MA PEŁNEJ ZŁOTÓWKI tylko liczba:
		 * 1.00000000000000002081668171172168513294309377670288085937500zł
		 *
		 * Nie ma tej pełnej złotówki, ponieważ tworząc liczbę "point = new BigDecimal(0.01)" już podaliśmy
		 * NIEPRACYZYJNĄ WARTOŚĆ.
		 */
		System.out.println("Jeden grosz = " + point);

		/*
		 * Tworząc BigDecimala zawsze podawaj parametr jako STRING !!!
		 */

		System.out.println("--------------------------------------------");

		BigDecimal accountBalanceUsingString = new BigDecimal("0.0");
		final BigDecimal pointUsingString = new BigDecimal("0.01");

		for (int i = 0; i < 100; i++)
		{
			accountBalanceUsingString = accountBalanceUsingString.add(pointUsingString);
		}

		System.out.println("Na koncie znajduje się " + accountBalanceUsingString + "zł");
	}
}
