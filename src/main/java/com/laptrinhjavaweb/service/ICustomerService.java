package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.repository.JDBCModel.BuildingModel;
import com.laptrinhjavaweb.repository.JDBCModel.CustomerModel;

import java.util.List;

public interface ICustomerService {
    List<CustomerModel> findCustomer();
    List<CustomerModel> addCustomer();
}
