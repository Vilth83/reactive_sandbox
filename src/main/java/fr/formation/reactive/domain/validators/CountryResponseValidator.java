package fr.formation.reactive.domain.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.formation.reactive.domain.dtos.CountryResponseDto;

public class CountryResponseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
	return CountryResponseDto.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
	CountryResponseDto response = (CountryResponseDto) obj;
	if (checkInputString(response.getAlpha2Code())) {
	    errors.rejectValue("isoCode", "isoCode.empty");
	}
    }

    private boolean checkInputString(String input) {
	return (input == null || input.trim().length() != 2);
    }
}