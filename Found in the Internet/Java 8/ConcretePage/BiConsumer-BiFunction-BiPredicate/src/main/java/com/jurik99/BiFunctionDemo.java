package com.jurik99;

import java.util.function.BiFunction;

public class BiFunctionDemo {

	public static void main(final String[] args) {

		/**
		 * java.util.function.BiFunction is a functional interface. BiFunction accepts two arguments and returns a value.
		 * While declaring BiFunction we need to tell what type of argument will be passed and what will be return type.
		 * We can apply our business logic with those two values and return the result. BiFunction has function method as
		 * apply(T t, U u) which accepts two argument.
		 */

		BiFunction<Integer, Integer, String> biFunction = (integer, integer2) -> "Result: " + (integer + integer2);

		System.out.println(biFunction.apply(20, 25));
	}
}
