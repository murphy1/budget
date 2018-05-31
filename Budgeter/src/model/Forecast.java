package model;

public class Forecast extends Income{
	
	private double salaryAfterTax;
	private double result;
	
	public double forecast3m(double income) {
		
		salaryAfterTax = income;
		result = salaryAfterTax * 3;
		
		return result;
	}
	
	public double forecast6m(double income) {
		
		salaryAfterTax = income;
		result = salaryAfterTax * 6;
		
		return result;
	}
	
	public double forecast1y(double income) {
		
		salaryAfterTax = income;
		result = salaryAfterTax * 12;
		
		return result;
	}
	
	public double forecast3y(double income) {
		
		salaryAfterTax = income;
		result = salaryAfterTax * 36;
		
		return result;
	}
	
	public double forecast5y(double income) {
		
		salaryAfterTax = income;
		result = salaryAfterTax * 60;
		
		return result;
	}
	
}
