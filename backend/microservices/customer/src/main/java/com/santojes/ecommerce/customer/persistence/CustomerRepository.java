package com.santojes.ecommerce.customer.persistence;

import com.santojes.ecommerce.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {}
