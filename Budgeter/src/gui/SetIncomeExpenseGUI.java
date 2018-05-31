package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import database.AccountQuery;
import model.Account;

public class SetIncomeExpenseGUI extends JFrame{
	
	AccountQuery aq;
	
	private int accountIdNum;
	private String idExists;
	
	private JTextField income;
	private JTextField expense;
	private JTextField accNumber;
	private JButton submit;
	private JButton alreadySet;
	
	private JLabel errorLbl;
	
	public SetIncomeExpenseGUI(){
		
		setLayout(new FlowLayout());
		
		accNumber = new JTextField("account number");
		income = new JTextField("Enter Income");
		expense = new JTextField("Enter Expenses");
		submit = new JButton("Submit");
		alreadySet = new JButton("Get Forecast");
		
		errorLbl = new JLabel();
		
		add(accNumber);
		add(income);
		add(expense);
		add(submit);
		add(alreadySet);
		
		add(errorLbl);
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(accNumber.getText().isEmpty()) {
					errorLbl.setText("account number cannot be blank");
					accNumber.setText("account number");
				}else if(income.getText().isEmpty() || expense.getText().isEmpty()) {
					errorLbl.setText("income / expense cannot be blank");
					income.setText("income");
					expense.setText("expense");
					
				}else
					
					aq = new AccountQuery();
					idExists = aq.checkAccountId(accountIdNum = Integer.parseInt(accNumber.getText()));
					
					if(idExists == "false" ) {
						errorLbl.setText("not a valid account number");
					}else if(idExists == "true") {
					
					accountIdNum = Integer.parseInt(accNumber.getText());
					double enteredIncome = Double.parseDouble(income.getText());
					double enteredExpenses = Double.parseDouble(expense.getText());
										
					Account acc = new Account();
					acc.setIncomeExpense(accountIdNum, enteredIncome, enteredExpenses);
					
					dispose();
					
					GetForecastGUI ob = new GetForecastGUI();
					ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ob.setVisible(true);
					ob.setTitle("Forecast");
					}
				
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
