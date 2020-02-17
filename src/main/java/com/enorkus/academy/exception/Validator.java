package com.enorkus.academy.exception;

public abstract class Validator<T> {
    public abstract void validate(T attribute,String message);
}
