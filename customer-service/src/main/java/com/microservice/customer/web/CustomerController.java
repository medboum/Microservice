package com.microservice.customer.web;
import com.microservice.customer.entities.Customer;
import com.microservice.customer.repo.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {
    private CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public  List<Customer>  customerList(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer customerId(@PathVariable Long   id) {
        return customerRepository.findById(id).get();
    }

}
