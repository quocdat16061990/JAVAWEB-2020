package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findByNameAndPhoneAndEmail(CustomerDTO customerDTO);
    Long saveNewCustomer(CustomerDTO customerDTO);
    void saveByPersists(CustomerDTO customerDTO);
}
