package com.jurik99;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerAndThenExample {

	public static void main(final String[] args) {

		Consumer<Integer> consumer = integer -> System.out.print(" " + integer);
		Consumer<Integer> consumerAndThen = consumer.andThen(integer -> System.out.print("(printed " + integer + ")"));

		List<Integer> integerList = Arrays.asList(1, 10, 200, 101, -10, 0);

		printList(integerList, consumerAndThen);
	}

	private static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {

		for (Integer integer : listOfIntegers) {
			consumer.accept(integer);
		}
	}
}
