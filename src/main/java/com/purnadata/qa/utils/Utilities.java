package com.purnadata.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=10;
	
	public static void syncElement(WebDriver driver, WebElement element, String conditionForWait) {
		
		switch(conditionForWait) {
		case "ToClickable":
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));
			break;
		case "ToVisible":
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
			break;
		case "isAlertPresent":
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
			break;
		}
	}
	
	public static void acceptAlert(WebDriver driver) {
		syncElement(driver,null,"isAlertPresent");
		driver.switchTo().alert().accept();	
	}
	
	public static void dismissAlert(WebDriver driver) {
		syncElement(driver,null,"isAlertPresent");
		driver.switchTo().alert().dismiss();
	}
	
	public static void toClickableExplicitWaitElement(WebDriver driver, WebElement element) {
		syncElement(driver,element,"ToClickable");
		element.click();
		
	}
	
	public static void toVisibleExplicitWaitElement(WebDriver driver, WebElement element) {
		syncElement(driver,element,"ToVisible");
		element.isDisplayed();
	}
	
	public static Object[][] getTestDataFromExcel(String sheetName) {
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\purnadata\\qa\\testdata\\PurnaDataTestData.xlsx");
		XSSFWorkbook workbook = null;
		try {
		FileInputStream fisExcel = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fisExcel);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][cols];
		for(int i=0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0; j<cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				default:
					break;	
				}	
			}
		}
		return data;
	}
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;
	}
	
	
	
	
	
	
	
	
	
	
				
}
	
	


