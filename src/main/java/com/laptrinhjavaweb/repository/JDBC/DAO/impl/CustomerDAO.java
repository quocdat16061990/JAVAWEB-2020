package com.laptrinhjavaweb.repository.JDBC.DAO.impl;

import com.laptrinhjavaweb.repository.JDBC.DAO.IBuildingDAO;
import com.laptrinhjavaweb.repository.JDBC.DAO.ICustomerDAO;
import com.laptrinhjavaweb.repository.JDBCModel.BuildingModel;
import com.laptrinhjavaweb.repository.JDBCModel.CustomerModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


    public class CustomerDAO implements ICustomerDAO {

        public Connection getConnection() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/realestate092020";
                String username="root";
                String password="quocdat16061990";
                return DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException | SQLException e) {

                e.printStackTrace();
            }
            return null;
        }

        public List<CustomerModel> findCustomer(){
            List<CustomerModel> results=new ArrayList<>();
            String sql = "select * from customer";
            Connection conn= getConnection();
            PreparedStatement statement=null;
            ResultSet rs=null;
            if(conn!=null) {
                try {
                    statement=conn.prepareStatement(sql);
                    rs=statement.executeQuery();
                    while(rs.next()) {
                        CustomerModel customerModel=new CustomerModel();
                        customerModel.setFullname(rs.getString("fullname"));
                        customerModel.setPhone(rs.getInt("phone"));
                        customerModel.setEmail(rs.getString("email"));
                        results.add(customerModel);

                    }
                    return results;

                }catch(SQLException e) {
                    return null;
                }
                finally {
                    try {
                        if(conn!= null) {
                            conn.close();
                        }
                        if(statement!= null) {
                            statement.close();
                        }
                        if(rs!= null) {
                            rs.close();
                        }
                    }catch(SQLException e) {
                        return null;
                    }
                }
            }
            return null;
        }
        public List<CustomerModel> addCustomer(){

            List<CustomerModel> results=new ArrayList<>();
            String sql = "INSERT INTO customer (fullname,phone,email) VALUES (?,?,?)";
            Connection conn= getConnection();
            PreparedStatement statement=null;
            ResultSet rs=null;
            if(conn!=null) {
                try {
                    statement=conn.prepareStatement(sql);
                    rs=statement.executeQuery();
                    while(rs.next()) {

                        CustomerModel customerModel=new CustomerModel();
                        customerModel.setFullname(rs.getString("fullname"));
                        customerModel.setPhone(rs.getInt("phone"));
                        customerModel.setEmail(rs.getString("email"));
                        results.add(customerModel);

                    }
                    return results;

                }catch(SQLException e) {
                    return null;
                }
                finally {
                    try {
                        if(conn!= null) {
                            conn.close();
                        }
                        if(statement!= null) {
                            statement.close();
                        }
                        if(rs!= null) {
                            rs.close();
                        }
                    }catch(SQLException e) {
                        return null;
                    }
                }
            }
            return null;
        }
    }

