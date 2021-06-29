package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.TransactionDTO;

import java.util.List;

public interface ITransactionService {
    TransactionDTO save(TransactionDTO transactionDTO);
    List<TransactionDTO> findAllByCustomerId(Long customerId);
}
