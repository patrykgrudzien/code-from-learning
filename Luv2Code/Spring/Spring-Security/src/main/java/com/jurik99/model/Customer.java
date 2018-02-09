package com.jurik99.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.jurik99.validation.CourseCode;

@Getter
@Setter
public class Customer {

	private String firstName;

	@NotNull(message = "cannot be empty")
	@Size(min = 1, message = "is required!")
	private String lastName;

	@NotNull(message = "is required")
	@Min(value = 0, message = "must be greater than or equal to 0")
	@Max(value = 10, message = "must be less than or equal to 10")
	private Integer freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;

	@CourseCode(value = "TOPS", message = "must start with TOPS")
	private String courseCode;
}
