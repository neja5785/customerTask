package com.enorkus.academy.exception;

public class MandatoryValueValidator extends Validator <String>{
    @Override
    public void validate(String string, String message) {
        if (string.isEmpty()) {
            throw new ValidationException(message);
        }
    }
}
