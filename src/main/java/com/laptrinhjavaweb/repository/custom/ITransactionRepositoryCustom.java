package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.TransactionEntity;

import java.util.List;

public interface ITransactionRepositoryCustom {
    List<TransactionEntity> findAllByCustomerId(Long customerId);
}
