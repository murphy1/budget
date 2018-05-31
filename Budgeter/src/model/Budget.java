package model;

public interface Budget {
	
	
	double getTotal();
	
	
	static double getSpendingMoney(double income, double expenses) {
		return (income - expenses);
	}
	
}
