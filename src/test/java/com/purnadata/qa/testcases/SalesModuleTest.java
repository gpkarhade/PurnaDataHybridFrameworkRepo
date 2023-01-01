package com.purnadata.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purnadata.qa.base.Base;

public class SalesModuleTest extends Base {
	
	public SalesModuleTest() {
		super();
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySalesModuleDisplayFourModule() {
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Sales']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Sales Invoice']")).isDisplayed());
	}
	
	@Test(priority=2)
	public void verifySalesInvoiceNevigateToDetailsPage() {
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Sales']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header']/child::h4")).isDisplayed());
	}
	
	

}
