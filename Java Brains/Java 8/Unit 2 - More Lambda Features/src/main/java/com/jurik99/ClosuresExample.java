package com.jurik99;

public class ClosuresExample
{
	public static void main(final String[] args)
	{
		final int a = 10;
		final int b = 20;

		doProcess(a, new Process()
		{
			@Override
			public void process(final int i)
			{
				// b = 40;  ERROR !!!
				System.out.println(i + b);
			}
		});

		doProcess(a, i -> System.out.println(i + b));
	}

	private static void doProcess(final int i, final Process p)
	{
		p.process(i);
	}
}

interface Process
{
	void process(final int i);
}
