package com.jurik99.part_9_NonNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

	private String firstName;
	private String surName;
	private String ssn;
	private int age;
}
