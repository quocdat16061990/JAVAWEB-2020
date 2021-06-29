package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.request.AssignmentCustomerRequestDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAll();
    List<CustomerDTO> findCustomers(CustomerDTO model);
    CustomerDTO save(CustomerDTO customerDTO);
    void delete(Long[] ids);
    List<StaffResponseDTO> loadStaff(Long id);
    CustomerDTO findOne(Long id);
    CustomerDTO update(CustomerDTO customerDTO);
    CustomerDTO assignmentCustomer(AssignmentCustomerRequestDTO requestDTO);
}
