package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.ICustomerRespository;
import com.laptrinhjavaweb.repository.custom.CustomerRespositoryCustom;
import com.laptrinhjavaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerConverter customerConverter;

    @Autowired
    ICustomerRespository iCustomerRespository;
    @Autowired
    CustomerRespositoryCustom customerRespositoryCustom;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<CustomerDTO> findByNameAndPhoneAndEmail(CustomerDTO model) {
        List<CustomerDTO> results=new ArrayList<>();
        List<CustomerEntity> entities=customerRespositoryCustom.findByFullNameAndPhoneAndEmail(model);
        for(CustomerEntity item : entities){
            CustomerDTO customerDTO=customerConverter.convertToDto(item);
            results.add(customerDTO);
        }
        return results;
    }

    @Override
    public Long saveNewCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void saveByPersists(CustomerDTO customerDTO) {
        customerRespositoryCustom.saveCustomer(customerDTO);
    }
}
