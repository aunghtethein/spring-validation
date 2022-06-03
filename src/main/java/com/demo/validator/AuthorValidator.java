package com.demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.ds.Author;

public class AuthorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Author.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "required.Name", "Name is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"genre", "required.Genre", "Genre is required!");
		
	}

}
