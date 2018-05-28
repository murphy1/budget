import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Printer {
	
	public void print(double income, Budget expenses) {

	String filename = "files/MayPayslip.txt";
	File file = new File(filename);
	
	double incomeDouble = income;
	double expensesDouble = expenses.getTotal();
	
	
	try(
	OutputStream os = new FileOutputStream(file);
	DataOutputStream dos = new DataOutputStream(os);)
	{

		dos.writeUTF(toString(incomeDouble, expensesDouble));

	}catch(
	IOException e)
	{
		e.printStackTrace();
	}
	
	}

	public String toString(double income, double expense){

		double result = Budget.getSpendingMoney(income, expense);
		double weekly = result / 4;
		double daily = result / 30;

		return "spending money: " + result+"\n weekly allowance: "+
				weekly+"\n daily allowance: "+
				daily;

	}
}


