package com.jurik99;

public class TypeInferenceExample
{
	public static void main(final String[] args)
	{
		final StringLengthLambda myLambda = s -> s.length();
		System.out.println(myLambda.getLength("Patryk"));

		// --- pass lambda into method ---
		printLambda(p -> p.length());
	}

	private static void printLambda(final StringLengthLambda lambda)
	{
		System.out.println("Length: " + lambda.getLength("Patryk Hello Lambda"));
	}

	interface StringLengthLambda
	{
		int getLength(final String s);
	}
}