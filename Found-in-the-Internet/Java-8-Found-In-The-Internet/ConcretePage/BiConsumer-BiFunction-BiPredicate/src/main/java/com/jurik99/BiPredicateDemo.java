package com.jurik99;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

	public static void main(final String[] args) {

		/**
		 * java.util.function.BiPredicate is a functional interface which accepts two argument and returns Boolean value.
		 * Apply business logic for the values passed as an argument and return the boolean value. BiPredicate functional
		 * method is test(Object, Object). Find the simple example for how to use BiPredicate.
		 */
		BiPredicate<Integer, String> biPredicate = (integer, string) -> integer > 20 && string.startsWith("R");

		System.out.println(biPredicate.test(10, "Ram"));
		System.out.println(biPredicate.test(30, "Shyam"));
		System.out.println(biPredicate.test(30, "Ram"));
	}
}
