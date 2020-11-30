package com.web.app.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SalarioMinimoValidator implements ConstraintValidator<SalarioMinimo, Float> {

	@Override
	public boolean isValid(Float value, ConstraintValidatorContext context) {
		if(value == 0) {
			return false;
		}
		return value >= 4000;
	}
}
