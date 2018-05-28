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
	
	double result;
	
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
					resultField.setText(""+getForecastResult(3));
				}else if(sixMonthBtn.isSelected()) {
					resultField.setText(""+getForecastResult(6));
				}else if(oneYearBtn.isSelected()) {
					resultField.setText(""+getForecastResult(12));
				}else if(threeYearBtn.isSelected()) {
					resultField.setText(""+getForecastResult(36));
				}else if(fiveYearBtn.isSelected()) {
					resultField.setText(""+getForecastResult(60));
				}
				
			}
			
		});
		
		
	}
	
	private double getForecastResult(int forecastType) {
		
		ForecastQuery fq = new ForecastQuery();
		TaxTotal tt = new TaxTotal();
		Expenses ex = new Expenses();
		Forecast fc = new Forecast();
		
		int txClass = fq.getClassificationForForecast(2);
		double incomeAfterTax = tt.getTax(2, txClass);
	
		double expenses = ex.getExpenses(2);
		
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
