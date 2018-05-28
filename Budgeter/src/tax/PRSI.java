package tax;

public class PRSI{
	
	private double result;
	private double yearlyIncome;
	private double weeklyIncome;
	private double prsiCredit;
	private double prsi;
	private double weeklyToYearly;
	
	// we are currently only doing PRSI for private sector employees!!!
	
	public double calcPrsi(double income) {
		
		yearlyIncome = income * 12;
		weeklyIncome = yearlyIncome / 52;
		
		if(weeklyIncome <= 424) {
			prsiCredit = ((weeklyIncome - 352.01) / 6);
			prsi  = (((weeklyIncome / 100) * 4) - prsiCredit);
			weeklyToYearly = (prsi * 52);
			
			result = (weeklyToYearly / 12);
			
		}else if(weeklyIncome > 424) {
			prsi = ((weeklyIncome / 100) * 4);
			weeklyToYearly = (prsi * 52);
			
			result = (weeklyToYearly / 12);
			
		}
		
		return result;
		
	}

}
