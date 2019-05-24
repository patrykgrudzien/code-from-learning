package com.jurik99;

public class Question1Main {

	public static void main(final String[] args) {

		final String word = "Selenium";

		// 1. Approach
		final int length = word.length();

		final StringBuilder reversedWord = new StringBuilder();
		for (int i = length - 1; i >= 0; i--) {
			reversedWord.append(word.charAt(i));
		}
		System.out.println(reversedWord.toString());

		String reversed = "";   // in String class there is no reverse() method as String is immutable
		for (int i = length - 1; i >= 0; i--) {
			reversed += word.charAt(i);
		}
		System.out.println(reversed);

		// 2. Approach
		final StringBuffer stringBuffer = new StringBuffer(word);   // StringBuffer is mutable (I could also use StringBuilder)
		System.out.println(stringBuffer.reverse());
	}
}
