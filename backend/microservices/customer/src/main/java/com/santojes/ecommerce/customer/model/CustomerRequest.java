package com.santojes.ecommerce.customer.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
         String id,
         @NotNull(message = "Customer first name is required")
         String firstName,
         @NotNull(message = "Customer llast name is required")
         String lastname,
         @NotNull(message = "Customer email is required")
         @Email(message = "Customer email is not valid email address")
         String email,
         Address address
) {}
