package com.purnadata.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.purnadata.qa.base.Base;
import com.purnadata.qa.pages.DashboardPage;
import com.purnadata.qa.pages.LoginPage;
import com.purnadata.qa.utils.Utilities;


public class LoginTest extends Base {
	
	public LoginTest() {
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

	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String username,String password) {
	LoginPage loginPage= new LoginPage(driver);
	loginPage.enterUsername(username);
	loginPage.enterPassword(password);
	DashboardPage dashboardPage=loginPage.clickOnLoginButton();
	Assert.assertTrue(dashboardPage.getDisplayWelcomeAtRightCorner());
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		Object[][] data= Utilities.getTestDataFromExcel("LoginDataSheet");
		return data;
	}
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername(dataProp.getProperty("invalidusername"));
		loginPage.enterPassword(dataProp.getProperty("invalidpassword"));
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.warningMessageUsernameOrPasswordIncorrect());			
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidUsernameAndValidPassword() {
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername(dataProp.getProperty("invalidusername"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.warningMessageUsernameOrPasswordIncorrect());	
}
	@Test(priority=4)
	public void verifyLoginWithValidUsernameAndInvalidPassword() {
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(dataProp.getProperty("invalidpassword"));
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.warningMessageUsernameOrPasswordIncorrect());	
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutProvidingAnything() {
		LoginPage loginPage= new LoginPage(driver);
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.warningMessageUsernameOrPasswordIncorrect());		
	}	
}
