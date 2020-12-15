package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.repository.jdbc.IBuildingJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//
//public class BuildingJDBC implements IBuildingJDBC {
//    public Connection getConnection() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url="jdbc:mysql://localhost:3306/javawebspringboot";
//            String username="root";
//            String password="quocdat16061990";
//            return DriverManager.getConnection(url,username,password);
//        } catch (ClassNotFoundException | SQLException e) {
//
//            e.printStackTrace();
//        }
//        return null;
//    }
//    @Override
//    public List<BuildingDTO> search(BuildingDTO model) {
//        List<BuildingDTO> result = new ArrayList<>();
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT b.* FROM building as b");
//        if (model.getStaffId() != null) {
//            sql.append(" left join assignmentbuilding ab on ab.buildingid = b.id");
//        }
//        sql.append(" WHERE 1 = 1");
//        if (model.getRentAreaFrom() != null || model.getRentAreaTo() != null) {
//            if (model.getRentAreaFrom() != null && model.getRentAreaTo() != null) {
//                sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value BETWEEN " + model.getRentAreaFrom() + " AND " + model.getRentAreaTo());
//            } else {
//                sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value >=  " + model.getRentAreaFrom());
//            }
//            sql.append(")");
//        } else if (model.getRentAreaTo() != null) {
//            sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value <= " + model.getRentAreaTo() + ")");
//        }
//        if (model.getName() != null && model.getName() != "") {
//            sql.append(" AND b.name LIKE '%"+ model.getName() +"%'");
//        }
//        if (model.getFloorArea() != null) {
//            sql.append(" AND b.floorarea = " + model.getFloorArea());
//        }
//        if (model.getDistrict() != null && model.getDistrict() != "") {
//            sql.append(" AND b.district LIKE '%" + model.getDistrict() +"%'");
//        }
//        if (model.getWard() != null && model.getWard() != "") {
//            sql.append(" AND b.ward LIKE '%"+ model.getWard() +"%'");
//        }
//        if (model.getStreet() != null && model.getStreet() != "") {
//            sql.append(" AND b.street LIKE '%"+ model.getStreet() +"%'");
//        }
//        if (model.getNumberOfBasement() != null) {
//            sql.append(" AND b.numberofbasement = " + model.getNumberOfBasement());
//        }
//        if (model.getDirection() != null && model.getDirection() != "") {
//            sql.append(" AND b.direction LIKE '%" + model.getDirection() + "%'");
//        }
//        if (model.getLevel() != null && model.getLevel() != "") {
//            sql.append(" AND b.level LIKE '% " + model.getLevel()+ "%'");
//        }
//        if (model.getRentCostFrom() != null || model.getRentCostTo() != null) {
//            if (model.getRentCostFrom() != null) {
//                sql.append(" AND b.rentcost >= " + model.getRentCostFrom());
//            }
//            if (model.getRentCostTo() != null){
//                sql.append(" AND b.rentcost <= " + model.getRentCostTo() +"");
//            }
//        }
//        if (model.getManagerName() != null && model.getManagerName() != "") {
//            sql.append(" AND b.managername LIKE '%"+ model.getManagerName() +"%'");
//        }
//        if (model.getManagerPhone() != null && model.getManagerPhone() != "") {
//            sql.append(" AND b.managerphone LIKE '%"+ model.getManagerPhone() +"%'");
//        }
//        if (model.getType() != null && model.getType().length > 0 ) {
//            sql.append("and (b.types LIKE '%");
//            for (int i = 0; i < model.getType().length;i++) {
//                sql.append(model.getType()[i]);
//                if (i != model.getType().length - 1) {
//                    sql.append("%' or b.types LIKE '%");
//                }
//            }
//            sql.append("%')");
//        }
//        sql.append(" GROUP BY b.id");
//        sql.toString();
//
//        Connection conn= getConnection();
//        PreparedStatement statement = null;
//        ResultSet rs=null;
//        if(conn!=null) {
//            try {
//                statement=conn.prepareStatement(String.valueOf(sql));
//                rs=statement.executeQuery();
//                while(rs.next()) {
//                    BuildingDTO building = new BuildingDTO();
//                    building.setName(rs.getString("name"));
//                    building.setWard(rs.getString("ward"));
//                    building.setStreet(rs.getString("street"));
//                    building.setDistrict(rs.getString("district"));
//                    building.setManagerName(rs.getString("managername"));
//                    building.setManagerPhone(rs.getString("managerphone"));
//                    building.setFloorArea(rs.getInt("floorarea"));
//                    building.setNumberOfBasement(rs.getInt("numberofbasement"));
//                    building.setRentCost(rs.getInt("rentprice"));
//                    building.setServiceFee(rs.getString("servicefee"));
//                    result.add(building);
//                }
//                return result;
//
//            }catch(SQLException e) {
//                return null;
//            }
//            finally {
//                try {
//                    if(conn!= null) {
//                        conn.close();
//                    }
//                    if(statement!= null) {
//                        statement.close();
//                    }
//                    if(rs!= null) {
//                        rs.close();
//                    }
//                }catch(SQLException e) {
//                    return null;
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void addBuilding(BuildingDTO b) {
//        String sql = "INSERT INTO building (name,district,ward,street,floorarea,numberofbasement) VALUES (?,?,?,?,?,?)";
//        Connection conn= getConnection();
//        PreparedStatement statement = null;
//        ResultSet rs=null;
//        if(conn!=null) {
//            try {
//                statement=conn.prepareStatement(sql);
//                statement.setString(1,b.getName());
//                statement.setString(2,b.getDistrict());
//                statement.setString(3,b.getWard());
//                statement.setString(4,b.getStreet());
//                statement.setInt(5,b.getFloorArea());
//                statement.setInt(6,b.getNumberOfBasement());
//                statement.executeUpdate();
//            }catch(SQLException e) {
//                e.printStackTrace();
//            }
//            finally {
//                try {
//                    if(conn!= null) {
//                        conn.close();
//                    }
//                    if(statement!= null) {
//                        statement.close();
//                    }
//                    if(rs!= null) {
//                        rs.close();
//                    }
//                }catch(SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    @Override
//    public List<BuildingDTO>  editBuilding(BuildingDTO buildingDTO){
//        String sql= "UPDATE building SET name=?, ward=?, street=?,numberofbasement=? ," +
//                "rentarea=?  , managername=? , managerphone=? , level=? ,floorarea=? ," +
//                "district=?,direction=?,type=?  WHERE id=?";
//        Connection conn=getConnection();
//        PreparedStatement statement=null;
//        ResultSet rs=null;
//        if(conn !=null){
//            try {
//                statement=conn.prepareStatement(sql);
//               statement.setString(1,buildingDTO.getName());
//               statement.setString(2,buildingDTO.getWard());
//               statement.setString(3,buildingDTO.getStreet());
//               statement.setInt(4,buildingDTO.getNumberOfBasement());
//               statement.setInt(5,buildingDTO.getRentArea());
//               statement.setString(6,buildingDTO.getManagerName());
//               statement.setString(7,buildingDTO.getManagerPhone());
//               statement.setString(8,buildingDTO.getLevel());
//               statement.setInt(9,buildingDTO.getFloorArea());
//               statement.setString(10,buildingDTO.getDistrict());
//               statement.setString(11,buildingDTO.getDirection());
//               statement.setString(12, String.valueOf(buildingDTO.getBuildingTypes()));
//
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//}
//

