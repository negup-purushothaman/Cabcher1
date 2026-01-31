
	
package com.cabcher.pricing;

import java.util.List; // Correct import for List
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeterFareObj {

    WebDriver driver;

    // Constructor
    public MeterFareObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//form[@id='form']//input[@type='number']")
    private List<WebElement> carlist;
  
    @FindBy(xpath = "//select[@id=\"meterFareDistanceCategory\"]")
    private WebElement MeterFareDistance;
    
    public WebElement getMeterFareDistance() {
		return MeterFareDistance;
	}
    
    @FindBy(xpath="//select[@id=\"meterFareDistanceCategory\"]")
    private WebElement MeterGeneral;

	public WebElement getMeterGeneral() {
		return MeterGeneral;
	}

	// WebElements
    @FindBy(xpath = "//a[contains(text(),'Meter')]")
    private WebElement Meter;

    @FindBy(xpath="//span[text()='Add New']")
    private WebElement Add;

    @FindBy(id = "btnUpdate")
    private WebElement Update;
  
    // Getters
    public WebElement getMeter() {
        return Meter;
    }

    public WebElement getAdd() {
        return Add;
    }

    public WebElement getUpdate() {
        return Update;
    }

    public List<WebElement> getCarlist() {
        return carlist;
    }
}

