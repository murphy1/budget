package tax;

public class USC{
	
	private double result;
	private double incomeYearly;
	private final double band1 = 12012;
	private final double band2 = 19372;
	private final double band3 = 70044;
	private double phase1;
	private double phase2;
	private double phase3;
	private double phase4;
	
	public double calcUsc(double income) {
		
		incomeYearly = income * 12;
		
		if(incomeYearly > band3) {
			phase4 = (((incomeYearly - band3) / 100) * 8);
			phase3 = ((50672 / 100) * 4.75);
			phase2 = ((7360 / 100) * 2);
			phase1 = ((12012 / 100) * 0.5);
			
			result = ((phase4 + phase3 + phase2 + phase1) / 12);
			
		}else if(incomeYearly > band2) {
			phase3 = (((incomeYearly - band2) / 100) * 4.75);
			phase2 = ((7360 / 100) * 2);
			phase1 = ((12012 / 100) * 0.5);
			
			result = ((phase3 + phase2 + phase1) / 12);
			
		}else if(incomeYearly > band1) {
			phase2 = (((incomeYearly - band1) / 100) * 2);
			phase1 = ((12012 / 100) * 0.5);
			
			result = ((phase2 + phase1) / 12);
			
		}else if(incomeYearly <= band1) {
			phase1 = ((12012 / 100) * 0.5);
			
			result = (phase1 / 12);
			
		}
		
		return result;
	}

}
