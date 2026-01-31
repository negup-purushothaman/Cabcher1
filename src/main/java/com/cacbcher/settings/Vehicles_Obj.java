package com.cacbcher.settings;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vehicles_Obj {
	private WebDriver driver;

	public Vehicles_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id=\"settings-menu\"]/descendant::a[text()='Vehicles']")
	private WebElement Vehicles;

	@FindBy(xpath ="//button[text()='Add New']")
	private WebElement AddNew;

	@FindBy(xpath = "//input[@id=\"txtPriority\"]")
	private List<WebElement> Priority;

	@FindBy(id = "txtVehicleName")
	private List<WebElement>  VechicleName; 
	
	@FindBy(id = "txtVehicleDesc")
	private List<WebElement>  Description;
	
	@FindBy(id = "txtPassengerCapacity")
	private List<WebElement>  passenger;
	
	@FindBy(id = "txtSmallLuggageCapacity")
	private List<WebElement>  SmallLuggageCapacity;
	
	@FindBy(id = "txtLargeLuggageCapacity")
	private List<WebElement>  LargeLuggageCapacity;

	@FindBy(id = "txtChildSeatCapacity")
	private List<WebElement>  ChildSeatCapacity;

	@FindBy(id = "txtAdvanceBookingFilterMinValue")
	private List<WebElement>  AdvanceBookingFilterMinValue;

	@FindBy(id = "txtAdvanceBookingFilterMaxValue")
	private List<WebElement>  AdvanceBookingFilterMaxValue;

	@FindBy(id = "distance_minimum")
	private List<WebElement>  Distance_minimum;

	@FindBy(id = "txtFareMinimum")
	private List<WebElement>  FareMinimum;

	public WebElement getVehicles() {
		return Vehicles;
	}

	public WebElement getAddNew() {
		return AddNew;
	}

	public List<WebElement>  getPriority() {
		return Priority;
	}

	public List<WebElement>  getVechicleName() {
		return VechicleName;
	}

	public List<WebElement>  getDescription() {
		return Description;
	}

	public List<WebElement>  getPassenger() {
		return passenger;
	}

	public List<WebElement>  getSmallLuggageCapacity() {
		return SmallLuggageCapacity;
	}

	public List<WebElement>  getLargeLuggageCapacity() {
		return LargeLuggageCapacity;
	}

	public List<WebElement>  getChildSeatCapacity() {
		return ChildSeatCapacity;
	}

	public List<WebElement>  getAdvanceBookingFilterMinValue() {
		return AdvanceBookingFilterMinValue;
	}

	public List<WebElement>  getAdvanceBookingFilterMaxValue() {
		return AdvanceBookingFilterMaxValue;
	}

	public List<WebElement>  getDistance_minimum() {
		return Distance_minimum;
	}

	public List<WebElement>  getFareMinimum() {
		return FareMinimum;
	}
	

	
}
