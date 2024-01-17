package org.btn.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HitungHargaLocator {
	
	@FindBy(xpath = "//input[@placeholder='Penghasilan Total']")
	public WebElement input_penghasilanTotal;

	@FindBy(xpath = "//input[@placeholder='Pengeluaran']")
	public WebElement input_pengeluaran;
	
	@FindBy(xpath = "//select[@id='waktu']")
	public WebElement select_waktu;
	
	@FindBy(xpath = "//div[@id='hitung_harga_button']/button")
	public WebElement button_hitung;
	
	@FindBy(xpath = "//div[@id='harga_hasil']/h3")
	public WebElement div_hasilHarga;
	
	@FindBy(xpath = "//p[text()='Isi kurang dari nilai sebelumnya']")
	public WebElement p_annotation;

}
