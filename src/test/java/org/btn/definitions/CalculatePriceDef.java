package org.btn.definitions;

import java.io.IOException;

import org.btn.actions.CalculatePriceAct;
import org.btn.data.FileReader;
import org.btn.util.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatePriceDef {
	
	CalculatePriceAct calculatePriceAct = new CalculatePriceAct();
	FileReader fileReader = new FileReader();
	
	//POSITIVE CASE
	@Given("the user is on the property price calculation page")
	public void the_user_is_on_the_property_price_calculation_page() {
	    HelperClass.openPage("https://www.btnproperti.co.id/tools/hitung-harga-properti");
	}
	@When("the user enters total income greater than expenses")
	public void the_user_enters_total_income_greater_than_expenses() throws InterruptedException, IOException {
		calculatePriceAct.inputTotalIncome(fileReader.getTotalIncomePositive());
	}
	@When("the user enters expenses smaller than total income")
	public void the_user_enters_expenses_smaller_than_total_income() throws InterruptedException, IOException {
		calculatePriceAct.inputExpense(fileReader.getExpensePositive());
	}
	@When("the user selects a time frame")
	public void the_user_selects_a_time_frame() throws InterruptedException, IOException {
		calculatePriceAct.selectTerm(fileReader.getTerm());
	}
	@When("the user presses the calculate button")
	public void the_user_presses_the_calculate_button() throws InterruptedException {
		calculatePriceAct.clickCalculateButton();
	}
	@When("the user verifies the displayed data with their own formula")
	public void the_user_verifies_the_displayed_data_with_their_own_formula() throws NumberFormatException, InterruptedException, IOException {
		calculatePriceAct.verifyPrice(Double.parseDouble(fileReader.getTotalIncomePositive()), 
	    		Double.parseDouble(fileReader.getExpensePositive()), fileReader.getTerm());
	}
	@Then("the user successfully calculates the maximum total property price")
	public void the_user_successfully_calculates_the_maximum_total_property_price() {
	    ;
	}
	
	//NEGATIVE CASE
	//Total income is smaller than expenses
	@When("the user enters total income smaller than expenses")
	public void the_user_enters_total_income_smaller_than_expenses() throws InterruptedException, IOException {
		calculatePriceAct.inputTotalIncome(fileReader.getTotalIncomeNegative());
	}
	@When("the user enters expenses greater than total income")
	public void the_user_enters_expenses_greater_than_total_income() throws InterruptedException, IOException {
		calculatePriceAct.inputExpense(fileReader.getExpenseNegative());

	}
	@Then("the system displays an alert, and the save button cannot be clicked")
	public void the_system_displays_an_alert_and_the_save_button_cannot_be_clicked() throws InterruptedException {
		calculatePriceAct.verifyAnnotationPresent();
	    calculatePriceAct.clickCalculateButton();
	}
	
	//NEGATIVE CASE
	//User leaves all data empty
	@When("the user does not fill in all the forms")
	public void the_user_does_not_fill_in_all_the_forms() {
	    ;
	}
	@Then("the save button cannot be clicked")
	public void the_save_button_cannot_be_clicked() throws InterruptedException {
		calculatePriceAct.clickCalculateButton();
	}
}
