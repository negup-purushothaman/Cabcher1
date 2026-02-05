package Recurrring_TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtlity.Accounts_Obj;
import com.comcast.crm.ObjectRepositoryUtlity.Acution_Obj;
import com.comcast.crm.ObjectRepositoryUtlity.NewBookingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;
import Recurring_Booking.obj.Recurring_List;

public class Recurring_List_TestNG extends BaseClass {

	@Test
	public void AuctionEditWithDateDelete() throws Throwable {
		// Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility Excel = new Excelutility();
		Accounts_Obj Account = new Accounts_Obj(driver);
		Acution_Obj Acution = new Acution_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);
		Recurring_List List = new Recurring_List(driver);

		WebElement Recurring = List.getRecurring();

		web.WaitForElementClick(driver, Recurring);
		Recurring.click();
		WebElement RecurringList = List.getList();
		web.WaitForElementClick(driver, RecurringList);
		RecurringList.click();
		WebElement Addnew = Account.getAddNew();
		web.WaitForElementClick(driver, Addnew);
		Addnew.click();

		// web.WaitForElementClick(driver, RecurringList);
		List<WebElement> RecurringTitile = List.getRecurringTitile();
		String RecurringTitiledata = Excel.getDataFromExcel("Recurring", 0, 0);
		Thread.sleep(2000);
		RecurringTitile.get(0).click();
		RecurringTitile.get(0).sendKeys(RecurringTitiledata);
		List<WebElement> RecurringDescription = List.getRecurringDescription();
		String RecurringDescriptiondata = Excel.getDataFromExcel("Recurring", 0, 1);
		RecurringDescription.get(0).click();
		RecurringDescription.get(0).sendKeys(RecurringDescriptiondata);

		WebElement Weekly = List.getRecurringdaysWeekly();
		web.selectIndex(Weekly, 1);
		WebElement RecurringDays = List.getRecurringDays();
		RecurringDays.click();
		WebElement SelectAll = List.getSelectAll();
		web.WaitForElementClick(driver, SelectAll);
		SelectAll.click();
		WebElement HH = List.getPickupTimeHH();
		web.selectIndex(HH, 2);

		WebElement MM = List.getMM();
		web.selectIndex(MM, 4);

		WebElement StartDate = List.getStartDate();
		StartDate.click();
		booking.selectDate(5);

		WebElement EndDate = List.getEndDate();
		EndDate.click();

		booking.selectDate(15);

		WebElement Selectcustomer = List.getCustomerSelect();

		Selectcustomer.click();

		WebElement SearchCustomer = List.getSearchCustomer();
		String Searchcustomerdata = Excel.getCellData("Recurring", 0, 0);
		SearchCustomer.sendKeys(Searchcustomerdata);

		WebElement Selectcustomer1 = List.getSelectcustomer();
		Selectcustomer1.click();

		/*
		 * WebElement AccountSelect = List.getAccountSelect(); AccountSelect.click();
		 * 
		 * WebElement AccountSearchCustomer = List.getSearchCustomer(); String
		 * AccountSearchCustomerdata = Excel.getCellData("Recurring", 0, 3);
		 * AccountSearchCustomer.sendKeys(AccountSearchCustomerdata);
		 * 
		 * WebElement SelectAccount = List.getSelectcustomer(); SelectAccount.click();
		 */

		WebElement Driverupdate = List.getDriverupdate();
		Driverupdate.click();
		WebElement SearchDriver = List.getSearchCustomer();
		String SearchDriverdata = Excel.getCellData("Recurring", 0, 4);
		SearchDriver.sendKeys(SearchDriverdata);

		List.getSelectDriver().click();

		WebElement Scroll = List.getScrollelement();
		web.scrolltoElement(driver, Scroll);
		// Drop-off
		booking.getDropoffClick().click();
		Thread.sleep(2000);
		List<WebElement> dropoff = booking.getDropoff();
		// web.scrolltoElement(driver, SearchDriver);
		dropoff.get(2).click();

		// Pickup
		booking.getPickupClick().click();
		List<WebElement> pickup = booking.getPickup();
		pickup.get(3).click();

		// Flight details

		String Flightdata = Excel.getDataFromExcel("NewBooking", 0, 0);

		List<WebElement> flightNo = booking.getFlightNo();
		flightNo.get(0).sendKeys(Flightdata);
		String ArrivingFromdata = Excel.getDataFromExcel("NewBooking", 0, 1);
		List<WebElement> Arrivingfrom = booking.getArrivingFrom();
		Arrivingfrom.get(0).sendKeys(ArrivingFromdata);
		// Assert.assertTrue(false, "Screenshot validation");
		web.selectIndex(booking.getPickUpMeAfter(), 2);
		List<WebElement> Treminal = booking.getTerminal();
		String TreminalData = Excel.getDataFromExcel("NewBooking", 0, 2);
		Treminal.get(0).sendKeys(TreminalData);

		WebElement ScrollVehicle = List.getscrollVehicle();
		web.scrolltoElement(driver, ScrollVehicle);

		List.getSelectvehicle().click();
		String Recurringdata = Excel.getDataFromExcel("Recurring", 0, 5);
		driver.findElement(By.xpath("//ul[@id=\"vehicleSelectedUL\"]/li/div/div/span[text()='" + Recurringdata + "']"))
				.click();

		// Passenger & luggage
		web.selectIndex(booking.getPassenger(), 2);
		web.selectIndex(booking.getHandLuggage(), 2);
		web.selectIndex(booking.getCheckInLuggage(), 1);

		// Customer details
		Thread.sleep(2000);
		List<WebElement> CustomerName = booking.getCustomerName();
		String Customerdata = Excel.getDataFromExcel("NewBooking", 0, 3);
		CustomerName.get(0).clear();
		CustomerName.get(0).sendKeys(Customerdata);
		Thread.sleep(3000);
		
		List<WebElement> Email = booking.getEmail();
		String Emaildata = Excel.getDataFromExcel("NewBooking", 0, 4);
		Email.get(0).clear();
		Email.get(0).sendKeys(Emaildata);
		Thread.sleep(3000);
		web.scrolltoElement(driver, booking.getSubmit());
		booking.getSubmit().click();

	}

}
