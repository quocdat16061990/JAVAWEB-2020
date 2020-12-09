package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.ICustomerRespository;
import com.laptrinhjavaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomerService implements ICustomerService {

    @Autowired
    CustomerConverter customerConverter;

    @Autowired
    ICustomerRespository iCustomerRespository;

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<CustomerDTO> findByNameAndPhoneAndEmail(CustomerDTO customerDTO) {
        return iCustomerRespository.findByFullNameAndEmailAndPhone(customerDTO.getFullname(),customerDTO.getEmail(),customerDTO.getPhone());
    }

    @Override
    public Long saveNewCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void saveByPersists(CustomerDTO customerDTO) {
        CustomerEntity customerEntity=customerConverter.convertToEntity(customerDTO);
        entityManager.getTransaction().begin();
        entityManager.persist(customerDTO);
        entityManager.getTransaction().commit();
    }
}
