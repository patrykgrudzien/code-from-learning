package com.jurik99.part_8_Builder;

public class Main {

	@SuppressWarnings("Duplicates")
	public static void main(final String[] args) {

		final Person person = Person.builder()
		                            .firstName("Patryk")
		                            .age(26)
		                            .build();
		System.out.println(person);
	}
}
