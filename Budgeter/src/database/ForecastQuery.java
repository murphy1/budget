package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ForecastQuery {
	
	private int classificationResult;
	
	
	
	public int getClassificationForForecast(int id) {
		
		int dbId = id;
		
		try {
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			conn = DriverManager.getConnection(dbUrl, username, password);
			
			stmt = conn.createStatement();
			
			String sql = "select * from account_table where id = '"+dbId+"'";
			
			rs = stmt.executeQuery(sql);
			rs.last();
			
			classificationResult = rs.getInt("taxClass");
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return classificationResult;
		
	}

}
