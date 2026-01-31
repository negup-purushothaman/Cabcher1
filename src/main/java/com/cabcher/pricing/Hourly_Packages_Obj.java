package com.cabcher.pricing;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hourly_Packages_Obj {
	WebDriver driver;

	public Hourly_Packages_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"modal-body\"]/descendant::input")
	private List<WebElement> CustomerPrice;

	public List<WebElement>  getCustomerPrice() {
		return CustomerPrice;
	}

	@FindBy(xpath = "//a[text()='Hourly Packages']")
	private WebElement HourlyPackages;
	@FindBy(xpath="//button[@id=\"primaryBtn\"]")
	private WebElement AddButton;


	public WebElement getAddButton() {
		return AddButton;
	}

	@FindBy(xpath = "//button[text()='Add New']")
	private WebElement AddNew;

	public WebElement getAddNew() {
		return AddNew;
	}

	public WebElement getHourlyPackages() {
		return HourlyPackages;
	}

}
