package com.cabcher.pricing;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Distance_pricing_Obj {

	WebDriver driver;

	public Distance_pricing_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='General']")
	private WebElement GeneralPricing;

	@FindBy(xpath = "//a[text()='Distance']")
	private WebElement Distance;

	public WebElement getDistance() {
		return Distance;
	}

	public WebElement getGeneralPricing() {
		return GeneralPricing;
	}

	@FindBy(xpath = "//button[@name=\"sbtUpdate\"]")
	private WebElement Update;

	public WebElement getUpdate() {
		return Update;
	}

	@FindBy(xpath = "//input[@class=\"form-control modalDataInputElem\"]")
	private List<WebElement> customprice;

	public List<WebElement> getcustomprice() {
		return customprice;
	}

	// input[@class="form-control modalDataInputElem"]
	@FindBy(xpath = "//select[@id=\"journeyFareDistanceCategory\"]")
	private WebElement JourneyFare;

	public WebElement getJourneyFare() {
		return JourneyFare;
	}

}
