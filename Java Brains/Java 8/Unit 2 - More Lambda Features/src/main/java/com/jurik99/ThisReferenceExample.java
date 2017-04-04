package com.jurik99;

public class ThisReferenceExample
{
	public static void main(String[] args)
	{
		final ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(10, new Process()
		{
			@Override
			public void process(final int i)
			{
				System.out.println("Value of i is: " + i);
				System.out.println(this);
			}

			@Override
			public String toString()
			{
				return "This is the anonymous inner class " + this.getClass().getName();
			}
		});

		// --- LAMBDA EXPRESSION ---
		/*
		 * In case of anonymous inner class "this" refers to instance of that anonymous inner class.
		 * In case of LAMBDA, the instance of a lambda does not touch "this" reference, "this" is unmodified when we
		 * use it in lambda expression.
		 *
		 * So when we use lambda expression in any part of the code, value of "this" reference is basically the same
		 * as what "this" reference would have been outside of lambda expression. Lambda does not override "this"
		 * reference and it still referes to STATIC context which "main" method has.
		 */
		thisReferenceExample.doProcess(20, i ->
		{
			System.out.println("Value of i is: " + i);
			// System.out.println(this);   NOT WORK !!!
		});

		thisReferenceExample.execute();
	}

	private void execute()
	{
		doProcess(10, i ->
		{
			System.out.println("Value of i is: " + i);
			/*
			 * it's not in a STATIC context
			 * it's inside of LAMBDA (and that's why it's not modified)
			 *
			 * "this" refers to the same value as would have refered outside of lambda expression
			 *
			 * "this" points to instance of ThisReferenceExample class !!!
			 */
			System.out.println(this);
		});
	}

	// --- INSTANCE METHOD ---
	private void doProcess(final int i, final Process p)
	{
		p.process(i);
	}
}
