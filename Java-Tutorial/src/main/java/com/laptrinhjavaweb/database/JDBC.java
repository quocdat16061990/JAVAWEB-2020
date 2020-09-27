package com.laptrinhjavaweb.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JDBC {
	
	 public static void main(String[] args) {
		  String dbURL ="jdbc:mysql://localhost:3306/javaweb11";
		  String user="root";
		  String pass="quocdat16061990";
		  PreparedStatement statement=null;
		  ResultSet rs=null;
		  String sql="select * from building";
		  String sql1="select * from district";
		  String sql2="select * from buildingtype";
		  String sql3="select * from transactiontype";
		  try(Connection conn = DriverManager.getConnection(dbURL,user,pass)){
			  Class.forName("com.mysql.jdbc.Driver");
			  if(conn!= null) {
				  statement = conn.prepareStatement(sql1);
				
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
		
