package com.microservice.customer;

import com.microservice.customer.entities.Customer;
import com.microservice.customer.records.CustomerRegistrationRequest;
import com.microservice.customer.repo.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public  class CustomerServiceTest {
   @Mock
   private CustomerRepository customerRepository;


    @Test
    void registerCustomer() {
        // Arrange
    }
}