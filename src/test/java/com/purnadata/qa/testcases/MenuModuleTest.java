package com.purnadata.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purnadata.qa.base.Base;
import com.purnadata.qa.pages.LoginPage;
import com.purnadata.qa.pages.MenuCustomerPage;
import com.purnadata.qa.pages.MenuModulePage;
import com.purnadata.qa.utils.Utilities;

public class MenuModuleTest extends Base {
	
	public MenuModuleTest() {
		super();
	}
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("username"));
		loginPage.clickOnLoginButton();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifyMenuButtonContainsFiveModule() {
		MenuModulePage menuModulePage=new MenuModulePage(driver);
		menuModulePage.dashboardButtonDisplay();
		menuModulePage.menuButtonDropdownDisplay();
		Assert.assertTrue(menuModulePage.dropdownContainsCustomerdisplay());
		
	}
	
	@Test(priority=2)
	public void verifyToCreateNewCustomer()  {
		MenuModulePage menuModulePage=new MenuModulePage(driver);
		menuModulePage.dashboardButtonDisplay();
		menuModulePage.menuButtonDropdownDisplay();
		
		MenuCustomerPage menuCustomerPage = new MenuCustomerPage(driver);
		menuCustomerPage.customerDropdownMenuButton();
		menuCustomerPage.newCustomerButton();
		menuCustomerPage.customerNumberField1();
		menuCustomerPage.customerNumberField2(dataProp.getProperty("serialno"));
		menuCustomerPage.customerNameField(dataProp.getProperty("customername"));
		menuCustomerPage.contactNumberField(dataProp.getProperty("contactno"));
		menuCustomerPage.billingAddressField(dataProp.getProperty("billingadd"));
		menuCustomerPage.shippingAddressField(dataProp.getProperty("shippingadd"));
		menuCustomerPage.emailAddressField(dataProp.getProperty("emailadd"));
		menuCustomerPage.contactPersonField(dataProp.getProperty("contactperson"));
		menuCustomerPage.personContactNumberField(dataProp.getProperty("personnumber"));
		menuCustomerPage.gstNumberField(dataProp.getProperty("gstno"));
		menuCustomerPage.panNumberField(dataProp.getProperty("panno"));
		menuCustomerPage.venderCodeField(dataProp.getProperty("vendercode"));
		menuCustomerPage.saveButtonToSave();
	    Utilities.acceptAlert(driver);
		//Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Customer']")).isDisplayed());
	}
	
	@Test(priority=3)
	public void verifyToCreateNewSuppier() {
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//div[@id='sidebar-shortcuts']/following-sibling::ul/li/a[1]")).click();
		driver.findElement(By.xpath("//div[@id='sidebar-shortcuts']/following-sibling::ul/li[2]/a")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Supplier']")).click();
		driver.findElement(By.name("btn_new_party")).click();
		driver.findElement(By.id("sr_no")).clear();
		driver.findElement(By.id("sr_no")).sendKeys(dataProp.getProperty("serialno"));
		driver.findElement(By.id("supplier_name")).sendKeys(dataProp.getProperty("suppliername"));
		driver.findElement(By.id("contact_no")).sendKeys(dataProp.getProperty("contactno"));
		driver.findElement(By.id("address")).sendKeys(dataProp.getProperty("billingadd"));
		driver.findElement(By.id("email_id")).sendKeys(dataProp.getProperty("emailadd"));
		driver.findElement(By.id("contact_person")).sendKeys(dataProp.getProperty("contactperson"));
		driver.findElement(By.id("cont_no")).sendKeys(dataProp.getProperty("contactno"));
		driver.findElement(By.id("gst_no")).sendKeys(dataProp.getProperty("gstno"));
		driver.findElement(By.id("pan_no")).sendKeys(dataProp.getProperty("panno"));
		driver.findElement(By.id("bank_name")).sendKeys(dataProp.getProperty("bankname"));
		driver.findElement(By.id("bank_addr")).sendKeys(dataProp.getProperty("bankadd"));
		driver.findElement(By.id("account_no")).sendKeys(dataProp.getProperty("accno"));
		driver.findElement(By.id("ifsc_code")).sendKeys(dataProp.getProperty("ifsc"));
		driver.findElement(By.id("btn")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	
	@Test(priority=4)
	public void veriyAddNewItomInventory() {
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//div[@id='sidebar-shortcuts']/following-sibling::ul/li/a[1]")).click();
		driver.findElement(By.xpath("//div[@id='sidebar-shortcuts']/following-sibling::ul/li[2]/a")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Inventory']")).click();
		driver.findElement(By.name("btn_new_party")).click();
		driver.findElement(By.id("sr_no")).clear();
		driver.findElement(By.id("sr_no")).sendKeys(dataProp.getProperty("serialnum"));
		driver.findElement(By.id("itemcode")).sendKeys(dataProp.getProperty("itemcode"));
		driver.findElement(By.id("itemname")).sendKeys(dataProp.getProperty("itemname"));
		WebElement dropUnits = driver.findElement(By.name("units"));
		Select select = new Select(dropUnits);
		select.selectByVisibleText("KG");
		driver.findElement(By.id("supp_product_code")).sendKeys(dataProp.getProperty("suppproductcode"));
		driver.findElement(By.id("drawing_no")).sendKeys(dataProp.getProperty("drawingno"));
		driver.findElement(By.id("weight")).sendKeys(dataProp.getProperty("weight"));
		driver.findElement(By.id("packing")).sendKeys(dataProp.getProperty("packing"));
		driver.findElement(By.id("txt_rate")).sendKeys(dataProp.getProperty("rate"));
		driver.findElement(By.id("txt_discount")).sendKeys(dataProp.getProperty("discount"));
		driver.findElement(By.id("txt_qty")).sendKeys(dataProp.getProperty("quantity"));
		driver.findElement(By.id("txt_amount")).sendKeys(dataProp.getProperty("amount"));
		driver.findElement(By.name("submit")).click();
		
	}
	
	
	
	

}
