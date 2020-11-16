package com.laptrinhjavaweb.repository.JDBC.DAO;

import com.laptrinhjavaweb.repository.JDBCModel.BuildingModel;
import com.laptrinhjavaweb.repository.JDBCModel.CustomerModel;

import java.util.List;

public interface ICustomerDAO {
    List<CustomerModel> findCustomer();
    List<CustomerModel> addCustomer();
}
