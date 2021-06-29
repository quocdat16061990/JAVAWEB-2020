package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.custom.ITransactionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>, ITransactionRepositoryCustom {
}
