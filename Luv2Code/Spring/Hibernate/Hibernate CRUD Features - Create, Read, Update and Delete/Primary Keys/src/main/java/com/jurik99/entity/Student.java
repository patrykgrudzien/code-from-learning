package com.jurik99.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.jurik99.Constants.Schemas.PRIMARY_KEYS;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "STUDENTS", schema = PRIMARY_KEYS)
public class Student {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)     -> It is DEFAULT strategy
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
