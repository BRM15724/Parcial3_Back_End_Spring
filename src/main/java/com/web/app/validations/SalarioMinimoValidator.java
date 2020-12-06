package com.web.app.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//ESTA CLASE AYUDA A RESOLVER PROBLEMATICA DE PUNTO 2 DEL PARCIAL 3
public class SalarioMinimoValidator implements ConstraintValidator<SalarioMinimo, Float> {

	@Override
	public boolean isValid(Float value, ConstraintValidatorContext context) {
		if(value == 0) {
			return false;
		}
		return value >= 4000;
	}
}
