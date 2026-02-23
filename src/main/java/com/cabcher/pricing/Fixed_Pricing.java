package com.cabcher.pricing;





import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fixed_Pricing {
	WebDriver driver;

	public Fixed_Pricing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Fixed Pricing')]")
	 private WebElement  Fixed_pricing;
	//a[contains(.,\"Fixed Pricing\")]
	
	@FindBy(id="pickup")
	private WebElement Pickuplocation;
	
	@FindBy(id="dropoff")
	private WebElement DropOff;
	
	@FindBy(xpath="//span[text()=\"Customer\"]/../child::input")
	private List<WebElement> FixedCustomerPrice;
	
	@FindBy(id="btnUpdate")
	private WebElement Update;
	
	@FindBy(xpath="//span[text()=\"Driver\"]/../child::input")
	private List<WebElement>DriverPrice;
	
	@FindBy(id="time_slot")
	private  WebElement TimeSlot;
	
	

	public WebElement getTimeSlot() {
		return TimeSlot;
	}

	public List<WebElement> getDriverPrice() {
		return DriverPrice;
	}

	public void setDriverPrice(List<WebElement> driverPrice) {
		DriverPrice = driverPrice;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUpdate() {
		return Update;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFixed_pricing() {
		return Fixed_pricing;
	}

	public WebElement getPickuplocation() {
		return Pickuplocation;
	}

	public WebElement getDropOff() {
		return DropOff;
	}

	public List<WebElement> getFixedCustomerPrice() {
		return FixedCustomerPrice;
	}

	@FindBy(xpath="//div[@class=\"btn-group btn-group-sm\"]/descendant::i[@class=\"fa-solid fa-trash\"]")
	 private List<WebElement>  Delete;
	
	@FindBy(id="account_id")
	 private WebElement  AccountSelect;
	
	
	
	
	public WebElement getAccountSelect() {
		return AccountSelect;
	}

	public List<WebElement> getDelete() {
		return Delete;
	}

	@FindBy(xpath="//span[contains(.,'Add New')]")
	 private WebElement  AddButton;

	public WebElement getAddButton() {
		return AddButton;
	}
	//-------------Copy-Pricing-----------------------
	@FindBy(xpath="//label[text()='Time slot']/../descendant::select[@id=\"time_slot_copy_from\"]")
	 private WebElement  CopyPricingTimefrom;
    
	@FindBy(xpath="//select[@id=\"time_slot_copy_to\"]")
	 private WebElement  CopyPricingto;
   
	
	public WebElement CopyPricingTimefrom() {
		return CopyPricingTimefrom;
	}

	public WebElement getCopyPricingto() {
		return CopyPricingto;
	}
	
	
	//------------------------Account fixed pricing--------------------------
	
	@FindBy(xpath="//select[@id=\"account_id\"]")
	 private WebElement  AccountPrice;

	public WebElement getAccountPrice() {
		return AccountPrice;
	}
  
	

	
}
