package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findByNameAndPhoneAndEmail(CustomerDTO model);
    Long saveNewCustomer(CustomerDTO customerDTO);
    void saveByPersists(CustomerDTO customerDTO);
}
