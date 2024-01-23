package org.btn.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatePriceLoct {
	
	@FindBy(xpath = "//input[@placeholder='Penghasilan Total']")
	public WebElement input_totalIncome;

	@FindBy(xpath = "//input[@placeholder='Pengeluaran']")
	public WebElement input_expense;
	
	@FindBy(xpath = "//select[@id='waktu']")
	public WebElement select_term;
	
	@FindBy(xpath = "//div[@id='hitung_harga_button']/button")
	public WebElement button_calculate;
	
	@FindBy(xpath = "//div[@id='harga_hasil']/h3")
	public WebElement div_price;
	
	@FindBy(xpath = "//p[text()='Isi kurang dari nilai sebelumnya']")
	public WebElement p_annotation;

}
