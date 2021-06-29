package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.custom.ITransactionRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements ITransactionRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<TransactionEntity> findAllByCustomerId(Long customerId) {
        String sql = "SELECT * FROM transaction WHERE customers_id = " + customerId;
        Query query = entityManager.createNativeQuery(sql, TransactionEntity.class);
        return query.getResultList();
    }
}
