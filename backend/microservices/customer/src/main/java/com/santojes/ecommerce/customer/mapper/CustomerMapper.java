package com.santojes.ecommerce.customer.mapper;

import com.santojes.ecommerce.customer.model.Customer;
import com.santojes.ecommerce.customer.model.CustomerRequest;
import com.santojes.ecommerce.customer.model.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer createCustomer(CustomerRequest customerRequest) {
        if (customerRequest == null) {
            return null;
        }
        return Customer.builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstName())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .address(customerRequest.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
