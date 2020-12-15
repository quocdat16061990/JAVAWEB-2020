package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRespositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomRespositoryImpl implements CustomerRespositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public List<CustomerEntity> findByFullNameAndPhoneAndEmail(CustomerDTO model) {
        String sql="select * from customer";
        Query query=entityManager.createNativeQuery(sql, CustomerEntity.class);
        return query.getResultList();


    }



    @Override
    @Transactional
    public void saveCustomer(CustomerDTO customerDTO) {

        CustomerEntity customerEntity = customerConverter.convertToEntity(customerDTO);

        entityManager.persist(customerEntity);

    }
}
