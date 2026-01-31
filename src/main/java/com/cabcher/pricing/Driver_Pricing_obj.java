package com.cabcher.pricing;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Driver_Pricing_obj {

	WebDriver driver;

	public Driver_Pricing_obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@id=\"driverFareCategory\"]")
	 private WebElement  DriverFare;
     
	@FindBy(xpath="//input[@class=\"form-control modalDataInputElem\"]")
	 private WebElement  CustomPrice;
	
	@FindBy(xpath="//a[text()='Driver']")
	 private WebElement  DriverModule;
	
	public WebElement getDriverModule() {
		return DriverModule;
	}


	public WebElement getCustomPrice() {
		return CustomPrice;
	}


	public WebElement getDriverFare() {
		return DriverFare;
	}
	
	
	@FindBy(id = "modalData")
	private WebElement modal;

	public WebElement getModal() {
	    return modal;
	}
	
	@FindBy(xpath = "//div[@class=\"col-md-6 col-sm-12\"]")
	private List<WebElement> Drivercustomerprice;

	public List<WebElement> Drivercustomerprice() {
		return Drivercustomerprice;
	}
	
	
	
	
}
