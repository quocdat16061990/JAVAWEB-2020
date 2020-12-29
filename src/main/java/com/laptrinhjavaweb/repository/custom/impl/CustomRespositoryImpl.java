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
        StringBuilder sql=new StringBuilder();
        sql.append("select * from customer as cus");
        if(model.getStaffId()!=null){
            sql.append("left join assigmentcustomer as ac on cus.id = ac.customerid");
        }

        if(model.getFullName()!=null && model.getFullName()!=""){
            sql.append("cus.fullname like '%" +model.getFullName()+"%'");
        }
        if(model.getPhone() != null && model.getPhone()!=""){
            sql.append(" and cus.phone like '%" + model.getPhone() + "%'");
        }
        if(model.getEmail() != null && model.getEmail()!=""){
            sql.append(" and cus.email like '%" + model.getEmail() + "%'");
        }

        Query query=entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();


    }

    @Override
    public Object addCustomerJPA(CustomerEntity customerEntity) {
        entityManager.persist(customerEntity);
        return null;
    }




}
