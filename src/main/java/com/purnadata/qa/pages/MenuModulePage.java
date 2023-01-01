package com.purnadata.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuModulePage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='sidebar-shortcuts']/following-sibling::ul/li/a[1]")
	private WebElement dashboardbutton;
	
	@FindBy(xpath="//div[@id='sidebar-shortcuts']/following-sibling::ul/li[2]/a")
	private WebElement menuButtonDropdown;
	
	@FindBy(xpath="//a[normalize-space()='Customer']")
	private WebElement dropdownDisplayConatinsCustomer;
	
	
	public MenuModulePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void dashboardButtonDisplay() {
		dashboardbutton.click();
	}
	
	public void menuButtonDropdownDisplay() {
		menuButtonDropdown.click();
	}

	public boolean dropdownContainsCustomerdisplay() {
		boolean customerdisplay = dropdownDisplayConatinsCustomer.isDisplayed();
		return customerdisplay;
	}
}
