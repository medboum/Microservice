package com.microservice.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.save(customer);
    }

    public List<Customer> returbyemail (String email){
        return customerRepository.findByEmail(email);
    }
    public List<Customer> returnall (){
        return customerRepository.findAll();
    }
    public Optional<Customer> returid (String id ){
        return customerRepository.findById(id);
    }


}
