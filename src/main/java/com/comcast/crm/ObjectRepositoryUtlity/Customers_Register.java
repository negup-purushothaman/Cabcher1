package com.comcast.crm.ObjectRepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customers_Register {

    private WebDriver driver;
    public Customers_Register(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ======= LOCATORS =======
    @FindBy(xpath="(//a[contains(.,'Customers')])[1]")
    private WebElement CustomerRegister;

    public WebElement getCustomerRegister() {
		return CustomerRegister;
	}

	@FindBy(xpath = "//input[@name='txtAdminEmail']")
    private WebElement EmailAddress;

	@FindBy(id="contact")
    private WebElement contact;
	

	public WebElement getContact() {
		return contact;
	}

	@FindBy(id="name")
    private WebElement CustomerName;
	

	@FindBy(id="email")
    private WebElement CustomerEmail;
	
	public WebElement getCustomerName() {
		return CustomerName;
	}

	public WebElement getCustomerEmail() {
		return CustomerEmail;
	}
	@FindBy(id="primaryBtn")
    private WebElement Add;
	
	@FindBy(id="status")
    private WebElement CustomerStatus;
	
	
	public WebElement getCustomerStatus() {
		return CustomerStatus;
	}

	public WebElement getAdd() {
		return Add;
	}
	@FindBy(xpath="	//i[@class=\"fa-solid fa-trash\"]")
    private WebElement DeleteCustomer;
	
	@FindBy(xpath="//input[@placeholder=\"Search\"]")
    private WebElement Searchbar;
	
	@FindBy(xpath="//button[text()='Confirm']")
    private WebElement Confrim;
	
   
	public WebElement getConfrim() {
		return Confrim;
	}

	public WebElement getSearchbar() {
		return Searchbar;
	}

	public WebElement getDeleteCustomer() {
		return DeleteCustomer;
	}

	

}
