package com.comcast.crm.ObjectRepositoryUtlity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Driver_Register_Obj {

	WebDriver driver;

	public Driver_Register_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath =" //div[@class='x_panel']/descendant::input[@class='form-control']")
	private List<WebElement> Driverupdate;	
	
	@FindBy(id="vehicleTypesSelectAll")
	private WebElement vehicleTypesSelectAll;

	public List<WebElement>  getDriverupdate() {
		return Driverupdate;
	}

	public WebElement getVehicleTypesSelectAll() {
		return vehicleTypesSelectAll;
	}	
	@FindBy(xpath="//a[contains(.,' Drivers')]")
	private WebElement DriverDropdown;

	public WebElement getDriverDropdown() {
		return DriverDropdown;
	}
	@FindBy(xpath="//button[text()='UPDATE']")
	private WebElement UpdateButton;
	
	@FindBy(xpath="//a[@id='nav-pending-tab']")
	private WebElement Pending;  
	
	
	
	@FindBy(xpath="//i[@class=\"fa-solid fa-edit\"]")
	private List<WebElement>  ActivateDriver;  
	
	
	public List<WebElement> getActivateDriver() {
		return ActivateDriver;
	}

	@FindBy(xpath="//input[@class=\"form-control\"]")
	private WebElement  SearchBar;  
	
	@FindBy(id="driverStatus")
	private WebElement  DriverStatus;  
	
	@FindBy(xpath="//button[@id=\"sbtUpdate\"]")
	private WebElement  ActiveUpdateButton;  

	
	public WebElement getActiveUpdateButton() {
		return ActiveUpdateButton;
	}

	public WebElement getDriverStatus() {
		return DriverStatus;
	}

	public WebElement getSearchBar() {
		return SearchBar;
	}

	public WebElement getPending() {
		return Pending;
	}

	@FindBy(id="contactNumber")
	private  List<WebElement> Contact; 
	
	public List<WebElement> getContact() {
		return Contact;
	}

	public WebElement getUpdateButton() {
		return UpdateButton;
	}

	@FindBy(xpath="(//a[text()='List'])[2]")
	private WebElement List;

	public WebElement getList() {
		return List;
	}
	@FindBy(xpath="//a[text()='Add New']")
	private WebElement Addbuttton;

	public WebElement getAddbuttton() {
		return Addbuttton;
	}
	
}
