package com.web.app.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = SalarioMinimoValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface SalarioMinimo {

	String message() default "*El trabajador debe tener un salario superior a 4000.0";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
