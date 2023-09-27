package com.example.swiggato.service;

import com.example.swiggato.dto.request.CustomerRequest;
import com.example.swiggato.dto.response.CustomerResponse;
import com.example.swiggato.exception.CustomerNotFoundException;
import com.example.swiggato.model.Cart;
import com.example.swiggato.model.Customer;
import com.example.swiggato.repository.CustomerRepository;
import com.example.swiggato.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository ;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.CustomerRequestToCusotmer(customerRequest) ;

        Cart cart= Cart.builder()
                .cartotal(0)
                .customer(customer)
                .build() ;

        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer) ;

        return CustomerTransformer.CustomerToCustomerResponse(savedCustomer) ;
    }

    public CustomerResponse getCustomerByMobile(String mobileNo) {
        Customer customer = customerRepository.findByMobileNo(mobileNo) ;
        if (customer == null){
            throw new CustomerNotFoundException("Invalid response") ;
        }
        return CustomerTransformer.CustomerToCustomerResponse(customer) ;
    }
}
