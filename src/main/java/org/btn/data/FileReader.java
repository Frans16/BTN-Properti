package org.btn.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FileReader {
	
	NumberFormat nf = new DecimalFormat("#");
	
	public FileInputStream pathData() throws FileNotFoundException {
		String pathUrl = "src\\test\\data\\Test Data.xlsx";
		File src=new File(pathUrl);
		FileInputStream finput = new FileInputStream(src);
		
		return finput;
	}
	
	@SuppressWarnings("resource")
	public XSSFSheet readData() throws FileNotFoundException, IOException {
		XSSFWorkbook workbook;
		XSSFSheet sheet = null;
		workbook = new XSSFWorkbook(pathData());
		sheet = workbook.getSheet("Test Data");
		
		return sheet;
	}
	
	public String getTotalIncomePositive() throws FileNotFoundException, IOException {
		XSSFCell totalIncome = readData().getRow(1).getCell(1);
		return nf.format(totalIncome.getNumericCellValue());
	}
	
	public String getExpensePositive() throws FileNotFoundException, IOException {
		XSSFCell expense = readData().getRow(1).getCell(2);
		return nf.format(expense.getNumericCellValue());
	}
	
	public int getTerm() throws FileNotFoundException, IOException {
		XSSFCell expense = readData().getRow(1).getCell(3);
		return (int)expense.getNumericCellValue();
	}
	
	public String getTotalIncomeNegative() throws FileNotFoundException, IOException {
		XSSFCell totalIncome = readData().getRow(2).getCell(1);
		return nf.format(totalIncome.getNumericCellValue());
	}
	
	public String getExpenseNegative() throws FileNotFoundException, IOException {
		XSSFCell expense = readData().getRow(2).getCell(2);
		return nf.format(expense.getNumericCellValue());
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException {
		FileReader reader = new FileReader();
		System.out.println(reader.getTotalIncomePositive());
	}
}


