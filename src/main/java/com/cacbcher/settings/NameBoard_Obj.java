package com.cacbcher.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NameBoard_Obj {

	 private WebDriver driver;
	    public NameBoard_Obj(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    @FindBy(xpath="//a[contains(text(),'Settings')]")
	    private WebElement Settings;
	    
	    @FindBy(xpath="//a[text()='Name Board']")
	    private WebElement Nameboard;
	    

	    @FindBy(id="mergeCategorySelect2")
	    private WebElement Category;
	    
	    @FindBy( xpath="//select[@id=\"mergeCategoryFieldsSelect2\"]")
	    private WebElement Selectbooking;
	    

	    @FindBy( xpath="//ul[@class='select2-results__options']/li")
	    private WebElement GetElement;
	   
	    public WebElement getGetElement() {
			return GetElement;
		}

		public WebElement getSelectbooking() {
			return Selectbooking;
		}

		public WebElement getCategory() {
			return Category;
		}

		public WebElement getSettings() {
			return Settings;
		}

		public WebElement getNameboard() {
			return Nameboard;
		}
		
	  
	
}
