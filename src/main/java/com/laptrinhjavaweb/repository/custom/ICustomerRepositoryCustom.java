package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

import java.util.List;

public interface ICustomerRepositoryCustom {
    List<CustomerEntity> findCustomers(CustomerDTO model);
    Object saveCustomer(CustomerEntity customerEntity);
}
