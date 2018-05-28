import database.AccountQuery;
import database.MoneyQuery;

public class Account {
	
	private int accountId;
	private String firstName;
	private String lastName;
	private String taxClassification;
	
	public Account() {
		
	}
	
	public Account(String firstName, String lastName, String taxClassification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.taxClassification = taxClassification;
	}
	
	public void setIncome(double salary, double miscIncome) {
		Budget income = new Income(salary, miscIncome);
	}
	
	public void setExpenses(double rent, double savings, double loan, double miscExpenses) {
		Budget expenses = new Expenses(rent, savings, loan, miscExpenses);
	}
	
	public void createAccount() {
		AccountQuery ac = new AccountQuery();
		ac.addNewAccount(firstName, lastName, taxClassification);
		// will have to expand this method in future to check if account exists
	}
	
	public void setIncomeExpense(double income, double expense) {
		MoneyQuery mq = new MoneyQuery();
		mq.addIncomeExpense(income, expense);
		
		// will have to expand this later to check users id first
	}

}

