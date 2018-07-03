package com.jurik99;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierTest
{
	/**
	 * The supplier does the opposite of the consumer, so it takes no arguments but it returns some value by calling
	 * its "get()" method.
	 *
	 * NOTE: This may return different values when it is being called more than once.
	 */
	public static void main(final String[] args)
	{
		// --- SUPPLIER INSTANCE WITH LAMBDA EXPRESSION ---
		final Supplier<String> helloStrSupplier = () -> "Hello";
		System.out.println(helloStrSupplier.get());

		// --- SUPPLIER INSTANCE USING METHOD REFERENCE TO DEFAULT CONSTRUCTOR ---
		final Supplier<String> emptyStrSupplier = String::new;
		final String emptyStr = emptyStrSupplier.get();
		System.out.println("String in emptyStr is ->" + emptyStr + "<-");

		// --- SUPPLIER INSTANCE USING METHOD REFERENCE TO A STATIC METHOD ---
		final Supplier<Date> dateSupplier = SupplierTest::getSystemDate;
		final Date systemDate = dateSupplier.get();
		System.out.println("systemDate -> " + systemDate);
	}

	private static Date getSystemDate()
	{
		return new Date();
	}
}
