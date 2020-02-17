package com.enorkus.academy.exception;

import com.enorkus.academy.entity.CountryCode;

public class CountryCodeValidator extends Validator<String> {
    @Override
    public void validate(String countryCode, String message) {
        if (!(CountryCode.EE.toString().equals(countryCode) ||
                CountryCode.LT.toString().equals(countryCode) ||
                (CountryCode.LV.toString().equals(countryCode) ||
                        CountryCode.SE.toString().equals(countryCode)))) {
            throw new ValidationException(message);
        }
    }
}
