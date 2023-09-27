package com.example.swiggato.transformer;

import com.example.swiggato.dto.request.CustomerRequest;
import com.example.swiggato.dto.response.CartResponse;
import com.example.swiggato.dto.response.CustomerResponse;
import com.example.swiggato.model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestToCusotmer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .gender(customerRequest.getGender())
                .mobileNo(customerRequest.getMobileNo())
                .build();
    }
    public static CustomerResponse CustomerToCustomerResponse(Customer customer){
        CartResponse cartResponse = CartTransformer.CartToCartResponse(customer.getCart()) ;
        return CustomerResponse.builder()
                .address(customer.getAddress())
                .mobileNo(customer.getMobileNo())
                .name(customer.getName())
                .cart(cartResponse)
                .build();
    }
}
