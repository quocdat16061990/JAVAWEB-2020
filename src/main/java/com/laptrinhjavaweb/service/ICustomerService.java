package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findByNameAndPhoneAndEmail(CustomerDTO model);
    Object addCustomerJPA(CustomerDTO customerDTO);
}