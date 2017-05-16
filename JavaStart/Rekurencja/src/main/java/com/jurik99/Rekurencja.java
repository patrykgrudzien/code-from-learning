package com.jurik99;

public class Rekurencja
{
	public static void main(final String[] args)
	{
		final Rekurencja rekurencja = new Rekurencja();

		System.out.println("Suma - sposób iteracyjny dla liczb <= 8 wynosi: " + rekurencja.sumaIteracja(8));
		System.out.println("--------------------------------------------");
		System.out.println("Suma - sposób rekurencyjny dla liczb <= 10 wynosi:  " +
		                   rekurencja.sumaRekurencja(10));
		System.out.println("--------------------------------------------");
		System.out.println("Suma - sposób rekurencyjny (ternary operator) dla liczb <= 10 wynosi: " +
		                   rekurencja.sumaRekurencjaTernaryOperator(10));
		System.out.println("--------------------------------------------");
		System.out.println("Fibonacci - 11 wyraz ciągu to = " + rekurencja.fibonacciIteracja(11));
		System.out.println("--------------------------------------------");
		System.out.println("Fibonacci Rekurencja - 6 wyraz ciągu to = " +
		                   rekurencja.fibonacciRekurencja(6));
		System.out.println("--------------------------------------------");
		System.out.println("Fibonacci Rekurencja (ternary operator) - 6 wyraz ciągu to = " +
		                   rekurencja.fibonacciRekurencjaTernaryOperator(6));
	}

	/*
	 * Metoda, która sumuje wszystkie liczby naturalne mniejsze lub równe liczbie podanej jako parametr
	 */
	private int sumaIteracja(int number)
	{
		System.out.println("Liczby, które będą do siebie dodawane:");
		for (int i = 1; i <= number; i++)
		{
			System.out.print(i + "  ");
		}
		System.out.println();

		int sum = 0;
		while (number > 0)
		{
			sum += number;
			number--;
		}
		return sum;
	}

	// --- SPOSÓB REKURENCYJNY ---
	private int sumaRekurencja(final int number)
	{
		if (number == 0)
		{
			return 0;
		}
		else
		{
			return number + sumaRekurencja(number - 1);
		}
	}

	// --- SPOSÓB REKURENCYJNY (TERNARY OPERATOR) ---
	private int sumaRekurencjaTernaryOperator(final int number)
	{
		return number == 0 ? 0 : number + sumaRekurencjaTernaryOperator(number - 1);
	}

	/*
	 * Ciąg Fibonacciego
	 * 1 1 2 3 5 8 13 21 34 55 89 itd...
	 */
	private int fibonacciIteracja(final int n)
	{
		int first = 1;
		int second = 1;
		int sum = 1;

		for (int i = 2; i < n; i++)
		{
			sum = first + second;
			first = second;
			second = sum;
		}
		return sum;
	}

	// --- SPOSÓB REKURENCYJNY ---
	private int fibonacciRekurencja(final int numerWyrazuWCiagu)
	{
		if (numerWyrazuWCiagu > 2)
		{
			return fibonacciRekurencja(numerWyrazuWCiagu - 2) + fibonacciRekurencja(numerWyrazuWCiagu - 1);
		}
		else
		{
			return 1;
		}
	}

	// --- SPOSÓB REKURENCYJNY (TERNARY OPERATOR) ---
	private int fibonacciRekurencjaTernaryOperator(final int n)
	{
		return n > 2 ? fibonacciRekurencja(n - 2) + fibonacciRekurencja(n - 1) : n;
	}
}
