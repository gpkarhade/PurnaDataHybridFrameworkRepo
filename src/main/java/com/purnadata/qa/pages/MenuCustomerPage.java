package com.purnadata.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuCustomerPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Customer']")
	private WebElement customerDropdownMenu;
	
	@FindBy(name="btn_new_party")
	private WebElement newCustomer;
	
	@FindBy(id="sr_no")
	private WebElement customerNumber;
	
	@FindBy(id="customer_name")
	private WebElement customerName;

	@FindBy(id="contact_no")
	private WebElement contactNumber;
	
	@FindBy(id="billing_address")
	private WebElement billingAddress;
	
	@FindBy(id="shipping_address")
	private WebElement shippingAddress;
	
	@FindBy(id="email")
	private WebElement emailAddress;
	
	@FindBy(id="contact_person")
	private WebElement contactPerson;
	
	@FindBy(id="person_no")
	private WebElement personContactNumber;
	
	@FindBy(id="gst_no")
	private WebElement gstNumber;
	
	@FindBy(id="pan_no")
	private WebElement panNumber;
	
	@FindBy(id="vendor_code_no")
	private WebElement venderCode;
	
	@FindBy(id="btn")
	private WebElement saveButton;
	
	
	public MenuCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void customerDropdownMenuButton() {
		customerDropdownMenu.click();
	}
	
	public void newCustomerButton() {
		newCustomer.click();
	}
	
	public void customerNumberField1() {
		customerNumber.clear();
	}
	
	public void customerNumberField2(String customerNumberText) {
		customerNumber.sendKeys(customerNumberText);
	}
	
	public void customerNameField(String customerNameText) {
		customerName.sendKeys(customerNameText);
	}
	
	public void contactNumberField(String contactNumberText) {
		contactNumber.sendKeys(contactNumberText);
	}
	
	public void billingAddressField(String billingAddressText) {
		billingAddress.sendKeys(billingAddressText);
	}
	
	public void shippingAddressField(String shippingAddressText) {
		shippingAddress.sendKeys(shippingAddressText);
	}
	
	public void emailAddressField(String emailAddressText) {
		emailAddress.sendKeys(emailAddressText);
	}
	
	public void contactPersonField(String contactPersonText) {
		contactPerson.sendKeys(contactPersonText);
	}
	
	public void personContactNumberField(String personContactNumberText) {
		personContactNumber.sendKeys(personContactNumberText);
	}
	
	public void gstNumberField(String gstNumberText) {
		gstNumber.sendKeys(gstNumberText);
	}
	
	public void panNumberField(String panNumberText) {
		panNumber.sendKeys(panNumberText);
	}
	
	public void venderCodeField(String venderCodeText) {
		venderCode.sendKeys(venderCodeText);
	}
	
	public void saveButtonToSave() {
		saveButton.click();
	}
	
	
	

}
