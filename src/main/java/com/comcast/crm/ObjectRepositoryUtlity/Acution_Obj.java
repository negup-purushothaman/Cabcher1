package com.comcast.crm.ObjectRepositoryUtlity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Acution_Obj {

	private WebDriver driver;

	public Acution_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ======= LOCATORS =======
	@FindBy(xpath = "//a[contains(text(),' Auction')]")
	private WebElement Auction;

	public WebElement getAuction() {
		return Auction;
	}

	@FindBy(id = "title")
	private List<WebElement> Title;

	@FindBy(id = "details")
	private List<WebElement> Details;

	@FindBy(id = "attempts")
	private List<WebElement> Attempts;

	@FindBy(id = "max_amount")
	private List<WebElement> MaxAmount;

	@FindBy(id = "min_bid_difference")
	private List<WebElement> Min_bid_difference;

	@FindBy(xpath = "//button[text()='Select All']")
	private WebElement SelectAll;

	public WebElement getSelectAll() {
		return SelectAll;
	}

	@FindBy(xpath = "//button[contains(@class,\"btn dropdown-toggle bs\")]")
	private WebElement Biddres;
	
	@FindBy(xpath = "//button[@class=\"btn dropdown-toggle btn-light border\"]")
	private WebElement EditBiddres;
	
	
	
	public WebElement getEditBiddres() {
		return EditBiddres;
	}

	@FindBy(xpath = "//input[@id=\"expiry\"]")
	private WebElement Expiry;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement Addbutton;

	
	@FindBy(id = "bid_amount_decimal")
	private WebElement Allow_decimals_in_bid;


	@FindBy(xpath="//a[@data-action=\"clear\"]")
	private WebElement DateDelete;


	@FindBy(xpath="//button[text()='Update']")
	private WebElement Update;
	
	
	
	public WebElement getUpdate() {
		return Update;
	}

	public WebElement getDateDelete() {
		return DateDelete;
	}

	@FindBy(xpath="//span[@class=\"btn btn-outline-secondary actionSelected\"]")
	private List<WebElement> EditOption;
	
	
	
	public List<WebElement> getEditOption() {
		return EditOption;
	}

	public WebElement getAllow_decimals_in_bid() {
		return Allow_decimals_in_bid;
	}

	public WebElement getAddbutton() {
		return Addbutton;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getTitle() {
		return Title;
	}

	public List<WebElement> getDetails() {
		return Details;
	}

	public List<WebElement> getAttempts() {
		return Attempts;
	}

	public List<WebElement> getMaxAmount() {
		return MaxAmount;
	}

	public List<WebElement> getMin_bid_difference() {
		return Min_bid_difference;
	}

	public WebElement getBiddres() {
		return Biddres;
	}

	public WebElement getExpiry() {
		return Expiry;
	}
	
	//span[@class="btn btn-outline-secondary actionSelected"]

}
