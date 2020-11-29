package com.laptrinhjavaweb.repository.jdbc;

import com.laptrinhjavaweb.dto.CustomerDTO;

import java.util.List;

public interface ICustomerJDBC {
    List<CustomerDTO> searchCustomer(CustomerDTO customerDTO);
    void addCustomer(CustomerDTO customerDTO);
}
