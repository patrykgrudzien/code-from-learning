package com.jurik99;

import java.util.function.BiConsumer;

public class BiConsumerExample2 {

	public static void main(final String[] args) {

		BiConsumer<Integer, Integer> addition = (integer1, integer2) -> System.out.println(integer1 + integer2);
		BiConsumer<Integer, Integer> subtraction = (integer1, integer2) -> System.out.println(integer1 - integer2);

		// --- using "andThen()" ---
		addition.andThen(subtraction).accept(10, 6);    // output: 16, 4
	}
}
