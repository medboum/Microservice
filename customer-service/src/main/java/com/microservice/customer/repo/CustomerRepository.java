package com.microservice.customer.repo;

import com.microservice.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

}