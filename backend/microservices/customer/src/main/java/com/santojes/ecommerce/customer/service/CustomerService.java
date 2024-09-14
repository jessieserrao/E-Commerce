package com.santojes.ecommerce.customer.service;
import com.santojes.ecommerce.customer.exception.CustomerNotFoundException;
import com.santojes.ecommerce.customer.mapper.CustomerMapper;
import com.santojes.ecommerce.customer.model.Customer;
import com.santojes.ecommerce.customer.model.CustomerRequest;
import com.santojes.ecommerce.customer.model.CustomerResponse;
import com.santojes.ecommerce.customer.persistence.CustomerRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerService {

    protected CustomerRepository customerRepository;
    protected CustomerMapper customerMapper;
    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.createCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest customerRequest) throws CustomerNotFoundException {
        var customer = customerRepository.findById(customerRequest.id())
                .orElseThrow( () -> new CustomerNotFoundException(
                        String.format("Can not update customer:: The customer could be not found by provided ID:: %s", customerRequest.id() ))
                );
        mergeCustomer(customer, customerRequest);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest customerRequest) {
        if(StringUtils.isNotBlank(customerRequest.firstName())){
            customer.setFirstName(customerRequest.firstName());
        }
        if(StringUtils.isNotBlank(customerRequest.lastname())){
            customer.setLastname(customerRequest.lastname());
        }
        if(StringUtils.isNotBlank(customerRequest.email())){
            customer.setEmail(customerRequest.email());
        }
        if(customerRequest.address() != null){
            customer.setAddress(customerRequest.address());
        }

    }

    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public void deleteCustomerById(String customerId) {
        if(StringUtils.isNotBlank(customerId)) {
            customerRepository.deleteById(customerId);
        }
    }

    public CustomerResponse getCustomerById(String customerId) {
            //TODO: fix exception
            var customer = customerRepository.findById(customerId).orElseThrow( () -> new CustomerNotFoundException(""));
            return customerMapper.fromCustomer(customer);
    }

    public Boolean existById(String customerId) {
        return customerRepository.existsById(customerId);
    }
}
