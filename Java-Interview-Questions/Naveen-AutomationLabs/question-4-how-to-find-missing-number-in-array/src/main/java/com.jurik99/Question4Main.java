package com.jurik99;

import java.util.Arrays;

public class Question4Main {

	public static void main(final String[] args) {

		final int[] array = {1, 2, 4, 5, 6, 7, 8, 9};

		// 1+2+4+5 = 12
		// 1+2+3+4+5 = 15
		// 15-12 = 3

		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		System.out.println("sum = " + sum);

		int sum1 = 0;
		for (int j = Arrays.stream(array).min().getAsInt(); j <= Arrays.stream(array).max().getAsInt(); j++) {
			sum1 += j;
		}
		System.out.println("sum1 = " + sum1);

		System.out.println("Missing number is = " + (sum1 - sum));
	}
}
