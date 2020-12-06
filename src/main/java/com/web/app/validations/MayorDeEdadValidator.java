package com.web.app.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//ESTA CLASE AYUDA A RESOLVER PROBLEMATICA DE PUNTO 2 DEL PARCIAL 3
public class MayorDeEdadValidator implements ConstraintValidator<MayorDeEdad, Integer> {
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value == null) {
			value=0;
		}
		return value >= 18;
	}

}
