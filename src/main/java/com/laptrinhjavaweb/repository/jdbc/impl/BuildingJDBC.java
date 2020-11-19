package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.SearchBuildingDTO;
import com.laptrinhjavaweb.repository.jdbc.IBuildingJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuildingJDBC implements IBuildingJDBC {
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
    public List<BuildingDTO> search(SearchBuildingDTO search) {
        List<BuildingDTO> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT b.* FROM building as b");
        if (search.getStaffId() != null) {
            builder.append(" left join assignmentbuilding ab on ab.buildingid = b.id");
        }
        builder.append(" WHERE 1 = 1");
        if (search.getAreaRentFrom() != null || search.getAreaRentTo() != null) {
            if (search.getAreaRentFrom() != null && search.getAreaRentTo() != null) {
                builder.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value BETWEEN " + search.getAreaRentFrom() + " AND " + search.getAreaRentTo());
            } else {
                    builder.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value >=  " + search.getAreaRentFrom());
                }
                builder.append(")");
            } else if (search.getAreaRentTo() != null) {
                builder.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value <= " + search.getAreaRentTo() + ")");
            }
        if (search.getName() != null && search.getName() != "") {
            builder.append(" AND b.name LIKE '%"+ search.getName() +"%'");
        }
        if (search.getFloorArea() != null) {
            builder.append(" AND b.floorarea = " + search.getFloorArea());
        }
        if (search.getDistrict() != null && search.getDistrict() != "") {
            builder.append(" AND b.district LIKE '%" + search.getDistrict() +"%'");
        }
        if (search.getWard() != null && search.getWard() != "") {
            builder.append(" AND b.ward LIKE '%"+ search.getWard() +"%'");
        }
        if (search.getStreet() != null && search.getStreet() != "") {
            builder.append(" AND b.street LIKE '%"+ search.getStreet() +"%'");
        }
        if (search.getNumberOfBasement() != null) {
            builder.append(" AND b.numberofbasement = " + search.getNumberOfBasement());
        }
        if (search.getDirection() != null && search.getDirection() != "") {
            builder.append(" AND b.direction LIKE '%" + search.getDirection() + "%'");
        }
        if (search.getLevel() != null && search.getLevel() != "") {
            builder.append(" AND b.level LIKE '% " + search.getLevel()+ "%'");
        }
        if (search.getCostRentFrom() != null || search.getCostRentTo() != null) {
            if (search.getCostRentFrom() != null) {
                builder.append(" AND b.rentprice >= " + search.getCostRentFrom());
            }
            if (search.getCostRentTo() != null){
                builder.append(" AND b.rentprice <= " + search.getCostRentTo() +"");
            }
        }
        if (search.getManagerName() != null && search.getManagerName() != "") {
            builder.append(" AND b.managername LIKE '%"+ search.getManagerName() +"%'");
        }
        if (search.getManagerPhone() != null && search.getManagerPhone() != "") {
            builder.append(" AND b.managerphone LIKE '%"+ search.getManagerPhone() +"%'");
        }
        if (search.getBuildingTypes() != null && search.getBuildingTypes().length > 0 ) {
            builder.append("and (b.types LIKE '%");
            for (int i = 0; i < search.getBuildingTypes().length;i++) {
                builder.append(search.getBuildingTypes()[i]);
                if (i != search.getBuildingTypes().length - 1) {
                    builder.append("%' or b.types LIKE '%");
                }
            }
            builder.append("%')");
        }
        builder.append(" GROUP BY b.id");
        builder.toString();

        Connection conn= getConnection();
        PreparedStatement statement = null;
        ResultSet rs=null;
        if(conn!=null) {
            try {
                statement=conn.prepareStatement(String.valueOf(builder));
                rs=statement.executeQuery();
                while(rs.next()) {
                    BuildingDTO building = new BuildingDTO();
                    building.setName(rs.getString("name"));
                    building.setWard(rs.getString("ward"));
                    building.setStreet(rs.getString("street"));
                    building.setDistrict(rs.getString("district"));
                    building.setManagerName(rs.getString("managername"));
                    building.setManagerPhone(rs.getString("managerphone"));
                    building.setFloorArea(rs.getInt("floorarea"));
                    building.setNumberOfBasement(rs.getInt("numberofbasement"));
                    building.setRentPrice(rs.getInt("rentprice"));
                    building.setServiceFee(rs.getString("servicefee"));
                    result.add(building);
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
    public void addBuilding(BuildingDTO b) {
        String sql = "INSERT INTO building (name,district,ward,street,floorarea,numberofbasement) VALUES (?,?,?,?,?,?)";
        Connection conn= getConnection();
        PreparedStatement statement = null;
        ResultSet rs=null;
        if(conn!=null) {
            try {
                statement=conn.prepareStatement(sql);
                statement.setString(1,b.getName());
                statement.setString(2,b.getDistrict());
                statement.setString(3,b.getWard());
                statement.setString(4,b.getStreet());
                statement.setInt(5,b.getFloorArea());
                statement.setInt(6,b.getNumberOfBasement());
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
    @Override
    public List<BuildingDTO>  editBuilding(BuildingDTO buildingDTO){
        String sql= "UPDATE building SET name=?, ward=?, street=?,numberofbasement=? ," +
                "rentarea=?  , managername=? , managerphone=? , level=? ,floorarea=? ," +
                "district=?,direction=?,type=?  WHERE id=?";
        Connection conn=getConnection();
        PreparedStatement statement=null;
        ResultSet rs=null;
        if(conn !=null){
            try {
                statement=conn.prepareStatement(sql);
               statement.setString(1,buildingDTO.getName());
               statement.setString(2,buildingDTO.getWard());
               statement.setString(3,buildingDTO.getStreet());
               statement.setInt(4,buildingDTO.getNumberOfBasement());
               statement.setInt(5,buildingDTO.getRentArea());
               statement.setString(6,buildingDTO.getManagerName());
               statement.setString(7,buildingDTO.getManagerPhone());
               statement.setString(8,buildingDTO.getLevel());
               statement.setInt(9,buildingDTO.getFloorArea());
               statement.setString(10,buildingDTO.getDistrict());
               statement.setString(11,buildingDTO.getDirection());
               statement.setString(12, String.valueOf(buildingDTO.getTypeArrays()));


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}


