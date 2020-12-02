package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.jdbc.IBuildingJDBC;
import com.laptrinhjavaweb.repository.jdbc.ICustomerJDBC;
import com.laptrinhjavaweb.repository.jdbc.impl.BuildingJDBC;
import com.laptrinhjavaweb.repository.jdbc.impl.CustomerJDBC;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    private ICustomerJDBC iCustomerJDBC=new CustomerJDBC();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO findOneByUserNameAndStatus(String name, int status) {
        return userConverter.convertToDto(userRepository.findOneByUserNameAndStatus(name, status));
    }

    @Override
    @Transactional
    public void   addCustomer(CustomerDTO customerDTO) {
        iCustomerJDBC.addCustomer(customerDTO);

    }

    @Override
    public List<CustomerDTO> searchCustomer(CustomerDTO customerDTO) {
        List<CustomerDTO> result=iCustomerJDBC.searchCustomer(customerDTO);
        return result;
    }


}
