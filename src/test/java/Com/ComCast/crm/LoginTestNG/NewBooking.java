package Com.ComCast.crm.LoginTestNG;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.comcast.crm.ObjectRepositoryUtlity.DispatchDashBoardObj;
import com.comcast.crm.ObjectRepositoryUtlity.NewBookingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.JavaUtility;
import Genericlabaries.WebdriverUtility;
import gereriUtility.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class NewBooking extends BaseClass {

    public JavaUtility random = new JavaUtility();
    public static String bookingNumber = "";

    @Test(priority = 1)
    public void BookingDashBoard() throws Throwable {

        WebdriverUtility web = new WebdriverUtility();
        NewBookingObj booking = new NewBookingObj(driver);
        Excelutility excel = new Excelutility();

        // New Booking
        web.WaitForElementClick(driver, booking.getNewbooking());
        booking.getNewbooking().click();

        // Drop-off
        booking.getDropoffClick().click();
        List<WebElement> dropoff = booking.getDropoff();
        dropoff.get(2).click();

        // Pickup
        booking.getPickupClick().click();
        List<WebElement> pickup = booking.getPickup();
        pickup.get(3).click();

        // Flight details
        booking.getFlightNo().sendKeys("AF1247");
        booking.getArrivingFrom().sendKeys("London");
        Assert.assertTrue(false, "Screenshot validation");
        web.selectIndex(booking.getPickUpMeAfter(), 2);
        booking.getTerminal().sendKeys("A1577");

        // Date & time
        booking.getDateSelection().click();
        booking.selectDate(2);

        web.selectIndex(booking.getHours(), 2);
        web.selectIndex(booking.getMinutes(), 5);

        // Passenger & luggage
        web.selectIndex(booking.getPassenger(), 2);
        web.selectIndex(booking.getHandLuggage(), 2);
        web.selectIndex(booking.getCheckInLuggage(), 1);

        // Customer details
        booking.getCustomerName().sendKeys("Test");
        booking.getEmail().sendKeys("test.customer@cabcher.com");

        web.scrolltoElement(driver, booking.getSubmit());
        booking.getSubmit().click();
        Assert.assertTrue(false, "Screenshot validation");

        // Capture booking number
        String bookingText = driver.findElement(
                By.xpath("//div[@class='alert alert-success text-center']")
        ).getText();

        bookingNumber = bookingText.replaceAll("\\D+", "");
        System.out.println("Booking Number : " + bookingNumber);

        excel.SetDataIntoExcel("Sheet1", 0, 0, bookingNumber);
    }


@Test(priority = 2)
	public void DriverAllocation() throws Throwable {

		WebdriverUtility ResWeb = new WebdriverUtility();
		DispatchDashBoardObj dispatch = new DispatchDashBoardObj(driver);

		// Open Dispatch page
		dispatch.getDispatch().click();
		Thread.sleep(1000);

		// Search for "test"
		WebElement search = dispatch.getFilterSearch();
		ResWeb.WaitForElementClick(driver, search);
		search.click();

		Excelutility excel = new Excelutility();

		String booking = excel.getDataFromExcel("Sheet1", 0, 0);
		search.sendKeys(booking);
		Thread.sleep(2000);

		List<WebElement> assignBtns = dispatch.getDriverassin();

		// Loop through each button and click
		for (WebElement btn : assignBtns) {
			btn.click();
			// Optionally, add wait or verification here
			WebElement drivername = driver.findElement(By.xpath("//input[@id=\"driverAllocationID1\"]"));
			Thread.sleep(2000);
			drivername.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id=\"sendNotificationDriver\"]")).click();

			driver.findElement(By.xpath("//button[@id=\"driverUpdate\"]")).click();
            Thread.sleep(15000);
		}

	}

	@Test
	public void NewbookingCustomerDetailsAccount() throws InterruptedException, IOException {
		WebdriverUtility ResWeb = new WebdriverUtility();
		NewBookingObj booking = new NewBookingObj(driver);

		// Click on "New Booking"
		WebElement NewBooking = booking.getNewbooking();
		ResWeb.WaitForElementClick(driver, NewBooking);
		NewBooking.click();

		// Drop-off selection
		WebElement DropoffClick = booking.getDropoffClick();
		ResWeb.WaitForElementClick(driver, DropoffClick);
		DropoffClick.click();
		Thread.sleep(1000);
		List<WebElement> Dropoff = booking.getDropoff();
		if (!Dropoff.isEmpty()) {
			Dropoff.get(2).click();

		} // Click on "Pickup Click" twice
		WebElement PickupClick = booking.getPickupClick();
		ResWeb.WaitForElementClick(driver, PickupClick);
		PickupClick.click();

		// Click on "Pickup"
		List<WebElement> pickup = booking.getPickup();
		if (!pickup.isEmpty()) {
			pickup.get(1).click();

		}

		// Enter flight and arriving details
		WebElement FlightNo = booking.getFlightNo();
		ResWeb.WaitForElementClick(driver, FlightNo);
		FlightNo.sendKeys("AF1247");
		WebElement ArrivingFrom = booking.getArrivingFrom();
		ResWeb.WaitForElementClick(driver, ArrivingFrom);
		ArrivingFrom.sendKeys("London");

// Select Pickup time 
		WebElement Timedrop = booking.getPickUpMeAfter();
		ResWeb.WaitForElementClick(driver, Timedrop);
		ResWeb.selectIndex(Timedrop, 2);

		// Terminal
		WebElement Terminal = booking.getTerminal();
		ResWeb.WaitForElementClick(driver, Terminal);
		Terminal.sendKeys("A1577");

		// Select Date
		WebElement DateSelection = booking.getDateSelection();
		ResWeb.WaitForElementClick(driver, DateSelection);
		DateSelection.click();

		booking.selectDate(2);

		// Select Hours and Minutes
		WebElement Hours = booking.getHours();
		ResWeb.WaitForElementClick(driver, Hours);
		ResWeb.selectIndex(Hours, 2);

		WebElement Minutes = booking.getMinutes();
		ResWeb.WaitForElementClick(driver, Minutes);
		ResWeb.selectIndex(Minutes, 5);

// Passenger dropdown
		WebElement passenger = booking.getPassenger();
		ResWeb.WaitForElementClick(driver, passenger);
		ResWeb.selectIndex(passenger, 2);
		Thread.sleep(2000); // Hand Luggage
		WebElement handLuggage = booking.getHandLuggage();
		ResWeb.WaitForElementClick(driver, handLuggage);
		ResWeb.selectIndex(handLuggage, 2); // Check-In Luggage
		WebElement CheckLuggage = booking.getCheckInLuggage();
		ResWeb.WaitForElementClick(driver, CheckLuggage);
		ResWeb.selectIndex(CheckLuggage, 1);

		WebElement Account = booking.getCustomerCategoryAccount();
		ResWeb.WaitForElementClick(driver, Account);
		Account.click();
		Thread.sleep(2000);

		WebElement AccountName = booking.getAccountNameDropDown();
		ResWeb.WaitForElementClick(driver, AccountName);
		AccountName.click();

		List<WebElement> SelectAccountName = booking.getSelectAccountName();

		if (!SelectAccountName.isEmpty()) {
			SelectAccountName.get(1).click();

		}

		Thread.sleep(2000);
		WebElement customername = booking.getCustomerName();
		ResWeb.WaitForElementClick(driver, customername);
		customername.sendKeys("Test");
		WebElement Invoice = booking.getInvoice();
		ResWeb.WaitForElementClick(driver, Invoice);
		Invoice.click();

		WebElement submit = booking.getSubmit();
		ResWeb.scrolltoElement(driver, submit);
		submit.click();
		Excelutility excel = new Excelutility();

		for (int i = 0; i < 1; i++) { // Loop to simulate 10 bookings // 1. Perform
			// steps to make a
			// new booking // --- your Selenium code to make a booking goes

			// 2. Extract booking ID from success alert
			String bookingIDText = driver.findElement(By.xpath("//div[@class='alert alert-success text-center']"))
					.getText();
			String bookingNumber = bookingIDText.replaceAll("\\D+", "");

			System.out.println("Booking Number: " + bookingNumber);

			// 3. Get next empty row in Excel //
			int nextRow = excel.getNextEmptyRow("Sheet1");

			// 4. Write booking number to Excel
			excel.SetDataIntoExcel("Sheet1", i, 0, bookingNumber);
		}
	}

	@Test()
	public void Dontcreate() throws Throwable {
		WebdriverUtility ResWeb = new WebdriverUtility();
		NewBookingObj booking = new NewBookingObj(driver);

		// Click on "New Booking"
		WebElement NewBooking = booking.getNewbooking();
		ResWeb.WaitForElementClick(driver, NewBooking);
		NewBooking.click();

		// Drop-off selection
		WebElement DropoffClick = booking.getDropoffClick();
		ResWeb.WaitForElementClick(driver, DropoffClick);
		DropoffClick.click();
		Thread.sleep(1000);
		List<WebElement> Dropoff = booking.getDropoff();
		if (!Dropoff.isEmpty()) {
			Dropoff.get(2).click();

		} // Click on "Pickup Click" twice
		WebElement PickupClick = booking.getPickupClick();
		ResWeb.WaitForElementClick(driver, PickupClick);
		PickupClick.click();

		// Click on "Pickup"
		List<WebElement> pickup = booking.getPickup();
		if (!pickup.isEmpty()) {
			pickup.get(1).click();

		}

		// Enter flight and arriving details
		WebElement FlightNo = booking.getFlightNo();
		ResWeb.WaitForElementClick(driver, FlightNo);
		FlightNo.sendKeys("AF1247");

		WebElement ArrivingFrom = booking.getArrivingFrom();
		ResWeb.WaitForElementClick(driver, ArrivingFrom);
		ArrivingFrom.sendKeys("London");

		// Select Pickup time
		WebElement Timedrop = booking.getPickUpMeAfter();
		ResWeb.WaitForElementClick(driver, Timedrop);
		ResWeb.selectIndex(Timedrop, 2);

		// Terminal
		WebElement Terminal = booking.getTerminal();
		ResWeb.WaitForElementClick(driver, Terminal);
		Terminal.sendKeys("A1577");

		// Select Date
		WebElement DateSelection = booking.getDateSelection();
		ResWeb.WaitForElementClick(driver, DateSelection);
		DateSelection.click();

		booking.selectDate(2);

		// Select Hours and Minutes
		WebElement Hours = booking.getHours();
		ResWeb.WaitForElementClick(driver, Hours);
		ResWeb.selectIndex(Hours, 2);

		WebElement Minutes = booking.getMinutes();
		ResWeb.WaitForElementClick(driver, Minutes);
		ResWeb.selectIndex(Minutes, 5);

		// Passenger dropdown
		WebElement passenger = booking.getPassenger();
		ResWeb.WaitForElementClick(driver, passenger);
		ResWeb.selectIndex(passenger, 2);

		// Hand Luggage
		WebElement handLuggage = booking.getHandLuggage();
		ResWeb.WaitForElementClick(driver, handLuggage);
		ResWeb.selectIndex(handLuggage, 2);

		// Check-In Luggage
		WebElement CheckLuggage = booking.getCheckInLuggage();
		ResWeb.WaitForElementClick(driver, CheckLuggage);
		ResWeb.selectIndex(CheckLuggage, 1);

		// Passenger detail

		WebElement customername = booking.getCustomerName();
		ResWeb.WaitForElementClick(driver, customername);
		customername.sendKeys("Test");

		WebElement Email = booking.getEmail();
		ResWeb.WaitForElementClick(driver, customername);
		Email.sendKeys("test.customer@cabcher.com");

		WebElement Donotcreate = booking.getDonotcreate();
		ResWeb.WaitForElementClick(driver, Donotcreate);
		ResWeb.scrolltoElement(driver, Donotcreate);
		Donotcreate.click();

		WebElement submit = booking.getSubmit();
		ResWeb.scrolltoElement(driver, submit);
		submit.click();
		Excelutility excel = new Excelutility();

		for (int i = 0; i < 1; i++) { // 2. Extract booking ID from success alert
			String bookingIDText = driver.findElement(By.xpath("//div[@class='alert alert-success text-center']"))
					.getText();
			String bookingNumber = bookingIDText.replaceAll("\\D+", "");

			System.out.println("Booking Number: " + bookingNumber);

			// 4. Write booking number to Excel
			excel.SetDataIntoExcel("Sheet1", i, 0, bookingNumber);
		}

	}

	// Createsendactivationemail

	@Test() public void Createsendactivationemail() throws Throwable 
  {
  WebdriverUtility ResWeb = new WebdriverUtility(); 
  NewBookingObj booking = new NewBookingObj(driver);
 
  // Click on "New Booking" 
  WebElement NewBooking = booking.getNewbooking();
  ResWeb.WaitForElementClick(driver, NewBooking);
  NewBooking.click();
  
  // Drop-off selection 
  WebElement DropoffClick = booking.getDropoffClick();
  ResWeb.WaitForElementClick(driver, DropoffClick);
  DropoffClick.click();
  Thread.sleep(1000);  
  List<WebElement> Dropoff = booking.getDropoff();
  if
  (!Dropoff.isEmpty()) 
  { Dropoff.get(2).click();
 
  } // Click on "Pickup Click" twice 
  WebElement PickupClick = booking.getPickupClick(); 
  ResWeb.WaitForElementClick(driver, PickupClick);
  PickupClick.click();
  
  // Click on "Pickup" 
  List<WebElement> pickup = booking.getPickup(); 
  if
  (!pickup.isEmpty()) { 
	  pickup.get(1).click();
 
  }
  
  // Enter flight and arriving details
  WebElement FlightNo = booking.getFlightNo(); 
  ResWeb.WaitForElementClick(driver, FlightNo);
  FlightNo.sendKeys("AF1247");
  
  WebElement ArrivingFrom = booking.getArrivingFrom();
  ResWeb.WaitForElementClick(driver, ArrivingFrom);
  ArrivingFrom.sendKeys("London");
  
  // Select Pickup time
  WebElement Timedrop = booking.getPickUpMeAfter();
  ResWeb.WaitForElementClick(driver, Timedrop);
  ResWeb.selectIndex(Timedrop,2);
  
 // Terminal 
  WebElement Terminal = booking.getTerminal();
  ResWeb.WaitForElementClick(driver, Terminal); 
  Terminal.sendKeys("A1577");
  
  // Select Date 
  WebElement DateSelection = booking.getDateSelection();
  ResWeb.WaitForElementClick(driver, DateSelection);
  DateSelection.click();
  
  booking.selectDate(2);
  
  // Select Hours and Minutes
  WebElement Hours = booking.getHours();
  ResWeb.WaitForElementClick(driver, Hours); 
  ResWeb.selectIndex(Hours, 2);
  
  WebElement Minutes = booking.getMinutes();
  ResWeb.WaitForElementClick(driver,
  Minutes); ResWeb.selectIndex(Minutes, 5);
  
  // Passenger dropdown 
  WebElement passenger = booking.getPassenger();
  ResWeb.WaitForElementClick(driver, passenger);
  ResWeb.selectIndex(passenger,2);
  
  // Hand Luggage 
  WebElement handLuggage = booking.getHandLuggage();
  ResWeb.WaitForElementClick(driver, handLuggage);
  ResWeb.selectIndex(handLuggage, 2);
  
  // Check-In Luggage
  WebElement CheckLuggage = booking.getCheckInLuggage();
  ResWeb.WaitForElementClick(driver, CheckLuggage);
  ResWeb.selectIndex(CheckLuggage, 1);
  
  // Passenger detail
  
  WebElement customername = booking.getCustomerName();
  ResWeb.WaitForElementClick(driver, customername);
  customername.sendKeys("Test");
  
  WebElement Email = booking.getEmail();
  ResWeb.WaitForElementClick(driver,Email);
  
  WebElement Createsendactivationemail =booking.getCreatesendactivationemail();
  ResWeb.WaitForElementClick(driver,Createsendactivationemail); 
  ResWeb.scrolltoElement(driver,Createsendactivationemail);
  Createsendactivationemail.click();
  
  
  WebElement submit = booking.getSubmit();
  ResWeb.scrolltoElement(driver,
  submit); submit.click(); Excelutility excel = new Excelutility();
  
  for (int i = 0; i < 1; i++) { // 2. Extract booking ID from success alert
  String bookingIDText = driver.findElement(By.xpath("//div[@class='alert alert-success text-center']"
  )) .getText(); 
  String bookingNumber = bookingIDText.replaceAll("\\D+", "");
  
  System.out.println("Booking Number: " + bookingNumber);
  
  
 // 4. Write booking number to Excel 
  excel.SetDataIntoExcel("Sheet1", i, 0,bookingNumber); }
 
  }

	@Test()
	public void Createactivatewithoutemail() throws Throwable {
		WebdriverUtility ResWeb = new WebdriverUtility();
		NewBookingObj booking = new NewBookingObj(driver);

		// Click on "New Booking"
		WebElement NewBooking = booking.getNewbooking();
		ResWeb.WaitForElementClick(driver, NewBooking);
		NewBooking.click();

		// Drop-off selection
		WebElement DropoffClick = booking.getDropoffClick();
		ResWeb.WaitForElementClick(driver, DropoffClick);
		DropoffClick.click();
		Thread.sleep(1000);
		List<WebElement> Dropoff = booking.getDropoff();
		if (!Dropoff.isEmpty()) {
			Dropoff.get(2).click();

		} // Click on "Pickup Click" twice
		WebElement PickupClick = booking.getPickupClick();
		ResWeb.WaitForElementClick(driver, PickupClick);
		PickupClick.click();

		// Click on "Pickup"
		List<WebElement> pickup = booking.getPickup();
		if (!pickup.isEmpty()) {
			pickup.get(1).click();

		}

		// Enter flight and arriving details
		WebElement FlightNo = booking.getFlightNo();
		ResWeb.WaitForElementClick(driver, FlightNo);
		FlightNo.sendKeys("AF1247");

		WebElement ArrivingFrom = booking.getArrivingFrom();
		ResWeb.WaitForElementClick(driver, ArrivingFrom);
		ArrivingFrom.sendKeys("London");

		// Select Pickup time
		WebElement Timedrop = booking.getPickUpMeAfter();
		ResWeb.WaitForElementClick(driver, Timedrop);
		ResWeb.selectIndex(Timedrop, 2);

		// Terminal
		WebElement Terminal = booking.getTerminal();
		ResWeb.WaitForElementClick(driver, Terminal);
		Terminal.sendKeys("A1577");

		// Select Date
		WebElement DateSelection = booking.getDateSelection();
		ResWeb.WaitForElementClick(driver, DateSelection);
		DateSelection.click();

		booking.selectDate(2);

		// Select Hours and Minutes
		WebElement Hours = booking.getHours();
		ResWeb.WaitForElementClick(driver, Hours);
		ResWeb.selectIndex(Hours, 2);

		WebElement Minutes = booking.getMinutes();
		ResWeb.WaitForElementClick(driver, Minutes);
		ResWeb.selectIndex(Minutes, 5);

		// Passenger dropdown
		WebElement passenger = booking.getPassenger();
		ResWeb.WaitForElementClick(driver, passenger);
		ResWeb.selectIndex(passenger, 2);

		// Hand Luggage
		WebElement handLuggage = booking.getHandLuggage();
		ResWeb.WaitForElementClick(driver, handLuggage);
		ResWeb.selectIndex(handLuggage, 2);

		// Check-In Luggage
		WebElement CheckLuggage = booking.getCheckInLuggage();
		ResWeb.WaitForElementClick(driver, CheckLuggage);
		ResWeb.selectIndex(CheckLuggage, 1);

		// Passenger detail

		WebElement customername = booking.getCustomerName();
		ResWeb.WaitForElementClick(driver, customername);
		customername.sendKeys("Test");

		WebElement Email = booking.getEmail();
		ResWeb.WaitForElementClick(driver, customername);
		Email.sendKeys("test.customer@cabcher.com");

		WebElement Createactivatewithoutemail = booking.getCreateactivatewithoutemail();
		ResWeb.WaitForElementClick(driver, Createactivatewithoutemail);
		ResWeb.scrolltoElement(driver, Createactivatewithoutemail);
		Createactivatewithoutemail.click();

		WebElement submit = booking.getSubmit();
		ResWeb.scrolltoElement(driver, submit);
		submit.click();
		Excelutility excel = new Excelutility();

		for (int i = 0; i < 1; i++) { // 2. Extract booking ID from success alert
			String bookingIDText = driver.findElement(By.xpath("//div[@class='alert alert-success text-center']"))
					.getText();
			String bookingNumber = bookingIDText.replaceAll("\\D+", "");

			System.out.println("Booking Number: " + bookingNumber);

			// 4. Write booking number to Excel
			excel.SetDataIntoExcel("Sheet1", i, 0, bookingNumber);
		}

	}

	// Create & activate (send welcome email)

	@Test()
	public void Createactivatesendwelcomeemail() throws Throwable {
		WebdriverUtility ResWeb = new WebdriverUtility();
		NewBookingObj booking = new NewBookingObj(driver);

		// Click on "New Booking"
		WebElement NewBooking = booking.getNewbooking();
		ResWeb.WaitForElementClick(driver, NewBooking);
		NewBooking.click();

		// Drop-off selection
		WebElement DropoffClick = booking.getDropoffClick();
		ResWeb.WaitForElementClick(driver, DropoffClick);
		DropoffClick.click();
		Thread.sleep(1000);
		List<WebElement> Dropoff = booking.getDropoff();
		if (!Dropoff.isEmpty()) {
			Dropoff.get(2).click();

		} // Click on "Pickup Click" twice
		WebElement PickupClick = booking.getPickupClick();
		ResWeb.WaitForElementClick(driver, PickupClick);
		PickupClick.click();

		// Click on "Pickup"
		List<WebElement> pickup = booking.getPickup();
		if (!pickup.isEmpty())

		{
			pickup.get(1).click();

		}

		// Enter flight and arriving details
		WebElement FlightNo = booking.getFlightNo();
		ResWeb.WaitForElementClick(driver, FlightNo);
		FlightNo.sendKeys("AF1247");

		WebElement ArrivingFrom = booking.getArrivingFrom();
		ResWeb.WaitForElementClick(driver, ArrivingFrom);
		ArrivingFrom.sendKeys("London");

		// Select Pickup time
		WebElement Timedrop = booking.getPickUpMeAfter();
		ResWeb.WaitForElementClick(driver, Timedrop);
		ResWeb.selectIndex(Timedrop, 2);

		// Terminal
		WebElement Terminal = booking.getTerminal();
		ResWeb.WaitForElementClick(driver, Terminal);
		Terminal.sendKeys("A1577");

		// Select Date
		WebElement DateSelection = booking.getDateSelection();
		ResWeb.WaitForElementClick(driver, DateSelection);
		DateSelection.click();

		booking.selectDate(2);

// Select Hours and Minutes 
		WebElement Hours = booking.getHours();
		ResWeb.WaitForElementClick(driver, Hours);
		ResWeb.selectIndex(Hours, 2);

		WebElement Minutes = booking.getMinutes();
		ResWeb.WaitForElementClick(driver, Minutes);
		ResWeb.selectIndex(Minutes, 5);

		// Passenger dropdown
		WebElement passenger = booking.getPassenger();
		ResWeb.WaitForElementClick(driver, passenger);
		ResWeb.selectIndex(passenger, 2);

		// Hand Luggage
		WebElement handLuggage = booking.getHandLuggage();
		ResWeb.WaitForElementClick(driver, handLuggage);
		ResWeb.selectIndex(handLuggage, 2);

		// Check-In Luggage
		WebElement CheckLuggage = booking.getCheckInLuggage();
		ResWeb.WaitForElementClick(driver, CheckLuggage);
		ResWeb.selectIndex(CheckLuggage, 1);

		// Passenger detail

		WebElement customername = booking.getCustomerName();
		ResWeb.WaitForElementClick(driver, customername);
		customername.sendKeys("Test");

		WebElement Email = booking.getEmail();
		ResWeb.WaitForElementClick(driver, customername);
		Email.sendKeys("test.customer@cabcher.com");

		WebElement CreateActivatesendwelcomeemail = booking.getCreateActivatesendwelcomeemail();
		ResWeb.WaitForElementClick(driver, CreateActivatesendwelcomeemail);
		ResWeb.scrolltoElement(driver, CreateActivatesendwelcomeemail);
		CreateActivatesendwelcomeemail.click();

		WebElement submit = booking.getSubmit();
		ResWeb.scrolltoElement(driver, submit);
		submit.click();
		Excelutility excel = new Excelutility();

		for (int i = 0; i < 1; i++) { // Loop to simulate 10 bookings // 1. Perform
			// steps to make a new booking // --- your Selenium code to make a booking goes
			// here ---

			// 2. Extract booking ID from success alert
			String bookingIDText = driver.findElement(By.xpath("//div[@class='alert alert-success text-center']"))
					.getText();
			String bookingNumber = bookingIDText.replaceAll("\\D+", "");

			System.out.println("Booking Number: " + bookingNumber);

			// 3. Get next empty row in Excel // int nextRow =
			excel.getNextEmptyRow("Sheet1");

			// 4. Write booking number to Excel
			excel.SetDataIntoExcel("Sheet1", i, 0, bookingNumber);
		}

	}
}
