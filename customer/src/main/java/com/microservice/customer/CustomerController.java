package com.microservice.customer;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}", customerRegistrationRequest);
       customerService.registerCustomer(customerRegistrationRequest);
    }
    @GetMapping("/{email}")
    public ResponseEntity<List<Customer>> get(@PathVariable String email){
        List<Customer> customers = customerService.returbyemail(email);
        return ResponseEntity.ok(customers);
    }


    @GetMapping()
    public ResponseEntity<List<Customer>> getEMAIL(){
        List<Customer> customers = customerService.returnall();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("id/{id}")
    public Customer customerId(@PathVariable String   id) {
        return customerService.returid(id).get();
    }

}
