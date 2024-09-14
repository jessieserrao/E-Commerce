package com.santojes.ecommerce.customer.controller;

import com.santojes.ecommerce.customer.exception.CustomerNotFoundException;
import com.santojes.ecommerce.customer.model.CustomerRequest;
import com.santojes.ecommerce.customer.model.CustomerResponse;
import com.santojes.ecommerce.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.santojes.ecommerce.customer.CustomerConstants.CUSTOMER_API_V1;

@RestController
@RequestMapping(CUSTOMER_API_V1 )
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer( @RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateCustomer( @RequestBody @Valid CustomerRequest customerRequest)
            throws CustomerNotFoundException {
        customerService.updateCustomer(customerRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customer/{customer-id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok().body(customerService.getCustomerById(customerId));
    }

    @GetMapping("/exist/{customer-id}")
    public ResponseEntity<Boolean> existById(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok().body(customerService.existById(customerId));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok().body(customerService.findAllCustomers());
    }

    @DeleteMapping("/delete")
    public  ResponseEntity<Void> deleteCustomer( @PathVariable String customerId){
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.ok().build();

    }

}
