package com.comcast.crm.ObjectRepositoryUtlity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accounts_Obj {

	private WebDriver driver;

	public Accounts_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ======= LOCATORS =======
	@FindBy(xpath = "//a[text()=' Accounts']")
	private WebElement Accounts;

	@FindBy(xpath = "//a[text()='Add New']")
	private WebElement AddNew;

	@FindBy(xpath = "//input[@required=\"required\"]")
	private List<WebElement> UpdateData;

	@FindBy(xpath = "//input[@name=\"invoiceDueDaysDefault\"]")
	private List<WebElement> Invoice;

	@FindBy(xpath = "//button[contains(@class,\"btn dropdown-toggle bs-placeholder btn-light\")]")
	private WebElement PyamentSelect;

	@FindBy(xpath = "//div[@class=\"dropdown-menu show\"]/div/div/button[text()='Select All']")
	private WebElement SelectAll;

	@FindBy(xpath = "//label[contains(.,\"Primary Contact Name \")]")
	private WebElement payment;

	@FindBy(xpath = "//button[text()='UPDATE']")
	private WebElement UpdateButton;

	@FindBy(xpath = " //input[@id=\"contactNumber\"]")
	private WebElement Contactnumber;

	@FindBy(xpath = " //input[@name=\"accountName\"]")
	private WebElement AccountName;

	@FindBy(id = "accountEmail")
	private WebElement AccountEmail;

	@FindBy(xpath = " //input[@name=\"accountPrimaryContactName\"]")
	private WebElement AccountPrimary;

	@FindBy(xpath = "  //input[@name=\"accountPrimaryContactDesignation\"]")
	private WebElement AccountPrimaryContact;

	@FindBy(xpath = "//input[@name=\"invoiceDueDaysDefault\"]")
	private WebElement InvoiceDueDays;

	@FindBy(xpath = "//div[@id=\"nav-tab\"]/a[contains(.,'Pending')][1]")
	private WebElement Pending;

	@FindBy(xpath = "//i[@class=\"fa-solid fa-edit\"] ")
	private WebElement Edit;

	@FindBy(xpath="//select[@id=\"accountStatus\"]")
	private WebElement Active;
	
	
	
	public WebElement getActive() {
		return Active;
	}

	public WebElement getEdit() {
		return Edit;
	}

	public WebElement getVerifed() {
		return Pending;
	}

	public WebElement getInvoiceDueDays() {
		return InvoiceDueDays;
	}

	public WebElement getAccountPrimaryContact() {
		return AccountPrimaryContact;
	}

	public WebElement getAccountPrimary() {
		return AccountPrimary;
	}

	public WebElement getAccountEmail() {
		return AccountEmail;
	}

	public WebElement getAccountName() {
		return AccountName;
	}

	public WebElement getContactnumber() {
		return Contactnumber;
	}

	public WebElement getUpdateButton() {
		return UpdateButton;
	}

	public WebElement getPayment() {
		return payment;
	}

	public WebElement getSelectAll() {
		return SelectAll;
	}

	public WebElement getPyamentSelect() {
		return PyamentSelect;
	}

	public List<WebElement> getInvoice() {
		return Invoice;
	}

	public List<WebElement> getUpdateData() {
		return UpdateData;
	}

	public WebElement getAddNew() {
		return AddNew;
	}

	public WebElement getAccounts() {
		return Accounts;
	}

}
