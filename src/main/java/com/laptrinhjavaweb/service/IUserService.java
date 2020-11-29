package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO findOneByUserNameAndStatus(String name, int status);

    void addCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> searchCustomer(CustomerDTO customerDTO);
}
