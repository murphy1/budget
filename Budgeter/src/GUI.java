import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame {

		private JLabel label;
		
		private JButton alreadyHaveAccBtn;
		private JButton submitNewAccBtn;
		
		private JTextField firstName;
		private JTextField lastName;
		private JTextField taxClass;
	 
		GUI()
		{
			setLayout(new FlowLayout());
			
			label = new JLabel("Budgeter");
			
			
			alreadyHaveAccBtn = new JButton("Already have Account");
			submitNewAccBtn = new JButton("Create Account");
			
			firstName = new JTextField("First Name");
			lastName = new JTextField("Last Name");
			taxClass = new JTextField("Tax Classification");
			
			
			add(label);
			add(alreadyHaveAccBtn);
			add(firstName);
			add(lastName);
			add(taxClass);
			add(submitNewAccBtn);
			
		      
		
	    submitNewAccBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String fName = firstName.getText();
				String lName = lastName.getText();
				String txClass = taxClass.getText();
				
				// this works
				//Account account = new Account(fName, lName, txClass);
				//account.createAccount();
				
				dispose();
				
				SetIncomeExpenseGUI ob = new SetIncomeExpenseGUI();
				ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ob.setVisible(true);
				ob.setTitle("GUI");
				
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
		
}

}