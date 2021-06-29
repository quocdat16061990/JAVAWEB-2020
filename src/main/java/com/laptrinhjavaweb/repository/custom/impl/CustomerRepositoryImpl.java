package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.ICustomerRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;


@Repository
public class CustomerRepositoryImpl implements ICustomerRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> findCustomers(CustomerDTO model) {
        String sql = buildCustomerSearch(model);
        Query query = entityManager.createNativeQuery(sql, CustomerEntity.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Object saveCustomer(CustomerEntity customerEntity) {
        entityManager.persist(customerEntity);
        return null;
    }

    private String buildCustomerSearch(CustomerDTO customerDTO) {
        StringBuilder sql = new StringBuilder("select * from customer cus");

        if (customerDTO.getStaffId() != -1) {
            sql.append(" left join assignmentcustomer ac on ac.customerid = cus.id where 1 = 1 " +
                    "and ac.staffid = " + customerDTO.getStaffId());
        } else {
            sql.append(" where 1 = 1");
        }
        try {
            Field[] fields = CustomerDTO.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(customerDTO) == "") {
                    field.set(customerDTO, null);
                }
                if (!field.getName().equals("staffId")) {
                    if (field.get(customerDTO) != null) {
                        if (field.getType().getName().equals("java.lang.String")) {
                            sql.append(" and cus." + field.getName() + " like '%" + field.get(customerDTO) + "%'");
                        } else if (field.getType().getName().equals("java.lang.Integer")) {
                            sql.append(" and cus." + field.getName() + " = " + field.get(customerDTO));
                        }
                    }
                }
            }
            sql.append(" group by cus.id");
            return sql.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
