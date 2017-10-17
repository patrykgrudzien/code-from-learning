package com.jurik99.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Customer {

	private String firstName;

	@NotNull(message = "cannot be empty")
	@Size(min = 1, message = "is required!")
	private String lastName;

	/*
	 * IF WE ANNOTATE THAT FIELD WITH "@NotNull" WE GET AN EXCEPTION MENTIONED BELOW:
	 *
	 * Failed to convert property value of type java.lang.String to required type int for property freePasses;
	 * nested exception is java.lang.NumberFormatException: For input string: ""
	 *
	 * WE HAVE TO CHANGE PRIMITIVE TYPE TO OBJECT "Integer" cause if an input field is empty, Spring will treat value as NULL
	 * what can be validated by @NotNull annotation !!!
	 *
	 * We HAVE to also take care of "String" values as a input for that field cause in that case we'll get also some EXCEPTION !!!
	 * It can be handled by adding "messageSource" BEAN and creating OWW CUSTOM ERROR MESSAGE (look into "messages.properties")
	 */
	@NotNull(message = "is required")
	@Min(value = 0, message = "must be greater than or equal to 0")
	@Max(value = 10, message = "must be less than or equal to 10")
	private Integer freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;
}
