import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class DocumentPrinter {

	public static void main(String[] args) {
		
		Budget income = new Income(1800,0);
		Budget expense = new Expenses(350, 100, 170, 240);
		
		double totalIncome = income.getTotal();
		double totalExpense = expense.getTotal();
		
		double result = Budget.getSpendingMoney(totalIncome, totalExpense);
		
		String info = income.toString();
		
		String filename = "files/MayPayslip.txt";
		File file = new File(filename);
		
		try(OutputStream os = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(os);
				){
			
			//dos.writeUTF();
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public String toString() {
		
		Budget income = new Income(1800,0);
		Budget expense = new Expenses(350, 100, 170, 240);
		
		double totalIncome = income.getTotal();
		double totalExpense = expense.getTotal();
		
		double result = Budget.getSpendingMoney(totalIncome, totalExpense);
		
		
		return "spending money: "+result;
	}
	

}
