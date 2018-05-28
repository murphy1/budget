import database.MoneyQuery;

public class Expenses implements Budget {

	private double rent;
	private double savings;
	private double loan;
	private double miscExpenses;
	
	public Expenses() {
		
	}
	
	public Expenses(double rent, double savings, double loan, double miscExpenses) {
		this.rent = rent;
		this.savings = savings;
		this.loan = loan;
		this.miscExpenses = miscExpenses;
	}


	@Override
	public double getTotal() {
		final double totalExpense = rent+savings+loan+miscExpenses;
		
		return totalExpense;
		
	}
	
	public double getExpenses(int id) {
		MoneyQuery mq = new MoneyQuery();
		double exp = mq.getExpenses(id);
		
		return exp;
	}

}
