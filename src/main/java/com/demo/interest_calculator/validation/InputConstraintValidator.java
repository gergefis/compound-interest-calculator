package com.demo.interest_calculator.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class InputConstraintValidator implements ConstraintValidator<ValidInput, String> {

	private String prefix;

	@Override
	public void initialize(ValidInput validInput) {
		prefix = validInput.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		boolean	result;

		if(theCode != null)
			result = theCode.startsWith(prefix);
		else
			result = true;
		return result;
	}
}
