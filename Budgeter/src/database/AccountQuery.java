package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountQuery {
	

	
	public void addNewAccount(String firstName, String lastName, int taxClass) {
		
		String fName = firstName;
		String lName = lastName;
		int tClass = taxClass;
		
		try {
			
			Connection conn = null;
			conn = DriverManager.getConnection(dbUrl, username, password);
			
			String sql = "insert into account_table (firstName, lastName, taxClass, income, expenses) values (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, fName);
			ps.setString(2, lName);
			ps.setInt(3, tClass);
			ps.setDouble(4, 0);
			ps.setDouble(5, 0);
			
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
