package com.cabcher.pricing;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Location_Category_Pricing_Obj{


		WebDriver driver;

		public Location_Category_Pricing_Obj(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="//input[@class=\"form-control\"]")
		 private List<WebElement> PickupDropoffupdate ;
		//a[contains(.,\"Fixed Pricing\")]

		public List<WebElement>  getPickupDropoffupdate() {
			return PickupDropoffupdate;
		}
		@FindBy(xpath="//a[text()='Location Category'] ")
		 private WebElement Location ;

		public WebElement getLocation() {
			return Location;
		}
		
		@FindBy(xpath="//button[text()='UPDATE']")
		 private WebElement Update ;

		public WebElement getUpdate() {
			return Update;
		}
		
		
	
	
}
