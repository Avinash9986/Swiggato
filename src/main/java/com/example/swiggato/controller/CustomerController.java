package com.example.swiggato.controller;

import com.example.swiggato.dto.request.CustomerRequest;
import com.example.swiggato.dto.response.CustomerResponse;
import com.example.swiggato.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService ;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest) ;
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED) ;
    }

    @GetMapping("/find/mobile/{mobileNo}")
    public ResponseEntity getCustomerByMobile(@PathVariable("mobileNo") String mobileNo){
        try {
            CustomerResponse customerResponse = customerService.getCustomerByMobile(mobileNo) ;
            return new ResponseEntity<>(customerResponse,HttpStatus.FOUND) ;
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST) ;
        }
    }
}
