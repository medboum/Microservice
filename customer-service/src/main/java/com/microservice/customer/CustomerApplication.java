package com.microservice.customer;

import com.microservice.customer.entities.Customer;
import com.microservice.customer.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CustomerApplication {
        public static void main(String[] args) {
            SpringApplication.run(CustomerApplication.class, args);
        }

        @Bean
        CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
            return args -> {
                customerRepository.save(Customer.builder().firstName("ahmed").lastName("latifi").email("latifi@gmail.com").build());
            };
        }


}
