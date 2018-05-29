package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountQuery {
	
	private String result;
	private int getAccountResult;
	

	
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
	
	public String checkAccountId(int accountId) {
		
		int accId = accountId;
		
		List<Integer> ids = new ArrayList<>();
		
		try {
		
		Connection conn;
		Statement stmt;
		ResultSet rs;
		
		conn = DriverManager.getConnection(dbUrl, username, password);
		
		String sql = "select id from account_table";
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			ids.add(rs.getInt("id"));
		}
		rs.last();
		
		rs.close();
		stmt.close();
		conn.close();
		
		if(ids.contains(accId)) {
			result = "true";
		}else {
			result = "false";
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int getAccountId(String fName) {
		
		try {
			
			Connection conn;
			Statement stmt;
			ResultSet rs;
			
			conn = DriverManager.getConnection(dbUrl, username, password);
			
			String sql = "select * from account_table where firstName = '"+fName+"'";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			rs.last();
			
			getAccountResult = rs.getInt("id");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return getAccountResult;
	}

}
