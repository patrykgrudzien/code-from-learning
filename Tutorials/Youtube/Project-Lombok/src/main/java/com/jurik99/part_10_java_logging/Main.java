package com.jurik99.part_10_java_logging;

import lombok.NonNull;
import lombok.extern.log4j.Log4j;

@Log4j
public class Main {

	// --- OLD approach ---
	// private static final Logger logger = Logger.getLogger(Main.class);

	@SuppressWarnings("Duplicates")
	public static void main(final String[] args) {

		final Person person = Person.builder()
		                            .firstName("Patryk")
		                            .age(26)
		                            .build();
		test(person);
	}

	private static void test(@NonNull final Person person) {
		log.info("no way person is null. " + person);
	}
}
