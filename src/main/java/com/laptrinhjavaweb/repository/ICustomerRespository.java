package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRespository extends JpaRepository<CustomerEntity,Long> {
    List<CustomerDTO> findByFullNameAndEmailAndPhone(String fullName,String email,String phone);
}
