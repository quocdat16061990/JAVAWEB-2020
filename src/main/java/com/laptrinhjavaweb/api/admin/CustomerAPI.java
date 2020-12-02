package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "customerAPIofAdmin")
public class CustomerAPI {

    @Autowired
    private UserService userService;

    @PostMapping("/api/customer")
    public CustomerDTO createBuilding(@RequestBody CustomerDTO newCustomer){
        userService.addCustomer(newCustomer);
        return newCustomer;
    }
    }

