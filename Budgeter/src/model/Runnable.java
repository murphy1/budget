package model;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.GUI;
import tax.TaxTotal;

public class Runnable {

	public static void main(String[] args) {
		
		GUI ob = new GUI();
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ob.setVisible(true);
		ob.setTitle("GUI");
		
		
		//Account acc = new Account("Stevie", "Murphy", "single no kids");
		
		//works
		//acc.createAccount();
		
		//works
		//acc.setIncomeExpense(2064.70, 500);
		
		//TaxTotal tx = new TaxTotal();
		//System.out.println(tx.getTax(5, "single no kids"));
		
		//Expenses expenses = new Expenses();
		//System.out.println(expenses.getExpenses(5));
		
		//System.out.println("spending money less expenses and tax: "+Budget.getSpendingMoney(tx.getTax(5, "single no kids"), expenses.getExpenses(5)));
		
		//Forecast fc = new Forecast();
		//System.out.println("1 year forecast: "+fc.forecast1y(Budget.getSpendingMoney(tx.getTax(5, "single no kids"), expenses.getExpenses(5))));
		
	}
	
	

}
