package Com.ComCast.crm.LoginTestNG;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtlity.Accounts_Obj;
import com.comcast.crm.ObjectRepositoryUtlity.Acution_Obj;
import com.comcast.crm.ObjectRepositoryUtlity.NewBookingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Auction extends BaseClass {

	@Test
	public void AuctionYES() throws Throwable {
		// Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();
		Accounts_Obj Account = new Accounts_Obj(driver);
		Acution_Obj Acution = new Acution_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);
		// Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, Acution.getAuction());
		Acution.getAuction().click();

		web.WaitForElementClick(driver, Account.getAddNew());
		Account.getAddNew().click();

		List<WebElement> Title = Acution.getTitle();
		String Titledata = excel.getDataFromExcel("Acution", 0, 0);
		Title.get(0).sendKeys(Titledata);
		Thread.sleep(2000);

		List<WebElement> Details = Acution.getDetails();
		String Detailsdata = excel.getDataFromExcel("Acution", 0, 1);
		Details.get(0).sendKeys(Detailsdata);

		List<WebElement> Attempts = Acution.getAttempts();
		String Attemptsdata = excel.getDataFromExcel("Acution", 0, 2);
		Attempts.get(0).clear();
		Attempts.get(0).sendKeys(Attemptsdata);
		Thread.sleep(2000);
		List<WebElement> MaxAmount = Acution.getMaxAmount();
		String MaxAmountdata = excel.getDataFromExcel("Acution", 0, 3);
		MaxAmount.get(0).clear();
		MaxAmount.get(0).sendKeys(MaxAmountdata);
		Thread.sleep(2000);

		WebElement Decimals = Acution.getAllow_decimals_in_bid();
		web.selectIndex(Decimals, 1);
		
		List<WebElement> Min_bid_difference = Acution.getMin_bid_difference();
		String Min_bid_differencedata = excel.getDataFromExcel("Acution", 0, 4);
		Min_bid_difference.get(0).clear();
		Min_bid_difference.get(0).sendKeys(Min_bid_differencedata);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, Acution.getBiddres());
		Acution.getBiddres().click();
		Thread.sleep(2000);
		Acution.getSelectAll().click();

		WebElement ExpiryDate = Acution.getExpiry();

		ExpiryDate.click();
		booking.selectDate(5);
		Thread.sleep(3000);

		WebElement Addbutton = Acution.getAddbutton();
		web.scrolltoElement(driver, Addbutton);
		Addbutton.click();

	}
	@Test
	public void AuctionNO() throws Throwable {
		// Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();
		Accounts_Obj Account = new Accounts_Obj(driver);
		Acution_Obj Acution = new Acution_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);
		// Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, Acution.getAuction());
		Acution.getAuction().click();

		web.WaitForElementClick(driver, Account.getAddNew());
		Account.getAddNew().click();

		List<WebElement> Title = Acution.getTitle();
		String Titledata = excel.getDataFromExcel("Acution", 0, 0);
		Title.get(0).sendKeys(Titledata);
		Thread.sleep(2000);

		List<WebElement> Details = Acution.getDetails();
		String Detailsdata = excel.getDataFromExcel("Acution", 0, 1);
		Details.get(0).sendKeys(Detailsdata);

		List<WebElement> Attempts = Acution.getAttempts();
		String Attemptsdata = excel.getDataFromExcel("Acution", 0, 2);
		Attempts.get(0).clear();
		Attempts.get(0).sendKeys(Attemptsdata);
		Thread.sleep(2000);
		List<WebElement> MaxAmount = Acution.getMaxAmount();
		String MaxAmountdata = excel.getDataFromExcel("Acution", 0, 3);
		MaxAmount.get(0).clear();
		MaxAmount.get(0).sendKeys(MaxAmountdata);
		Thread.sleep(2000);
		
		List<WebElement> Min_bid_difference = Acution.getMin_bid_difference();
		String Min_bid_differencedata = excel.getDataFromExcel("Acution", 0, 4);
		Min_bid_difference.get(0).clear();
		Min_bid_difference.get(0).sendKeys(Min_bid_differencedata);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, Acution.getBiddres());
		Acution.getBiddres().click();
		Thread.sleep(2000);
		Acution.getSelectAll().click();

		WebElement ExpiryDate = Acution.getExpiry();

		ExpiryDate.click();
		booking.selectDate(5);
		Thread.sleep(3000);

		WebElement Addbutton = Acution.getAddbutton();
		web.scrolltoElement(driver, Addbutton);
		Addbutton.click();

	}
	
	@Test
	public void AuctionEditWithDateDelete() throws Throwable {
		// Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();
		Accounts_Obj Account = new Accounts_Obj(driver);
		Acution_Obj Acution = new Acution_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);
		// Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, Acution.getAuction());
		Acution.getAuction().click();

		/*
		 * web.WaitForElementClick(driver, Account.getAddNew());
		 * Account.getAddNew().click();
		 * 
		 */
		Thread.sleep(2000);
		List<WebElement>	Edit=Acution.getEditOption();
		
		Edit.get(0).click();

		List<WebElement> Title = Acution.getTitle();
		String Titledata = excel.getDataFromExcel("Acution", 0, 0);
		Title.get(0).clear();
		Title.get(0).sendKeys(Titledata);
		Thread.sleep(2000);

		List<WebElement> Details = Acution.getDetails();
		String Detailsdata = excel.getDataFromExcel("Acution", 0, 1);
		Details.get(0).clear();
		Details.get(0).sendKeys(Detailsdata);

		List<WebElement> Attempts = Acution.getAttempts();
		String Attemptsdata = excel.getDataFromExcel("Acution", 0, 2);
		Attempts.get(0).clear();
		Attempts.get(0).sendKeys(Attemptsdata);
		Thread.sleep(2000);
		List<WebElement> MaxAmount = Acution.getMaxAmount();
		String MaxAmountdata = excel.getDataFromExcel("Acution", 0, 3);
		MaxAmount.get(0).clear();
		MaxAmount.get(0).sendKeys(MaxAmountdata);
		Thread.sleep(2000);
		
		List<WebElement> Min_bid_difference = Acution.getMin_bid_difference();
		String Min_bid_differencedata = excel.getDataFromExcel("Acution", 0, 4);
		Min_bid_difference.get(0).clear();
		Min_bid_difference.get(0).sendKeys(Min_bid_differencedata);
		Thread.sleep(2000);
		
		web.WaitForElementClick(driver, Acution.getEditBiddres());
		Acution.getEditBiddres().click();
		Thread.sleep(2000);
		
		
		Acution.getSelectAll().click();

		WebElement ExpiryDate = Acution.getExpiry();

		ExpiryDate.click();
		Acution.getDateDelete().click();
		WebElement Update = Acution.getUpdate();
		web.scrolltoElement(driver, Update);
		Update.click();
		
	}
	
	
}
