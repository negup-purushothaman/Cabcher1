package com.comcast.crm.ObjectRepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Driver_Configuration {

	WebDriver driver;

	public Driver_Configuration(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "driverPicRequired")
	private WebElement ProfilePicture;
	
	@FindBy(id="addressRequired")
	private WebElement Address;

	@FindBy(id="dobRequired")
	private WebElement DOB; 

	
	
	
	@FindBy(id="nationalityRequired")
	private WebElement Nationality;
	
	@FindBy(id="driverTaxIDLabel")
	private WebElement TaxIDLabel;
    
	@FindBy(id="driverTaxIDRequired")
	private WebElement TaxIDRequired;
	
	@FindBy(id="driverTaxIDAttachmentsRequired")
	private WebElement TaxIDAttachmentsRequired;
	
	@FindBy(id="driverLicenseRequired")
	private WebElement LicenseRequired;
	
	
	
	@FindBy(id="driverLicenseExpiryRequired")
	private WebElement LicenseExpiryRequired;
	
	@FindBy(id="driverTaxiLicenseLabel")
	private WebElement TaxiLicenseLabel;
	

	@FindBy(id="driverLicenseAttachmentsRequired")
	private WebElement LicenseAttachmentsRequired;
	
	public WebElement getProfilePicture() {
		return ProfilePicture;
	}
		
	public WebElement getAddress() {
		return Address;
	}
	
	
}
