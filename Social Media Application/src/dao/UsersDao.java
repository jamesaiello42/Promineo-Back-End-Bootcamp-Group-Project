package dao;

//Wendy Sun Contributed this file

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import entity.Users;

public class UsersDao {
	
	private Connection connection; 
	private final String GET_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id =?"; 
	private final String CREATE_NEW_USER_QUERY = "INSERT INTO users (id, username, email, password) VALUES(?,?,?,?)"; 
	private final String DELETE_USER_BY_ID_QUERY = "DELETE FROM users WHERE id =?"; 
	
	
	
	public UsersDao() {
		connection = DBConnection.getConnection(); 	
	}//constructor 

	public Users getUsersById (int id) throws SQLException {
		Users user = new Users(); 
		PreparedStatement ps = connection.prepareStatement(GET_USER_BY_ID_QUERY); 
		ps.setInt(1, id);
		ps.executeQuery();
		return user; 	
	}//end getUserById
	
	public void createNewUser(int id, String username, String email, String password) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_USER_QUERY); 
		ps.setInt(1, id);
		ps.setString(2,username); 
		ps.setString(3, email);
		ps.setString(4, password);
		ps.executeUpdate(); 
	}//end createNewUser

	public void deleteUserById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_USER_BY_ID_QUERY); 
		ps.setInt(1, id);
		ps.executeUpdate(); 		
	}//end deleteUserById 
		
	
}//end UserDao
