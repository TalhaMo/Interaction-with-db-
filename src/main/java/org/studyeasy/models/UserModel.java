package org.studyeasy.models;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.studyeasy.DbConnection;
import org.studyeasy.entity.User;

public class UserModel {
	static Connection con= DbConnection.getConnexion();
	public List<User> listUsers() {
		   List<User> listUsers=new ArrayList<>();
           Statement stmt = null;
           ResultSet rs = null;
           try {
			
			// Step 2: Create a SQL statements string
			String query = "Select * from users";
			stmt = con.createStatement();

			// Step 3: Execute SQL query
            rs = stmt.executeQuery(query);
            
			// Step 4: Process the result set
			while(rs.next()){
				listUsers.add(new User(rs.getInt("users_id"), rs.getString("usersname"), rs.getString("email")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUsers;
	}
	public int addUser(User newUser) throws SQLException {
		 
		  String query = "insert into users(usersname, email) VALUES (?, ?)";
      PreparedStatement ps= con.prepareStatement(query);
      ps.setString(1, newUser.getUsersname());
      ps.setString(2, newUser.getEmail());
      int n = ps.executeUpdate();
      return n;
      
     
		
		
	}
	public boolean updateUser(User updatedUser) throws SQLException {
		int userId=updatedUser.getUsers_id();
		String username=updatedUser.getUsersname();
		String email=updatedUser.getEmail();
		 String query= "update users set usersname=?, "
           + " email= ? where users_id = ?";
		 PreparedStatement ps= con.prepareStatement(query);
		  ps.setString(1, username);
	      ps.setString(2, email);
	      ps.setInt(3, userId);
	      return ps.execute();
	}
	public void deleteUser(int userId) {
		
		 String query= "delete users from users where users_id=?";
		 try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1, userId);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
