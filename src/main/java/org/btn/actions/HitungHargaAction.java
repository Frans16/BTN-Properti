package org.btn.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.btn.locators.HitungHargaLocator;
import org.btn.util.HelperClass;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HitungHargaAction {
	HitungHargaLocator hitungHargaLoct = new HitungHargaLocator();
	NumberFormat nf = new DecimalFormat("#");
	
	public HitungHargaAction() {
		this.hitungHargaLoct = new HitungHargaLocator();
		PageFactory.initElements(HelperClass.getDriver(), hitungHargaLoct);
	}
	
	public void inputPenghasilanTotal(String penghasilanTotal) {
		hitungHargaLoct.input_penghasilanTotal.clear();
		hitungHargaLoct.input_penghasilanTotal.sendKeys(penghasilanTotal);
	}
	
	public void inputPengeluaran(String pengeluaran) {
		hitungHargaLoct.input_pengeluaran.clear();
		hitungHargaLoct.input_pengeluaran.sendKeys(pengeluaran);
	}
	
	public void selectJangkaWaktu(int jangkaWaktu) {
		Select drpJangkaWatu = new Select(hitungHargaLoct.select_waktu);
		drpJangkaWatu.selectByValue(Integer.toString(jangkaWaktu));
	}
	
	public void clickHitung() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)HelperClass.getDriver();
		try {
			hitungHargaLoct.button_hitung.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click()", hitungHargaLoct.button_hitung);
		}
	}
	
	public void verifyHarga(double penghasilanTotal, double pengeluaran, int jangkaWaktu) throws InterruptedException {
		double hargaMaksimal = 0;
		hargaMaksimal = (penghasilanTotal - pengeluaran) *((jangkaWaktu*12)/3);
		
		Thread.sleep(2000);
		Assert.assertEquals(nf.format(hargaMaksimal), hitungHargaLoct.div_hasilHarga.getText().replace("Rp ", "").replace(".", ""));
	}
	
	public void inputValidHitungHargaForm() throws IOException, InterruptedException {
		String pathUrl = "src\\test\\testData\\testData.xlsx";
		
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		
		File src=new File(pathUrl);
		FileInputStream finput = new FileInputStream(src);
		workbook = new XSSFWorkbook(finput);
		
		sheet = workbook.getSheet("positive");
		
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			XSSFCell penghasilanTotal = sheet.getRow(i).getCell(1);
			XSSFCell pengeluaran	  = sheet.getRow(i).getCell(2);
			XSSFCell jangkaWaktu	  = sheet.getRow(i).getCell(3);
			
			inputPenghasilanTotal(nf.format(penghasilanTotal.getNumericCellValue()));
			inputPengeluaran(nf.format(pengeluaran.getNumericCellValue()));
			selectJangkaWaktu((int)jangkaWaktu.getNumericCellValue());
			clickHitung();
			
			verifyHarga(penghasilanTotal.getNumericCellValue(), pengeluaran.getNumericCellValue(), (int)jangkaWaktu.getNumericCellValue());
		}
		finput.close();
		workbook.close();
	}
	
	public void inputInvalidHitungHargaForm() throws IOException, InterruptedException {
		String pathUrl = "src\\test\\testData\\testData.xlsx";
		
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		
		File src=new File(pathUrl);
		FileInputStream finput = new FileInputStream(src);
		workbook = new XSSFWorkbook(finput);
		
		sheet = workbook.getSheet("negative");
		
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			XSSFCell penghasilanTotal = sheet.getRow(i).getCell(1);
			XSSFCell pengeluaran	  = sheet.getRow(i).getCell(2);
			XSSFCell jangkaWaktu	  = sheet.getRow(i).getCell(3);
			
			inputPenghasilanTotal(nf.format(penghasilanTotal.getNumericCellValue()));
			inputPengeluaran(nf.format(pengeluaran.getNumericCellValue()));
			selectJangkaWaktu((int)jangkaWaktu.getNumericCellValue());
			boolean annotationDisplay = hitungHargaLoct.p_annotation.isDisplayed();
			
			Assert.assertEquals(true, annotationDisplay);
			
			HelperClass.getDriver().navigate().refresh();
		}
		finput.close();
		workbook.close();
	}
}
