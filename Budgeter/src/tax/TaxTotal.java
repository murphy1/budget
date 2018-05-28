package tax;

import database.TaxQuery;

public class TaxTotal {
	
	private double uscTotal;
	private double payeTotal;
	private double prsiTotal;
	private double taxCredit = 275;
	private double result;
	private double allTax;
	
	// get USC
	
	USC usc = new USC();
	
	// get PAYE
	
	PAYE paye = new PAYE();
	
	// get PRSI
	
	PRSI prsi = new PRSI();
	
	// method to add all together and return to Main Runnable class

	public double getTax(int id, int classification) {
		
		double income;
		
		TaxQuery txq = new TaxQuery();
		income = txq.getIncomeFromDatabase(id);
		
		
		uscTotal = usc.calcUsc(income);
		payeTotal = paye.calcPaye(income, classification);
		prsiTotal = prsi.calcPrsi(income);
		
		allTax = ((uscTotal + payeTotal + prsiTotal) - taxCredit);
		
		result = (income - allTax);
		
		
		return result;
		
	}
	
}
