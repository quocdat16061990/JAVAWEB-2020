package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

import java.util.List;

public interface CustomerRespositoryCustom {
    List<CustomerEntity> findByFullNameAndPhoneAndEmail(String fullName,String phone,String email);
    void saveCustomer(CustomerEntity customerEntity);
}
