package com.jurik99;

public class RunnableExample
{
	public static void main(final String[] args)
	{
		final Thread myThread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("Printed inside Runnable");
			}
		});

		myThread.start();

		// --- LAMBDA ---
		final Thread myLambdaThread = new Thread(() -> System.out.println("Printed in lambda expression"));
		myLambdaThread.start();
	}
}