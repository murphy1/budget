import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import database.ForecastQuery;
import tax.TaxTotal;

public class GetForecastGUI extends JFrame{
	
	private JLabel topLabel;
	private JRadioButton threeMonthBtn;
	private JRadioButton sixMonthBtn;
	private JRadioButton oneYearBtn;
	private JRadioButton threeYearBtn;
	private JRadioButton fiveYearBtn;
	private JButton submitBtn;
	private JTextField resultField;
	
	GetForecastGUI(){
		
		setLayout(new FlowLayout());
		
		topLabel = new JLabel();
		threeMonthBtn = new JRadioButton();
		sixMonthBtn = new JRadioButton();
		oneYearBtn = new JRadioButton();
		threeYearBtn = new JRadioButton();
		fiveYearBtn = new JRadioButton();
		submitBtn = new JButton();
		resultField = new JTextField();
		
		threeMonthBtn.setText("3 month forecast ");
		sixMonthBtn.setText("6 month forecast ");
		oneYearBtn.setText("1 year forecast ");
		threeYearBtn.setText("3 year forecast ");
		fiveYearBtn.setText("5 year forecast ");
		
		submitBtn.setText("Submit");
		
		resultField.setText("Forecast Results here");
		
		add(topLabel);
		add(threeMonthBtn);
		add(sixMonthBtn);
		add(oneYearBtn);
		add(threeYearBtn);
		add(fiveYearBtn);
		add(submitBtn);
		add(resultField);
		
		
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(threeMonthBtn.isSelected()) {
					
					
					resultField.setText(""+getForecastResult());
					
				}else if(sixMonthBtn.isSelected()) {
					resultField.setText("6 months");
				}else if(oneYearBtn.isSelected()) {
					resultField.setText("6 months");
				}else if(threeYearBtn.isSelected()) {
					resultField.setText("6 months");
				}else if(fiveYearBtn.isSelected()) {
					resultField.setText("6 months");
				}
				
			}
			
		});
		
		
	}
	
	private double getForecastResult() {
		
		ForecastQuery fq = new ForecastQuery();
		TaxTotal tt = new TaxTotal();
		Expenses ex = new Expenses();
		Forecast fc = new Forecast();
		
		//double income = fq.getIncomeForForecast(6);
		String txClass = fq.getClassificationForForecast(5).trim().toLowerCase();
		double incomeAfterTax = tt.getTax(5, txClass.trim().toLowerCase());
		
		//------------------
		double expenses = ex.getExpenses(5);
		
		double moneyToForecast = Budget.getSpendingMoney(incomeAfterTax, expenses);
		
		double result = fc.forecast3m(moneyToForecast);
		
		return incomeAfterTax;
		
	}
	

}
