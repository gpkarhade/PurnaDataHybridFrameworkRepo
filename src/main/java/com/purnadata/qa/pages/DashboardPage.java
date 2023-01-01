package com.purnadata.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	@FindBy(className="user-info")
	private WebElement welcomeAtRightCorner;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean getDisplayWelcomeAtRightCorner() {
		boolean display = welcomeAtRightCorner.isDisplayed();
		return display;
	}
	

}
