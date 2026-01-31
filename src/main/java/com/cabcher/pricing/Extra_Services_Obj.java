package com.cabcher.pricing;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Extra_Services_Obj {

	WebDriver driver;

	public Extra_Services_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Extra Services']")
	 private WebElement  ExtraServices;

	public WebElement getExtraServices() {
		return ExtraServices;
	}
     
	@FindBy(xpath="//div[@class=\"modal-body\"]/descendant::input[@class=\"form-control\"]")
	 private WebElement  CustomPrice;

	public WebElement getCustomPrice() {
		return CustomPrice;
	}
	@FindBy(id="primaryBtn")
	 private WebElement  Add;

	public WebElement getAdd() {
		return Add;
	}
	
	@FindBy(xpath="//div[@class=\"modal-body\"]/descendant::input")
	 private List<WebElement>  CustomPriceYES;

	public List<WebElement> getCustomPriceYES() {
		return CustomPriceYES;
	}
	@FindBy(xpath="//select[@id=\"customPrice\"]")
	 private WebElement  CustomPriceSelect;

	public WebElement getCustomPriceSelect() {
		return CustomPriceSelect;
	}
	
	
	
}
