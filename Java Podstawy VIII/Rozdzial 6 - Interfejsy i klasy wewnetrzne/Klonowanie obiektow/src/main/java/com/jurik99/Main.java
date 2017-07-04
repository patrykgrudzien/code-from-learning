package com.jurik99;

public class Main
{
	public static void main(final String[] args)
	{
		final Employee original = new Employee("Patryk", 4000);
		final Employee shallowCopy = original;

		shallowCopy.setName("Damian");

		System.out.println("Original: " + original);
		System.out.println("Shallow copy: " + shallowCopy);

		System.out.println("--------------------------------------------");

		final Employee original2 = new Employee("Patryk", 4000);
		Employee deepCopy = null;

		try
		{
			deepCopy = (Employee) original2.clone();
		}
		catch (final CloneNotSupportedException exception)
		{
			System.err.println("Clone is not supported!");
		}

		if (deepCopy != null)
		{
			deepCopy.setSalary(1111);
		}
		System.out.println("Original 2: " + original2);
		System.out.println("Deep copy: " + deepCopy);
	}
}
