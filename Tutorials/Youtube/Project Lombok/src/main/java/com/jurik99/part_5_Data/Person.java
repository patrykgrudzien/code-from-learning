package com.jurik99.part_5_Data;

import lombok.Data;

/*
 * We can remove @Getter, @Setter, @EqualsAndHashCode, @ToString and REPLACE all that annotations with ONE --> @Data
 * In @Data we have:
 * @Getter
 * @Setter
 * @RequiredArgsConstructor (if we have any final variables it will generate args constructor. Setter NOT AVAILABLE)
 * @ToString
 * @EqualsAndHashCode
 * @see lombok.Value
 */
@Data
public class Person {

	private final String firstName;
	private String surName;
	private String ssn;
	private int age;
}
