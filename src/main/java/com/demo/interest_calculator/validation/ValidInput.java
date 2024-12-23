package com.demo.interest_calculator.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = InputConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInput {

	//	define default course code
	public String value() default "Credit";

	//	define default error message
	public String message() default "must start with Credit";

	//	define default groups
	public Class<?>[] groups() default {};

	//	define default payloads
	public Class<? extends Payload>[] payload() default {};
}