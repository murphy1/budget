package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaxQuery {
	

	double dbIncome;
	
	public double getIncomeFromDatabase(int id) {
		
		int dbId = id;
		
		try {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = DriverManager.getConnection(dbUrl, username, password);
		
		String sql = "select * from account_table where id = '"+dbId+"'";
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		rs.last();
		
		dbIncome = rs.getDouble("income");
		
		rs.close();
		stmt.close();
		conn.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dbIncome;
		
	}

}
