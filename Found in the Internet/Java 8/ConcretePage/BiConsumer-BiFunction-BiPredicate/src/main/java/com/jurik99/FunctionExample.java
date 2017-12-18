package com.jurik99;

import java.util.function.Function;

public class FunctionExample {

	public static void main(final String[] args) {

		// --- FIRST EXAMPLE ---
		Function<Integer, Integer> times2 = (integer) -> integer * 2;
		Function<Integer, Integer> squared = (integer) -> integer * integer;

		System.out.println(times2.apply(4));
		System.out.println(squared.apply(4));

		System.out.println("--------------------------------------------");

		System.out.println(times2.andThen(squared).apply(4));   // (4 * 2)^2
		System.out.println(times2.compose(squared).apply(4));   // reading order vice versa to "andThen()" so -> (4^2) * 2

		System.out.println("--------------------------------------------");



		// --- SECOND EXAMPLE ---
		Function<String, String> upperCase = String::toUpperCase;
		Function<String, String> trim = String::trim;

		String word = " hi ";

		System.out.println(upperCase.andThen(trim).apply(word));
		System.out.println(upperCase.compose(trim).apply(word));


		// --- WHAT'S THE DIFFERENCE ? ---

		/**
		 * andThen()

		  default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
		       Objects.requireNonNull(after);
		       return (T t) -> after.apply(apply(t));
		  }

 		 */


		/**
		 * compose()

		  default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
		       Objects.requireNonNull(before);
		       return (V v) -> apply(before.apply(v));
		  }

		 */

	}
}
