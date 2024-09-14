package com.santojes.ecommerce.customer.model;

public record CustomerResponse(
        String id,
        String firstName,
        String lastname,
        String email,
        Address address
) {}
