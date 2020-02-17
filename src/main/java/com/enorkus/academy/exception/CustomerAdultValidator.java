package com.enorkus.academy.exception;

public class CustomerAdultValidator  extends Validator <Integer> {
    @Override
    public void validate(Integer age, String message) {
        if (age == 0) {
            throw new ValidationException(message);
        } else if (age < 18) {
            throw new ValidationException(message);
        }
    }
}
