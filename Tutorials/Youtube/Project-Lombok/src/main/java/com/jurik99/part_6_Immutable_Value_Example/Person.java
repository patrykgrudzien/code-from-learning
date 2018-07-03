package com.jurik99.part_6_Immutable_Value_Example;

import lombok.Value;

/*
 * @Value - makes all field PRIVATE FINAL by default --> NO setters --> Constructor is created AUTOMATICALLY
 */
@Value
public class Person {

	private String firstName;
	private String surName;
	private String ssn;
	private int age;
}
