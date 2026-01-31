package com.comcast.crm.ObjectRepositoryUtlity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeterFareGeneralsetting {

	

	WebDriver driver;

	public MeterFareGeneralsetting(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//span[@class=\"float-end pricing-settings\"]")
	private WebElement Settings;
	
	public WebElement getSettings() {
		
		return Settings;
		
	}
	
	@FindBy(xpath="//div[@id=\"modalSettings\"]/descendant::div[@class=\"modal-body\"]/descendant::input")
	private List<WebElement> MeterFaresetting;

	public List<WebElement> getMeterFaresetting() {
		return MeterFaresetting;
	}

	
	
}
