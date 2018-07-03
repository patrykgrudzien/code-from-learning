package com.jurik99.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)   // it means how long that annotation will be stored/used -> RETAIN (utrzymywac)
public @interface CourseCode {

	// --- define default course code ---
	String value() default "LUV";

	// --- define default error message ---
	String message() default "must start with LUV";

	// --- define default groups (to group validation constraints together) ---
	Class<?>[] groups() default {};

	/*
	 * define default payloads (to give additional information about validation error)
	 * Payloads: provide custom details about validation failure (severity level, error code etc.)
	 */
	Class<? extends Payload>[] payload() default {};
}
