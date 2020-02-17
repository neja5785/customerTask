package com.enorkus.academy.controller;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    private CustomerService customerService = new CustomerService();
    public MainController() {
    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {
       return customerService.fetchCustomers();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }
    @RequestMapping("/car")
    public List<Car> getStrings(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi",100,"red", Arrays.asList("bumver","bumver"),true));

        return  cars;
    }
    public class Car{
        private String model;
        private int speed;
        private String color;
        private List<String> modifications;
        public Boolean isFast;

        public Car(String model, int speed, String color, List<String> modifications, Boolean isFast) {
            this.model = model;
            this.speed = speed;
            this.color = color;
            this.modifications = modifications;
            this.isFast = isFast;
        }

        public String getModel() {
            return model;
        }

        public int getSpeed() {
            return speed;
        }

        public String getColor() {
            return color;
        }

        public List<String> getModifications() {
            return modifications;
        }

        public Boolean getFast() {
            return isFast;
        }
    }
}