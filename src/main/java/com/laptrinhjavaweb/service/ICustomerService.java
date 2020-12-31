package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findByNameAndPhoneAndEmail(CustomerDTO model);
    void saveCustomer(CustomerDTO customerDTO);
}