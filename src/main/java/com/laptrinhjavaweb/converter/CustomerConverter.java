package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO convertToDto(CustomerEntity entity){
        CustomerDTO result = modelMapper.map(entity, CustomerDTO.class);
        return result;
    }

    public CustomerEntity convertToEntity(CustomerDTO dto) {
        CustomerEntity result = modelMapper.map(dto, CustomerEntity.class);
        return result;
    }

    public CustomerEntity convertAddCustomerWithJPA(CustomerDTO dto){
        CustomerEntity result = new CustomerEntity();
        result.setFullName(dto.getFullName());
        result.setPhone(dto.getPhone());
        result.setEmail(dto.getEmail());

        return result;
    }
}
