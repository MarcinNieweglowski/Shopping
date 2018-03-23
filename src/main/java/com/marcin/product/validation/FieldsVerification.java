package com.marcin.product.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy=FieldsVerificationValidator.class)
public @interface FieldsVerification {

	// message attribute
	String message() default "* Current value must be equal or lower thant the quantity needed. ";
	String quantityNeeded();
	String status();
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
