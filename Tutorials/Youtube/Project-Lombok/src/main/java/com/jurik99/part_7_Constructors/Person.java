package com.jurik99.part_7_Constructors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	private String firstName;
	private String surName;
	private String ssn;
	private int age;
}
