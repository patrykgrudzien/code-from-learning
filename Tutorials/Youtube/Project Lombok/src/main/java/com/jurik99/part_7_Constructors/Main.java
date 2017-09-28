package com.jurik99.part_7_Constructors;

public class Main {

	@SuppressWarnings("Duplicates")
	public static void main(final String[] args) {

		final Person person1 = new Person();
		final Person person2 = new Person("Patryk", "Grudzien", "12345", 26);

		System.out.println(person1);
		System.out.println(person2);
	}
}
