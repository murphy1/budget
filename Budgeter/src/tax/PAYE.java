package tax;

public class PAYE{
	
	private double incomeYearly;
	private double topTaxRate;
	private double result;
	private boolean singleWidowNoKids;
	private boolean singleWidowKids;
	private boolean marriedOneEarner;
	private boolean marriedBothEarn;
	
	public double calcPaye(double income, int classification) {
		
		// income multiplied by 12 to get yearly figure
		incomeYearly = income * 12;
		
		/* 
		 *  single no kids = 1
		 * 	single with kids = 2
		 *  married one earner = 3
		 *  married both earn = 4
		 * */
		
		if(classification == 1) {
			
			if(incomeYearly <= 34550) {
				result = (((incomeYearly / 100) * 20) / 12);
			}else if(incomeYearly > 34550) {
				topTaxRate = incomeYearly - 34550;
				
				double topTax = (topTaxRate / 100) * 40;
				
				result = ((((34550 / 100) * 20) + topTax) / 12);
			}
				
				
		}else if(classification == 2) {
			
			if(incomeYearly <= 38550) {
				result = (incomeYearly / 100) * 20;
			}else if(incomeYearly > 38550) {
				topTaxRate = incomeYearly - 38550;
				
				double topTax = (topTaxRate / 100) * 40;
				
				result = ((38550 / 100) * 20) + topTax;
			}
			
		}else if(classification == 3) {
			
			if(incomeYearly <= 43550) {
				result = (incomeYearly / 100) * 20;
			}else if(incomeYearly > 43550) {
				topTaxRate = incomeYearly - 43550;
				
				double topTax = (topTaxRate / 100) * 40;
				
				result = ((43550 / 100) * 20) + topTax;
			}
			
		}else if(classification == 4) {
			
			if(incomeYearly <= 69100) {
				result = (incomeYearly / 100) * 20;
			}else if(incomeYearly > 69100) {
				topTaxRate = incomeYearly - 69100;
				
				double topTax = (topTaxRate / 100) * 40;
				
				result = ((69100 / 100) * 20) + topTax;
			}
			
		}
		
		
		return (result / 12);
	}
	

}
