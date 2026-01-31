package com.cabcher.pricing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingObj {

	WebDriver driver;

	public PricingObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Pricing') ]/i  ")
	private WebElement PricingButton;
	

	@FindBy(xpath = "//a[text()='General']")
	private WebElement General;
    
	@FindBy(id="priceDecimal")
	private WebElement PriceDecimals;
	
	
	@FindBy(id="txtAdditionalDropOffMinimumPrice")
	private WebElement DropOffMinimumPrice;
	
	
	@FindBy(id="txtChildSeatPrice")
	private WebElement ChildSeatPrice;


	@FindBy(id="journeyFareDistanceCategory")
	private WebElement journeyFare;

	@FindBy(id="meterFareDistanceCategory")
	private WebElement meterFareDistance;
	
	
	@FindBy(id="driverFareCategory")
	private WebElement driverFareCategory;
	
	@FindBy(id="selCardPaymentPriceType")
	private WebElement CardPaymentPriceType;
	
	
	@FindBy(id="txtCardPaymentPrice")
	private WebElement cardPricepercentage ;
	
	
	@FindBy(xpath="//button[text()='UPDATE']")
	private WebElement UpDate;
	
	public WebElement getPricing() {
		return PricingButton;
	}
	
	
	public WebElement getUpDate() {
		return UpDate;
	}


	public WebElement getCardPricepercentage() {
		return cardPricepercentage;
	}


	public WebElement getCardPaymentPriceType() {
		return CardPaymentPriceType;
	}


	public WebDriver getDriver() {
		return driver;
	}


	


	public WebElement getDropOffMinimumPrice() {
		return DropOffMinimumPrice;
	}

	public WebElement getChildSeatPrice() {
		return ChildSeatPrice;
	}

	public WebElement getJourneyFare() {
		return journeyFare;
	}

	public WebElement getMeterFareDistance() {
		return meterFareDistance;
	}

	public WebElement getDriverFareCategory() {
		return driverFareCategory;
	}

	public WebElement getGeneral() {

		return General;
	}

	public WebElement getPriceDecimals() {
		return PriceDecimals;
	}
	
	

	
}
