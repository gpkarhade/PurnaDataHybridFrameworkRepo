package com.purnadata.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="username")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(name="submit")
	private WebElement loginButton;
	
	@FindBy(xpath="//h3[text()='Username/password is incorrect.']")
	private WebElement usernameOrpasswordIncorrect;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//ActionMethods
	
	public void enterUsername(String usernameText) {
		usernameField.sendKeys(usernameText);	
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public DashboardPage clickOnLoginButton() {
		loginButton.click();
		return new DashboardPage(driver);
		
	}
	
	public boolean warningMessageUsernameOrPasswordIncorrect() {
		boolean incorectUsrenameOrPass = usernameOrpasswordIncorrect.isDisplayed();
		return incorectUsrenameOrPass;
	}
	    
	
	
}
