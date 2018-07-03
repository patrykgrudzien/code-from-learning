package com.jurik99.part_1_4_Getter_Setter_Equals_Hashcode_ToString;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Person {

	private String firstName;
	private String surName;
	private String ssn;
	private int age;
}
