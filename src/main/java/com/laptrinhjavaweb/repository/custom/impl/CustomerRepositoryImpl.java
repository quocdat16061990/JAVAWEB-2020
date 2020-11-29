package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<CustomerEntity> searchCustomer(CustomerDTO model) {
        String sql="select * from building";
        Query query =entityManager.createNativeQuery(sql,CustomerEntity.class);
        return query.getResultList();
    }
}
