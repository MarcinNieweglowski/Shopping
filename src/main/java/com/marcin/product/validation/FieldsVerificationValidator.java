package com.marcin.product.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldsVerificationValidator implements ConstraintValidator<FieldsVerification, Object> {
	
	private String quantityNeeded;
	private String status;
	
	@Override
	public void initialize(FieldsVerification constraintAnnotation) {
		quantityNeeded = constraintAnnotation.quantityNeeded();
		status = constraintAnnotation.status();
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Object quantityNeededValue = new BeanWrapperImpl(value).getPropertyValue(quantityNeeded);
		Object statusValue = new BeanWrapperImpl(value).getPropertyValue(status);	

		if (quantityNeededValue instanceof Integer && statusValue instanceof Integer) {	// digit
			int intQuantityNeeded = (Integer) quantityNeededValue;
			int intStatusValue = (Integer) statusValue;

			if (!(intQuantityNeeded > 0)) { // quantityNeeded> 0
				return false;
			}
			if(intStatusValue <0 || intStatusValue > intQuantityNeeded) {	//0<=status<=quantityNeeded
				return false;
			}
			return true;
		} else return false;
	}
}
