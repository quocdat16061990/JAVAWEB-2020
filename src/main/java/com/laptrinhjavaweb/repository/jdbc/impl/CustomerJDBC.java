package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.repository.jdbc.ICustomerJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerJDBC implements ICustomerJDBC {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/javawebspringboot";
            String username="root";
            String password="quocdat16061990";
            return DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<CustomerDTO> searchCustomer(CustomerDTO search) {
        List<CustomerDTO> result = new ArrayList<>();
        String sql= "SELECT * FROM customer as c;";
        Connection conn=getConnection();
        PreparedStatement statement=null;
        ResultSet rs=null;
        if(conn !=null){
            try {
                statement=conn.prepareStatement(sql);
                rs=statement.executeQuery();
                while (rs.next()){
                    CustomerDTO customerDTO=new CustomerDTO();
                    customerDTO.setName(rs.getString("name"));
                    customerDTO.setPhone(rs.getString("phone"));
                    customerDTO.setEmail(rs.getString("email"));
                    result.add(customerDTO);
                }
                return result;

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

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        String sql = "INSERT INTO customer (name,phone,email) VALUES (?,?,?)";
        Connection conn= getConnection();
        PreparedStatement statement = null;
        ResultSet rs=null;
        if(conn!=null) {
            try {
                statement=conn.prepareStatement(sql);
                statement.setString(1,customerDTO.getName());
                statement.setString(2,customerDTO.getEmail());
                statement.setString(3,customerDTO.getPhone());

                statement.executeUpdate();
            }catch(SQLException e) {
                e.printStackTrace();
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
                    e.printStackTrace();
                }
            }
        }

    }

}
