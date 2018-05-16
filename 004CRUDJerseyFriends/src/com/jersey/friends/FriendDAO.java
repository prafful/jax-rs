package com.jersey.friends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class FriendDAO {
	
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	int resultSet ;
	
	
	public void connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/frienddb", "root","root1");
			System.out.println("Connection " + connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void disconnect(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public void deleteFriend(Integer id) throws SQLException{
		connect();
		resultSet = statement.executeUpdate("delete from frienddb.friend where id="+id);
		disconnect();
	}

}
