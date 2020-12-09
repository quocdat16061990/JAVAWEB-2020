package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRespositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomRespositoryImpl implements CustomerRespositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<CustomerEntity> findByFullNameAndPhoneAndEmail(String fullName, String phone, String email) {
        String sql1="select * from customer";
        Query query=entityManager.createNativeQuery(sql1, CustomerEntity.class);
        return query.getResultList();


    }

    @Override
    public void saveCustomer(CustomerEntity customerEntity) {
        entityManager.persist(customerEntity);
    }
}
