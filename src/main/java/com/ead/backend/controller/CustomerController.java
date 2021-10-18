package com.ead.backend.controller;

import com.ead.backend.model.Customer;
import com.ead.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/addcustomer")
    public String addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Added new customer!";
    }

    @PostMapping("/updatecustomer")
    public String updateCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Updated customer!";
    }

    @GetMapping("/customerlist")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/deletecustomer")
    public String deleteCustomer(@RequestBody Customer customer) {
        customerRepository.deleteById(customer.getId());
        return "Deleted customer!";
    }

}
