package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.TransactionConverter;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.TransactionRepository;
import com.laptrinhjavaweb.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionConverter transactionConverter;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionDTO save(TransactionDTO transactionDTO) {
        try {
            TransactionEntity transactionEntity = transactionConverter.convertToEntity(transactionDTO);
            transactionEntity.setCustomers(customerRepository.findOne(transactionDTO.getCustomerId()));
            TransactionDTO result = transactionConverter.convertToDto(transactionRepository.save(transactionEntity));
            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<TransactionDTO> findAllByCustomerId(Long customerId) {
        try {
            List<TransactionEntity> transactionEntities =  transactionRepository.findAllByCustomerId(customerId);
            List<TransactionDTO> result = new ArrayList<>();
            HashMap<String, List<TransactionDTO>> map = new HashMap<>();
            for (TransactionEntity item: transactionEntities){
                TransactionDTO transactionDTO = transactionConverter.convertToDto(item);
                result.add(transactionDTO);
            }
            for(TransactionDTO item1: result){
                    map.put(item1.getCode(), result);
            }

            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}
