package com.comcast.crm.ObjectRepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage  { // rule 1 create a separte java class
	// rule 2 object creation
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// this means current object reference(LoginPage)
	}

	@FindBy(id = "getLoginDetailsName")
	private WebElement usernameEdt;

	@FindBy(id = "getLoginDetailsEmail")
	private WebElement Email;

	@FindBy(id = "getLoginDetails")
	private WebElement Request;

	@FindBy(xpath="//a[@class=\"nav-link dropdown-toggle text-truncate\"]")
	private WebElement LogoutMenu;
	
	@FindBy(xpath="//a[text()=' Log Out']")
	private WebElement Logout;
	


	public WebElement getLogoutMenu() {
		return LogoutMenu;
	}

	public WebElement getLogout() {
		return Logout;
	}

	// rule 3 object initialization
	// rule 4 object encapsulation
	public WebElement getusernameEdt() {
		return usernameEdt;
	}

	public WebElement getpasswordEdt() {
		return Email;
	}

	public WebElement getloginBtn() {
		return Request;
	}
	


}
