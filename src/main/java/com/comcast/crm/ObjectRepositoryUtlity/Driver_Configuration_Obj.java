package com.comcast.crm.ObjectRepositoryUtlity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  Driver_Configuration_Obj {

	WebDriver driver;

	public Driver_Configuration_Obj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	public WebDriver getDriver() {
		return driver;
	}
	@FindBy(xpath = "//a[text()='Config']")
	private WebElement DriverConfig;

	

	public WebElement getDriverConfig() {
		return DriverConfig;
	}

	public List<WebElement> getProfilePicture() {
		return ProfilePicture;
	}

	public List<WebElement> getAddress() {
		return Address;
	}

	public List<WebElement> getDOB() {
		return DOB;
	}

	public List<WebElement>  getNationality() {
		return Nationality;
	}

	public List<WebElement>  getTaxIDLabel() {
		return TaxIDLabel;
	}

	public WebElement getTaxIDRequired() {
		return TaxIDRequired;
	}

	public WebElement getTaxIDAttachmentsRequired() {
		return TaxIDAttachmentsRequired;
	}

	public WebElement getLicenseRequired() {
		return LicenseRequired;
	}

	public WebElement getLicenseExpiryRequired() {
		return LicenseExpiryRequired;
	}

	public WebElement getTaxiLicenseLabel() {
		return TaxiLicenseLabel;
	}

	public WebElement getLicenseAttachmentsRequired() {
		return LicenseAttachmentsRequired;
	}

	public WebElement getDriverTaxiLicenseRequired() {
		return driverTaxiLicenseRequired;
	}

	public WebElement getDriverTaxiLicenseExpiryRequired() {
		return driverTaxiLicenseExpiryRequired;
	}

	public WebElement getDriverTaxiLicenseAttachmentsRequired() {
		return driverTaxiLicenseAttachmentsRequired;
	}

	public WebElement getVehicleMakeRequired() {
		return vehicleMakeRequired;
	}

	@FindBy(id = "driverPicRequired")
	private List<WebElement> ProfilePicture;

	@FindBy(id = "addressRequired")
	private List<WebElement> Address;

	@FindBy(id = "dobRequired")
	private List<WebElement> DOB;

	@FindBy(id = "nationalityRequired")
	private List<WebElement>  Nationality;

	@FindBy(id = "driverTaxIDLabel")
	private List<WebElement>  TaxIDLabel;

	@FindBy(id = "driverTaxIDRequired")
	private WebElement TaxIDRequired;

	@FindBy(id = "driverTaxIDAttachmentsRequired")
	private WebElement TaxIDAttachmentsRequired;

	@FindBy(id = "driverLicenseRequired")
	private WebElement LicenseRequired;

	@FindBy(id = "driverLicenseExpiryRequired")
	private WebElement LicenseExpiryRequired;

	@FindBy(id = "driverTaxiLicenseLabel")
	private WebElement TaxiLicenseLabel;

	@FindBy(id = "driverLicenseAttachmentsRequired")
	private WebElement LicenseAttachmentsRequired;

	@FindBy(id = "driverTaxiLicenseRequired")
	private WebElement driverTaxiLicenseRequired;

	@FindBy(id = "driverTaxiLicenseExpiryRequired")
	private WebElement driverTaxiLicenseExpiryRequired;

	@FindBy(id = "driverTaxiLicenseAttachmentsRequired")
	private WebElement driverTaxiLicenseAttachmentsRequired;

	@FindBy(id = "vehicleMakeRequired")
	private WebElement vehicleMakeRequired;

}
