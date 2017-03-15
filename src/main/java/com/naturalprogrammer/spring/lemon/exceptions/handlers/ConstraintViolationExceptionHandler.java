package com.naturalprogrammer.spring.lemon.exceptions.handlers;

import java.util.Collection;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.naturalprogrammer.spring.lemon.util.LemonUtil;
import com.naturalprogrammer.spring.lemon.validation.FieldError;

@Component
public class ConstraintViolationExceptionHandler extends AbstractExceptionHandler<ConstraintViolationException> {

	public ConstraintViolationExceptionHandler() {
		
		super(ConstraintViolationException.class.getSimpleName());
	}
	
	@Override
	protected HttpStatus getStatus(ConstraintViolationException ex) {
		return HttpStatus.UNPROCESSABLE_ENTITY;
	}
	
	@Override
	protected Collection<FieldError> getErrors(ConstraintViolationException ex) {
		return FieldError.getErrors(ex.getConstraintViolations());
	}
	
	@Override
	protected String getMessage(ConstraintViolationException ex) {
		return LemonUtil.getMessage("com.naturalprogrammer.spring.validationError");
	}
}