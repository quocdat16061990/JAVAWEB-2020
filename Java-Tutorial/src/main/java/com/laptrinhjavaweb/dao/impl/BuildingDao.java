package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.IBuildingDAO;
import com.laptrinhjavaweb.model.BuildingModel;

public class BuildingDao implements IBuildingDAO {
	
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
	
	public List<BuildingModel> findByCondition(){
		List<BuildingModel> results=new ArrayList<>();
		String sql = "select b.name, b.ward, b.street, b.district, b.numberofbasement, b.type from building b\r\n" + 
				"left join assignmentbuilding ab on ab.buildingid = b.id\r\n" + 
				"where b.name like '%i%' and b.district like '%Q%'\r\n" + 
				"and b.numberofbasement = 1\r\n" + 
				"and EXISTS (SELECT * FROM rentarea ra WHERE ra.buildingid = b.id and ra.value BETWEEN 100 AND 400)\r\n" + 
				"and (b.type like '%tang_tret%' or b.type like '%nguyen_can%')\r\n" + 
				"\r\n" + 
				"group by b.id";
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
					buildingModel.setType(rs.getString("type"));
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
