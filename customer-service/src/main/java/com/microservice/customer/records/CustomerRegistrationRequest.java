package com.microservice.customer.records;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}

