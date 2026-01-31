package com.cabcher.pricing;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pricing_Discounts_Obj {

	WebDriver driver;

	public Pricing_Discounts_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"modal-body\"]/descendant::input ")
	private List<WebElement> DiscountPricingUpdate;

	public List<WebElement> getDiscountPricingUpdate() {
		return DiscountPricingUpdate;
	}

	@FindBy(xpath="//input[@id=\"txtDateFrom\"]")
	private List<WebElement> DateSelectionFROM;

	public List<WebElement> getDateSelectionFROM() {
		return DateSelectionFROM;
	}

	public List<WebElement> getDateSelectionTO() {
		return DateSelectionTO;
	}

	@FindBy(xpath="//input[@id=\"txtDateTo\"]")
	private List<WebElement> DateSelectionTO;
	
	
	@FindBy(xpath = "//a[text()='Discounts']")
	private WebElement Discount;

	public WebElement getDiscount() {
		return Discount;
	}

	@FindBy(xpath = "//div[@class=\"modal-body\"]/descendant::textarea")
	private List<WebElement> TextAreaLoactionUpdate;

	public List<WebElement> getTextAreaLoactionUpdate() {
		return TextAreaLoactionUpdate;
	}

	public List<WebElement> getCustomerPriceUpdate() {
		return CustomerPriceUpdate;
	}

	@FindBy(xpath = "//div[@class=\"modal-body\"]/descendant::input[@class=\"form-control\"]")
	private List<WebElement> CustomerPriceUpdate;
	
	@FindBy(xpath="//button[text()='Add New']")
	private WebElement  Addbuttton;

	public WebElement getAddbuttton() {
		return Addbuttton;
	}
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement CompleteAddButton;

	public WebElement getCompleteAddButton() {
		return CompleteAddButton;
	}
	

}
