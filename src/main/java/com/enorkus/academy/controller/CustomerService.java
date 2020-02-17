package com.enorkus.academy.controller;


import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.CustomerValidator;
import com.enorkus.academy.exception.ValidationException;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CustomerService {
    CustomerRepository customerRepository = new MemoryCustomerRepository();
    CustomerValidator customerValidator = new CustomerValidator();
    public CustomerService() {
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {

        customerValidator.validateCustomer(customer);
        String formattedFirstName = makeFirstLetterUpper(customer.getFirstName());
        String formattedLastName = makeFirstLetterUpper(customer.getLastName());
        String formattedNumber = addMinus(customer.getPersonalNumber());

        Customer formattedCustomer = new Customer.CustomerBuilder(formattedFirstName, formattedLastName, formattedNumber)
                .middleName(customer.getMiddleName())
                .age(customer.getAge())
                .city(customer.getCity())
                .gender(customer.getGender())
                .employer(customer.getEmployer())
                .maritalStatus(customer.getMaritalStatus())
                .monthlyIncome(customer.getMonthlyIncome())
                .countryCode(customer.getCountryCode()).build();


        customerRepository.insert(formattedCustomer);
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private String makeFirstLetterUpper(String name) {
        if (name != null && !name.isEmpty()) {
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
        return null;
    }

    private String addMinus(String number) {
        if (number != null && !number.isEmpty() && number.length() > 3)
            return number.substring(0, 4) + "-" + number.substring(4);
        else return number;
    }
}
