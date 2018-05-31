package model;
import java.util.List;

public class Income implements Budget{
	private double salary;
	private double miscIncome;
	
	public Income() {
		
	}
	
	public Income(double salary, double miscIncome) {
		this.salary = salary;
		this.miscIncome = miscIncome;
	}
	
	public double newIncomeExpense(double amount) {
		
		
		
		return amount;
	}
	
	public double getTotal() {
		final double totalIncome = salary + miscIncome;
		return totalIncome;
	}
	
	public String toString() {
		double income = getTotal();
		return "Total Income: [ "+income+" ]";
	}

}
