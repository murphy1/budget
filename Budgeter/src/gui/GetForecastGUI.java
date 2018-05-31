package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import database.ForecastQuery;
import model.Budget;
import model.Expenses;
import model.Forecast;
import tax.TaxTotal;

public class GetForecastGUI extends JFrame{
	
	private JLabel topLabel;
	
	private JTextField accNum;
	
	private JRadioButton threeMonthBtn;
	private JRadioButton sixMonthBtn;
	private JRadioButton oneYearBtn;
	private JRadioButton threeYearBtn;
	private JRadioButton fiveYearBtn;
	private JButton submitBtn;
	private JTextField resultField;
	
	double result;
	
	public GetForecastGUI(){
		
		setLayout(new FlowLayout());
		
		topLabel = new JLabel();
		
		accNum = new JTextField("account number");
		
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
		
		add(accNum);
		
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
				
				int accountIdNum = Integer.parseInt(accNum.getText());
				
				if(threeMonthBtn.isSelected()) {
					resultField.setText(""+getForecastResult(accountIdNum, 3));
				}else if(sixMonthBtn.isSelected()) {
					resultField.setText(""+getForecastResult(accountIdNum, 6));
				}else if(oneYearBtn.isSelected()) {
					resultField.setText(""+getForecastResult(accountIdNum, 12));
				}else if(threeYearBtn.isSelected()) {
					resultField.setText(""+getForecastResult(accountIdNum, 36));
				}else if(fiveYearBtn.isSelected()) {
					resultField.setText(""+getForecastResult(accountIdNum, 60));
				}
				
			}
			
		});
		
		
	}
	
	private double getForecastResult(int accountNumber, int forecastType) {
		
		ForecastQuery fq = new ForecastQuery();
		TaxTotal tt = new TaxTotal();
		Expenses ex = new Expenses();
		Forecast fc = new Forecast();
		
		int txClass = fq.getClassificationForForecast(accountNumber);
		double incomeAfterTax = tt.getTax(accountNumber, txClass);
	
		double expenses = ex.getExpenses(accountNumber);
		
		double moneyToForecast = Budget.getSpendingMoney(incomeAfterTax, expenses);
		
		
		if(forecastType == 3) {
			result = fc.forecast3m(moneyToForecast);
		}else if(forecastType == 6) {
			result = fc.forecast6m(moneyToForecast);
		}else if(forecastType == 12) {
			result = fc.forecast1y(moneyToForecast);
		}else if(forecastType == 36) {
			result = fc.forecast3y(moneyToForecast);
		}else if(forecastType == 60) {
			result = fc.forecast5y(moneyToForecast);
		}
		
		
		
		
		return result;
		
	}
	

}
