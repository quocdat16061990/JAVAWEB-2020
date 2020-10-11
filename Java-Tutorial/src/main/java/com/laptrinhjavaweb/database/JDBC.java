  
package com.laptrinhjavaweb.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JDBC {
	
	 public static void main(String[] args) {
		  String dbURL ="jdbc:mysql://localhost:3306/javaweb12";
		  String user="root";
		  String pass="quocdat16061990";
		  PreparedStatement statement=null;
		  ResultSet rs=null;
		  String sql="select b.name as name, b.numberofbasement as basement, b.street as street,b.ward as ward ,b.numberofbasement as numberofbasement, b.direction as direction,b.rate as rate,b.nameofmanager as nameofmanager,b.managerphone as managerphone,b.leaseprice as leaseprice,b.leasepricedescription as leasepricedescription\r\n" + 
		  		"from building as b\r\n" + 
		  		"inner join district as d on d.id = b.districtid\r\n" + 
		  		"inner join buildingchosentype as bct on bct.id = b.id\r\n" + 
		  		"inner join buildingtype as bt on bt.id = bct.buildingtypeid";
		  try(Connection conn = DriverManager.getConnection(dbURL,user,pass)){
			  Class.forName("com.mysql.jdbc.Driver");
			  if(conn!= null) {
				  statement = conn.prepareStatement(sql);
				
				  rs=statement.executeQuery();
				  while(rs.next()) {
					  String name=rs.getString("name");
					  System.out.println(name);
				  }
			  }
		  } catch (ClassNotFoundException | SQLException e) {
			System.out.print(e.getMessage());
		}
}
}