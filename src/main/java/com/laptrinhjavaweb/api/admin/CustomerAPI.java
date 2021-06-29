package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.request.AssignmentCustomerRequestDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "customerAPIOfAdmin")
@RequestMapping("/api/customer")
public class CustomerAPI {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    private ResponseDTO findOne(@PathVariable("id") Long id){
        ResponseDTO result = new ResponseDTO();
        result.setData(customerService.findOne(id));
        result.setMesager("Success");
        return result;
    }

    @GetMapping("/{id}/staffs")
    private ResponseDTO loadStaff(@PathVariable("id") Long id){
        ResponseDTO result = new ResponseDTO();
        result.setData(customerService.loadStaff(id));
        result.setMesager("Success");
        return result;
    }

    @PostMapping
    private ResponseDTO save(@RequestBody CustomerDTO customerDTO){
        ResponseDTO result = new ResponseDTO();
        result.setData(customerService.save(customerDTO));
        result.setMesager("Success");
        return result;
    }

    @PutMapping
    private ResponseDTO update(@RequestBody CustomerDTO customerDTO){
        ResponseDTO result = new ResponseDTO();
        result.setData(customerService.update(customerDTO));
        result.setMesager("Success");
        return result;
    }

    @PutMapping("/assignment")
    private ResponseDTO assignmentCustomer(@RequestBody AssignmentCustomerRequestDTO requestDTO){
        ResponseDTO result = new ResponseDTO();
        result.setData(customerService.assignmentCustomer(requestDTO));
        result.setMesager("Success");
        return result;
    }

    @DeleteMapping
    private ResponseDTO delete(@RequestBody Long[] ids){
        ResponseDTO result = new ResponseDTO();
        customerService.delete(ids);
        result.setMesager("Success");
        return result;
    }
}
