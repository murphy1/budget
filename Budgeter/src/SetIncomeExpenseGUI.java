import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SetIncomeExpenseGUI extends JFrame{
	
	private JTextField income;
	private JTextField expense;
	private JButton submit;
	private JButton alreadySet;
	
	SetIncomeExpenseGUI(){
		
		setLayout(new FlowLayout());
		
		income = new JTextField("Enter Income");
		expense = new JTextField("Enter Expenses");
		submit = new JButton("Submit");
		alreadySet = new JButton("Get Forecast");
		
		add(income);
		add(expense);
		add(submit);
		add(alreadySet);
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				double enteredIncome = Double.parseDouble(income.getText());
				double enteredExpenses = Double.parseDouble(expense.getText());
				
				Account acc = new Account();
				acc.setIncomeExpense(enteredIncome, enteredExpenses);
				
				dispose();
				
				GetForecastGUI ob = new GetForecastGUI();
				ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ob.setVisible(true);
				ob.setTitle("Forecast");
				
			}
			
		});
		
		alreadySet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				GetForecastGUI ob = new GetForecastGUI();
				ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ob.setVisible(true);
				ob.setTitle("Forecast");
				
			}
			
		});
		
	}

}
