package com.enorkus.academy.exception;


import com.enorkus.academy.entity.Customer;

public class CustomerValidator {

    CountryCodeValidator countryCodeValidator = new CountryCodeValidator();
    CustomerAdultValidator customerAdultValidator = new CustomerAdultValidator();
    MandatoryValueValidator mandatoryValueValidator = new MandatoryValueValidator();
    public void validateCustomer(Customer customer) {
        countryCodeValidator.validate(customer.getCountryCode(), "Wrong country code");
        customerAdultValidator.validate(customer.getAge(), "Invalid age");
        mandatoryValueValidator.validate(customer.getFirstName(),"Wrong first name input");
        mandatoryValueValidator.validate(customer.getLastName(),"Wrong last name input");
        mandatoryValueValidator.validate(customer.getPersonalNumber(),"Wrong personal number");

    }
}
