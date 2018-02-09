package com.jurik99.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(final CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(final String theCode, final ConstraintValidatorContext context) {

		// --- String theCode - HTML Form Data entered by the user ---
		// --- ConstraintValidatorContext context - you can place additional error messages here ---

		/**
		  final boolean result;

		  if (theCode != null) {
		    result = theCode.startsWith(coursePrefix);
		  }
		  else {
		    result = true;
		  }

		  return result;
		*/

		// --- SIMPLIFIED SYNTAX ---
		return theCode == null || theCode.startsWith(coursePrefix);
	}
}
