package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import database.AccountQuery;
import model.Account;

public class GUI extends JFrame {

		private JLabel label;
		
		private JButton alreadyHaveAccBtn;
		private JButton submitNewAccBtn;
		
		private JTextField firstName;
		private JTextField lastName;
		private JTextField taxClass;
		
		private JLabel errorLbl;
		
		private JLabel newAccNumber;
		
		private JButton nextBtn;
	 
		public GUI()
		{
			setLayout(new FlowLayout());
			
			label = new JLabel("Budgeter");
			
			
			alreadyHaveAccBtn = new JButton("Already have Account");
			submitNewAccBtn = new JButton("Create Account");
			
			firstName = new JTextField("First Name");
			lastName = new JTextField("Last Name");
			taxClass = new JTextField("Tax Classification");
			
			errorLbl = new JLabel();
			
			newAccNumber = new JLabel();
			
			nextBtn = new JButton();
			
			add(label);
			add(alreadyHaveAccBtn);
			add(firstName);
			add(lastName);
			add(taxClass);
			add(submitNewAccBtn);
			
			add(errorLbl);
			
		    add(newAccNumber);  
		
	    submitNewAccBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
					errorLbl.setText("first name and last name cannot be empty");
					firstName.setText("First Name");
					lastName.setText("Last Name");
				}else if(taxClass.getText().isEmpty()) {
					errorLbl.setText("tax classification cannot be empty");
					taxClass.setText("Tax Classification");
				}else{
				
				String fName = firstName.getText();
				String lName = lastName.getText();
				int txClass = Integer.parseInt(taxClass.getText());
				
				// this works
				Account account = new Account(fName, lName, txClass);
				account.createAccount();
				
				AccountQuery aq = new AccountQuery();
				
				newAccNumber.setText("Your new Account Number: "+aq.getAccountId(fName));
				
				add(nextBtn);
				nextBtn.setText("Next");
				}
				
			}
	    });
	    
	    alreadyHaveAccBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
				SetIncomeExpenseGUI ob = new SetIncomeExpenseGUI();
				ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ob.setVisible(true);
				ob.setTitle("GUI");
				
			}
	    	
	    });
	    
	    nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
				SetIncomeExpenseGUI ob = new SetIncomeExpenseGUI();
				ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ob.setVisible(true);
				ob.setTitle("GUI");
				
			}
	    	
	    });
		
}

}