package com.comcast.crm.ObjectRepositoryUtlity;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Genericlabaries.JavaUtility;

public class NewBookingObj {

	WebDriver driver;

	String Futuredate = "";
	public NewBookingObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "allow-push-notification")
	private WebElement DesktopNotification;

	@FindBy(xpath = "//a[contains(text(),' New Booking')]")
	private WebElement newbooking;

	@FindBy(id = "txtPickUp1Location")
	private WebElement pickupClick;

	@FindBy(xpath="//ul[@unselectable=\"on\"]/li")
	private List<WebElement> Pickup;
	@FindBy(id = "txtDropOff1Location")
	private WebElement dropoffClick;

	@FindBy	(xpath="//ul[contains(@class,\"ui-widget-content ui-autocomplete \")]/li")
	private  List<WebElement>  dropoff;

	//li[@class="ui-menu-item"]
	@FindBy(xpath = "//input[@name=\"pickUpFields1['flightno']\"]")
	private WebElement FlightNo;

	@FindBy(xpath = "//input[@name=\"pickUpFields1['arrivingfrom']\"]")
	private WebElement ArrivingFrom;

	@FindBy(xpath = "//select[@name=\"pickUpFields1['pickmeafter']\"]")
	private WebElement pickUpMeAfter;

	@FindBy(xpath = "//input[@name=\"dropFields1['terminal']\"]")
	private WebElement Terminal;

	@FindBy(id = "customerID")
	private WebElement Selectcustomer;

	@FindBy(id = "passengerCapacity")
	private WebElement passenger;
	@FindBy(id = "smallLuggageCapacity")
	private WebElement HandLuggage;

	@FindBy(id = "largeLuggageCapacity")
	private WebElement CheckInLuggage;

	@FindBy(id = "driverFareDashboard")
	private WebElement driverFare;

	@FindBy(xpath = "//input[@id='paxName']")
	private WebElement Name;

	@FindBy(id = "btnBook2")
	private WebElement submit;

	@FindBy(id = "paxName")
	private WebElement CustomerName;

	@FindBy(id = "paxEmail")
	private WebElement Email;

	@FindBy(id = "contactNumber")
	private WebElement contactNumber;

	@FindBy(id = "customerCategoryAccount")
	private WebElement customerCategoryAccount;
	
	@FindBy(id="select2-accountID-container")
	private WebElement AccountNameDropDown;

	@FindBy(xpath="//input[@class=\"select2-search__field\"]")
	private WebElement AccountEnterName;
	
	//ul[@id="select2-customerID-results"]/li
	
	@FindBy(xpath="//span[@class=\"select2-dropdown select2-dropdown--above\"]/descendant::ul/li/span")
	private List<WebElement> SelectAccountName;
	
	@FindBy(xpath="//input[@value=\"Invoice\"]")
	private WebElement Invoice;
	
	@FindBy(xpath="//label[contains(text(),\"Create & activate (without email)\")] ")
	private WebElement Createactivatewithoutemail;
	
	
	@FindBy(xpath="//label[contains(text(),\"Create & activate (send welcome email)\")]")
	private WebElement CreateActivatesendwelcomeemail;
	
	

	@FindBy(xpath="//label[contains(text(),\"Don't create\")] ")
	private WebElement Donotcreate;
	
	@FindBy(xpath="//label[contains(text(),\"Create & send activation email\")]  ")
	private WebElement Createsendactivationemail;
	
	//label[contains(text(),"Create & send activation email")]  
	  
	
	public WebElement getCreatesendactivationemail() {
		return Createsendactivationemail;
	}


	public WebElement getDonotcreate() {
		return Donotcreate;
	}


	public WebElement getCreateActivatesendwelcomeemail() {
		return CreateActivatesendwelcomeemail;
	}


	public WebElement getCreateactivatewithoutemail() {
		
		return Createactivatewithoutemail;
	}
	

	public WebElement getInvoice() {
		return Invoice;
	}





	public List<WebElement> getSelectAccountName() {
		return SelectAccountName;
	}





	public WebElement getAccountEnterName() {
		return AccountEnterName;
	}





	public WebElement getAccountNameDropDown() {
		return AccountNameDropDown;
	}

	@FindBy(id = "datepicker")
	private WebElement DateSelection;

	@FindBy(id = "selDateHr")
	private WebElement Hours;

	@FindBy(id = "selDateMn")
	private WebElement Minutes;

	public void selectDate(int days) {

		JavaUtility date = new JavaUtility();
		Futuredate = date.getDateMMDDYYYY(days,"MM/dd/yyyy");
		driver.findElement(By.xpath("//td[@data-day='" + Futuredate +"']")).click();
		
	}

	
	
	

	public WebElement getCustomerCategoryAccount() { 
		return customerCategoryAccount;
	}

	public WebElement getCustomerName() {
		return CustomerName;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getContactNumber() {
		return contactNumber;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getName() {
		return Name;
	}

	public WebElement getPassenger() {
		return passenger;
	}

	public WebElement getHandLuggage() {
		return HandLuggage;
	}

	public WebElement getCheckInLuggage() {
		return CheckInLuggage;
	}

	public WebElement getSelectcustomer() {
		return Selectcustomer;
	}


	// th[contains(text(),'September
	// 2025')]//ancestor::div[@class="datepicker"]/descendant::tr/child::td[text()='18']
	public WebElement getDateSelection() {
		return DateSelection;
	}

	public WebElement getHours() {
		return Hours;
	}

	public WebElement getMinutes() {
		return Minutes;
	}

	public WebElement getTerminal() {
		return Terminal;
	}

	public WebElement getFlightNo() {
		return FlightNo;
	}

	public WebElement getArrivingFrom() {
		return ArrivingFrom;
	}

	public WebElement getPickUpMeAfter() {
		return pickUpMeAfter;
	}

	public WebElement getPickupClick() {
		return pickupClick;
	}

	public WebElement getDropoffClick() {
		return dropoffClick;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public  List<WebElement>  getDropoff() {
		return dropoff;
	}

	public WebElement getDesktopNotification() {
		return DesktopNotification;
	}

	public WebElement getNewbooking() {
		return newbooking;
	}

	public  List<WebElement>  getPickup() {
		return Pickup;
	}

	public WebElement getdriverFare() {
		// TODO Auto-generated method stub
		return driverFare;
	}

}
