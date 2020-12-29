package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="customerOfAdmin")

public class CustomerAPI {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/api/customer")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO newCustomer){

        return newCustomer;
    }

}
