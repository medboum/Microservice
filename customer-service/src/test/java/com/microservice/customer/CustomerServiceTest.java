package com.microservice.customer;

import com.microservice.customer.entities.Customer;
import com.microservice.customer.records.CustomerRegistrationRequest;
import com.microservice.customer.repo.CustomerRepository;
import com.microservice.customer.service.CustomerService;
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

   @InjectMocks
   private CustomerService customerService;
    
    @Test
    void registerCustomer() {
        // Arrange

     Customer cust=Customer.builder()
             .firstName("John")
             .lastName("Doe")
             .email("john@example.com").build();

     CustomerRegistrationRequest request = new CustomerRegistrationRequest("John", "Doe", "john@example.com");

        // Mock the save method of the customerRepository to return the expectedCustomer
        when(customerRepository.save(any(Customer.class))).thenReturn(cust);

        // Act
        customerService.registerCustomer(request);

        // Assert
        // Verify that the save method of customerRepository was called with the expectedCustomer
        verify(customerRepository, times(1)).save(cust);
    }
}