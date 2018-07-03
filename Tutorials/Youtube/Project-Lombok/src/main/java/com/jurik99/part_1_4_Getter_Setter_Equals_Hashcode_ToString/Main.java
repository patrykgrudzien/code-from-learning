package com.jurik99.part_1_4_Getter_Setter_Equals_Hashcode_ToString;

public class Main {

	@SuppressWarnings("Duplicates")
	public static void main(final String[] args) {

		final Person person = new Person();
		person.setFirstName("Patryk");
		person.setSurName("Grudzien");
		person.setAge(26);
		person.setSsn("123456789");

		System.out.println(person);
	}
}
