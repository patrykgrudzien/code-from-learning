package com.jurik99.part_9_NonNull;

import lombok.NonNull;

public class Main {

	@SuppressWarnings("Duplicates")
	public static void main(final String[] args) {

		final Person person = Person.builder()
		                            .firstName("Patryk")
		                            .age(26)
		                            .build();
		System.out.println(person);

		test(person);
		test(null);
	}

	private static void test(@NonNull final Person person) {

		/**

		// --- OLD version of checking null ---
		if (person == null) {
			throw new NullPointerException("person");
		}

		// --- java.util.Objects approach ---
		requireNonNull(person);

		// --- LOMBOK approach ---
		private static void test(@NonNull final Person person)

		 */
		System.out.println("no way person is null. " + person);
	}
}
