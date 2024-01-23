package org.btn.actions;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.btn.locators.CalculatePriceLoct;
import org.btn.util.HelperClass;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalculatePriceAct {
	CalculatePriceLoct calculatePriceLoct = new CalculatePriceLoct();
	NumberFormat nf = new DecimalFormat("#");
	
	public CalculatePriceAct() {
		this.calculatePriceLoct = new CalculatePriceLoct();
		PageFactory.initElements(HelperClass.getDriver(), calculatePriceLoct);
	}
	
	public void inputTotalIncome(String totalIncome) throws InterruptedException {
		Thread.sleep(1000);
		calculatePriceLoct.input_totalIncome.clear();
		calculatePriceLoct.input_totalIncome.sendKeys(totalIncome);
	}
	
	public void inputExpense(String expense) throws InterruptedException {
		Thread.sleep(1000);
		calculatePriceLoct.input_expense.clear();
		calculatePriceLoct.input_expense.sendKeys(expense);
	}
	
	public boolean verifyAnnotationPresent() {
		boolean annotationPresent = calculatePriceLoct.p_annotation.isDisplayed();
		System.out.println("Annotation present status :"+annotationPresent);
		System.out.println("The displayed text annotation: "+calculatePriceLoct.p_annotation.getText());
		return annotationPresent;
	}
	
	public void selectTerm(int term) throws InterruptedException {
		Thread.sleep(1000);
		Select dropDownTerm = new Select(calculatePriceLoct.select_term);
		dropDownTerm.selectByValue(Integer.toString(term));
	}
	
	public void clickCalculateButton() throws InterruptedException {
		Thread.sleep(1000);
		boolean buttonStatus = calculatePriceLoct.button_calculate.isEnabled();
		if(buttonStatus == true){
			System.out.println("Calculate button is enabled: "+buttonStatus);
			JavascriptExecutor js = (JavascriptExecutor)HelperClass.getDriver();
			try {
				calculatePriceLoct.button_calculate.click();
			} catch (Exception e) {
				js.executeScript("arguments[0].click()", calculatePriceLoct.button_calculate);
			}
		}else {
			System.out.println("Calculate button is enabled: "+buttonStatus);
		}
	}
	
	public void verifyPrice(double totalIncome, double expense, int term) throws InterruptedException {
		double maximumPrice = 0;
		maximumPrice = (totalIncome - expense) *((term*12)/3);
		
		Thread.sleep(2000);
		boolean totalPricePresent = calculatePriceLoct.div_price.isDisplayed();
		if(totalPricePresent == true) {
			System.out.println("Expected Price : "+nf.format(maximumPrice));
			System.out.println("Actual Price   : "+calculatePriceLoct.div_price.getText()
			.replace("Rp ", "")
			.replace(".", ""));
		Assert.assertEquals(nf.format(maximumPrice), calculatePriceLoct.div_price.getText()
					.replace("Rp ", "")
					.replace(".", ""));
		}else {
			System.out.println("Total price is not displayed");
		}
	}
}
