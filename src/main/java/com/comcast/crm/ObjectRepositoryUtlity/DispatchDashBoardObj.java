	package com.comcast.crm.ObjectRepositoryUtlity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DispatchDashBoardObj {

	WebDriver driver;

	public DispatchDashBoardObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(.,'Dispatch')]/i ")
	private WebElement Dispatch;
	
	@FindBy(xpath="//td[contains(@class, 'reorder')]//div[@class='changeDriver' and @role='button']")
	private List<WebElement> driverassin;
	
  

	public List<WebElement> getDriverassin() {
		return driverassin;
	}

	@FindBy(xpath = "//i[@class='fa fa-ellipsis-h']")
	private List<WebElement> ThreeIcon;

	@FindBy(xpath = "//li[text()='Delete']")
	private WebElement Delete;

	public WebElement getDelete() {
		return Delete;
	}

	public List<WebElement> getThreeIcon() {
		return ThreeIcon;
	}

	@FindBy(id = "filterSearch")
	private WebElement filterSearch;

	public WebElement getDispatch() {
		return Dispatch;
	}

	public WebElement getFilterSearch() {
		return filterSearch;
	}

}
