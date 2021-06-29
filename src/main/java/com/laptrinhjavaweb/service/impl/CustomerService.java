package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.request.AssignmentCustomerRequestDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public List<CustomerDTO> findAll() {
        try {
            List<CustomerDTO> results = new ArrayList<>();
            List<CustomerEntity> entities = customerRepository.findAll();
            for (CustomerEntity item : entities) {
                CustomerDTO customerDTO = customerConverter.convertToDto(item);
                results.add(customerDTO);
            }
            return results;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<CustomerDTO> findCustomers(CustomerDTO model) {
        try {
            List<CustomerDTO> results = new ArrayList<>();
            List<CustomerEntity> entities = customerRepository.findCustomers(model);
            for (CustomerEntity item : entities) {
                CustomerDTO customerDTO = customerConverter.convertToDto(item);
                results.add(customerDTO);
            }
            return results;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        try {
            CustomerEntity entity = customerConverter.convertToEntity(customerDTO);
            return customerConverter.convertToDto( customerRepository.save(entity));
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        try {
            CustomerEntity entityOld = customerRepository.getOne(customerDTO.getId());
            CustomerEntity entityNew = customerConverter.convertToEntity(customerDTO);
            entityNew.setId(customerDTO.getId());
            entityNew.setCreatedDate(entityOld.getCreatedDate());
            entityNew.setCreatedBy(entityOld.getCreatedBy());
            return customerConverter.convertToDto(customerRepository.save(entityNew));
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public CustomerDTO assignmentCustomer(AssignmentCustomerRequestDTO requestDTO) {
        try{
            CustomerEntity customerEntity = customerRepository.findOne(requestDTO.getCustomerId());
            List<UserEntity> userEntities = new ArrayList<>();
            for (Long id : requestDTO.getStaffs()) {
                UserEntity userEntity = userRepository.findOne(id);
                userEntities.add(userEntity);
            }
            customerEntity.getStaffs().clear();
            customerEntity.setStaffs(userEntities);
            CustomerDTO customerDTO = customerConverter.convertToDto(customerRepository.save(customerEntity));
            return customerDTO;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void delete(Long[] ids) {
        try{
            for(Long item: ids){
                customerRepository.delete(item);
            }
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<StaffResponseDTO> loadStaff(Long id) {
        try{
            List<UserEntity> userEntities = userRepository.findAll();
            CustomerEntity customerEntity = new CustomerEntity();
            if(customerRepository.exists(id)){
                customerEntity = customerRepository.findOne(id);
            }
            List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
            for (UserEntity item1 : userEntities) {
                StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
                staffResponseDTO.setStaffId(item1.getId());
                staffResponseDTO.setFullName(item1.getFullName());
                staffResponseDTO.setChecked("");
                for (UserEntity item2 : customerEntity.getStaffs()) {
                    if (item1.getId() == item2.getId()) {
                        staffResponseDTO.setChecked("checked");
                    }
                }
                staffResponseDTOS.add(staffResponseDTO);
            }
            return staffResponseDTOS;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public CustomerDTO findOne(Long id) {
        try{
            CustomerEntity customerEntity = customerRepository.findOne(id);
            return customerConverter.convertToDto(customerEntity);
        }catch (Exception e){
            throw e;
        }
    }
}
