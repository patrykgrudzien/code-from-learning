package com.jurik99.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.jurik99.Constants.Schemas.CONFIGURATION_WITH_ANNOTATIONS;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student", schema = CONFIGURATION_WITH_ANNOTATIONS)
public class Student {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	public Student(final String firstName, final String lastName, final String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
