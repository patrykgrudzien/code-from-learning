package com.jurik99.part_8_Builder;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Person {

	private String firstName;
	private String surName;
	private String ssn;
	private int age;
}
