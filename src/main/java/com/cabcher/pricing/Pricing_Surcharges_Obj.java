package com.cabcher.pricing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pricing_Surcharges_Obj {

	WebDriver driver;

	public Pricing_Surcharges_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Surcharges']")
	private WebElement Surcharges;

	public WebElement getSurcharges() {
		return Surcharges;
	}

	@FindBy(xpath = "//select[@id=\"selRecurring\"]")
	private WebElement DropDownRecurring;
	
	public WebElement getDropDownRecurring() {
		return DropDownRecurring;
	}
	
	@FindBy(xpath="//table[@class=\"table-condensed\"]/tr/td/span")
	private WebElement FromPeriod;
	
	@FindBy(xpath="//input[@id=\"txtDateTo\"]")
	private WebElement ToPeriod;

	public WebElement getFromPeriod() {
		return FromPeriod;
	}

	public WebElement getToPeriod() {
		return ToPeriod;
	}

	
}
