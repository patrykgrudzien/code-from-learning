package com.jurik99;

import org.apache.commons.lang3.text.StrBuilder;

public class Question3Main {

	public static void main(final String[] args) {

		// 1. Approach
		int number1 = 12345;   // 54321
		int reversed = 0;

		while (number1 != 0) {
			reversed = reversed * 10 + number1 % 10;
			number1 = number1 / 10;
		}
		System.out.println("reversed = " + reversed);

		// 2. Approach
		int number2 = 123456789;
		System.out.println(new StrBuilder(String.valueOf(number2)).reverse().toString());
	}
}
