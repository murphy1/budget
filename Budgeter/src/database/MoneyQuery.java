package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MoneyQuery {
	

	
	public void addIncomeExpense(double income, double expense) {
		
		double dbIncome = income;
		double dbExpense = expense;
		
		try {
			
			Connection conn = null;
			conn = DriverManager.getConnection(dbUrl, username, password);
			
			String sql = "update account_table set income = ?, expenses = ? where id = 6";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, dbIncome);
			ps.setDouble(2, dbExpense);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	double returnedExpenses;
	
	public double getExpenses(int id) {
		
		double dbId = id;
		
		try {
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			conn = DriverManager.getConnection(dbUrl, username, password);
			
			String sql = "select * from account_table where id = '"+dbId+"'";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			rs.last();
			
			returnedExpenses = rs.getDouble("expenses");
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return returnedExpenses;
		
	}

}
