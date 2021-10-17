package com.ead.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/add")
    public String add() {
        Customer customer = new Customer();
        customer.setName("Upeksha");
        customer.setAge(23);
        customerRepository.save(customer);
        return "Test";
    }
}
