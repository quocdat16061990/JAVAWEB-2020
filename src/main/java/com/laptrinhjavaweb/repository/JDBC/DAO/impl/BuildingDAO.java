package com.laptrinhjavaweb.repository.JDBC.DAO.impl;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.SearchBuildingDTO;
import com.laptrinhjavaweb.repository.JDBCModel.BuildingModel;
import com.laptrinhjavaweb.repository.JDBC.DAO.IBuildingDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BuildingDAO implements IBuildingDAO {

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

    public List<BuildingDTO> findByCondition(SearchBuildingDTO searchBuildingDTO){
        List<BuildingDTO> results=new ArrayList<>();
        StringBuilder sql1 = new StringBuilder("select b.name, b.ward, b.street, b.district, b.numberofbasement, b.type from building");

        if (searchBuildingDTO.getStaffId() != null) {
            sql1.append(" left join assignmentbuilding ab on ab.buildingid = b.id");
        }
        sql1.append(" WHERE 1 = 1");
        if (searchBuildingDTO.getAreaRentFrom() != null || searchBuildingDTO.getAreaRentTo() != null) {
            if(searchBuildingDTO.getAreaRentFrom() != null){
                sql1.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value BETWEEN "+ searchBuildingDTO.getAreaRentFrom());
                if(searchBuildingDTO.getAreaRentTo() !=null){
                    sql1.append(" AND "+ searchBuildingDTO.getAreaRentTo());
                }
                sql1.append(")");
            }else if (searchBuildingDTO.getAreaRentTo() != null){
                sql1.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value <= "+ searchBuildingDTO.getAreaRentTo() + ")");
            }
        }
        if (searchBuildingDTO.getName() != null && searchBuildingDTO.getName() != "") {
            sql1.append(" AND b.name LIKE '%"+ searchBuildingDTO.getName() +"%'");
        }
        if (searchBuildingDTO.getFloorArea() != null) {
            sql1.append(" AND b.floorarea >= " + searchBuildingDTO.getFloorArea());
        }
        if (searchBuildingDTO.getDistrict() != null && searchBuildingDTO.getDistrict() != "") {
            sql1.append(" AND b.district LIKE '%" + searchBuildingDTO.getDistrict() +"%'");
        }
        if (searchBuildingDTO.getWard() != null && searchBuildingDTO.getWard() != "") {
            sql1.append(" AND b.ward LIKE '%"+ searchBuildingDTO.getWard() +"%'");
        }
        if (searchBuildingDTO.getStreet() != null && searchBuildingDTO.getStreet() != "") {
            sql1.append(" AND b.street LIKE '%"+ searchBuildingDTO.getStreet() +"%'");
        }
        if (searchBuildingDTO.getNumberOfBasement() != null) {
            sql1.append(" AND b.numberofbasement = " + searchBuildingDTO.getNumberOfBasement());
        }
        if (searchBuildingDTO.getDirection() != null && searchBuildingDTO.getDirection() != "") {
            sql1.append(" AND b.direction LIKE '%" + searchBuildingDTO.getDirection() + "%'");
        }
        if (searchBuildingDTO.getLevel() != null && searchBuildingDTO.getLevel() != "") {
            sql1.append(" AND b.level = " + searchBuildingDTO.getLevel());
        }
        if (searchBuildingDTO.getCostRentFrom() != null || searchBuildingDTO.getCostRentTo() != null) {
            if (searchBuildingDTO.getCostRentFrom() != null) {
                sql1.append(" AND b.rentprice >= " + searchBuildingDTO.getCostRentFrom());
            }
            if (searchBuildingDTO.getCostRentTo() != null){
                sql1.append(" AND b.rentprice <= " + searchBuildingDTO.getCostRentTo() +"");
            }
        }
        if (searchBuildingDTO.getManagerName() != null && searchBuildingDTO.getManagerName() != "") {
            sql1.append(" AND b.managername LIKE '%"+ searchBuildingDTO.getManagerName() +"%'");
        }
        if (searchBuildingDTO.getManagerPhone() != null && searchBuildingDTO.getManagerPhone() != "") {
            sql1.append(" AND b.managerphone LIKE '%"+ searchBuildingDTO.getManagerPhone() +"%'");
        }
        if (searchBuildingDTO.getBuildingTypes() != null && searchBuildingDTO.getBuildingTypes().length > 0 ) {
            sql1.append("and (b.type LIKE '%");
            for (int i = 0; i < searchBuildingDTO.getBuildingTypes().length; i++) {
                sql1.append(searchBuildingDTO.getBuildingTypes()[i]);
                if (i != searchBuildingDTO.getBuildingTypes().length - 1) {
                    sql1.append("%' or b.type LIKE '%");
                }
            }
            sql1.append("%')");
        }
        sql1.append(" GROUP BY b.id");
        sql1.toString();

        Connection conn= getConnection();
        PreparedStatement statement=null;
        ResultSet rs=null;
        if(conn!=null) {
            try {
                statement=conn.prepareStatement(String.valueOf(sql1));
                rs=statement.executeQuery();
                while(rs.next()) {
                    BuildingDTO building = new BuildingDTO();
                    building.setName(rs.getString("name"));
                    building.setWard(rs.getString("ward"));
                    building.setStreet(rs.getString("street"));
                    building.setDistrict(rs.getString("district"));
//                    building.setType(rs.getString("type"));
                    results.add(building);
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
    public List<BuildingModel> addBuilding(){

        List<BuildingModel> results=new ArrayList<>();
        String sql = "INSERT INTO building (name,ward,street,district,numberofbasement,floorarea,rentprice,rentdescription) VALUES (?,?,?,?,?,?,?,?)";
        Connection conn= getConnection();
        PreparedStatement statement=null;
        ResultSet rs=null;
        if(conn!=null) {
            try {
                statement=conn.prepareStatement(sql);
                rs=statement.executeQuery();
                while(rs.next()) {
                    BuildingModel buildingModel=new BuildingModel();
                    buildingModel.setName(rs.getString("name"));
                    buildingModel.setWard(rs.getString("ward"));
                    buildingModel.setStreet(rs.getString("street"));
                    buildingModel.setDistrict(rs.getString("district"));
                    buildingModel.setNumberofbasement(rs.getInt("numberofbasement"));
                    buildingModel.setFloorarea(rs.getInt("floorarea"));
                    buildingModel.setRentprice(rs.getInt("rentprice"));
                    buildingModel.setRentdescription(rs.getInt("rentdescription"));
                    results.add(buildingModel);
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
