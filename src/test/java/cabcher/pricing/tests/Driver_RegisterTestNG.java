package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.comcast.crm.ObjectRepositoryUtlity.Driver_Register_Obj;
//import com.comcast.crm.ObjectRepositoryUtlity.NewBookingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Driver_RegisterTestNG extends BaseClass {
	@Test
	public void Daily_Surcharges_NO() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		// PricingObj price = new PricingObj(driver);
		// Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		// NewBookingObj booking = new NewBookingObj(driver);
		// Voucher_Pricing_Obj Voucher = new Voucher_Pricing_Obj(driver);
		Driver_Register_Obj Driver_register = new Driver_Register_Obj(driver);

		web.WaitForElementClick(driver, Driver_register.getDriverDropdown());
		Driver_register.getDriverDropdown().click();

		web.WaitForElementClick(driver, Driver_register.getList());
		Driver_register.getList().click();

		// Driver_register.getList().click();

		// Click Add button

		Thread.sleep(2000);
		WebElement addButton = Driver_register.getAddbuttton();
		web.WaitForElementClick(driver, addButton);
		addButton.click();

		Thread.sleep(2000);
		WebElement SelectType = Driver_register.getVehicleTypesSelectAll();
		SelectType.click();

		List<WebElement> update = Driver_register.getDriverupdate();
		for (int i = 0; i < update.size(); i++) {
			Thread.sleep(1000); 
			String voucherData = excel.getDataFromExcel("Driver", 0, i);
			update.get(i).sendKeys(voucherData);

		}

		List<WebElement> Contact = Driver_register.getContact();
		String voucherData2 = excel.getDataFromExcel("Driver", 0, 5);
		Contact.get(0).sendKeys(voucherData2);
		Thread.sleep(5000);

		WebElement UpdateButton = Driver_register.getUpdateButton();
		web.scrolltoElement(driver, UpdateButton);
		UpdateButton.click();

		Thread.sleep(5000);

		WebElement pending = Driver_register.getPending();
		pending.click();
		Thread.sleep(5000);

		String voucherData3 = excel.getDataFromExcel("Driver", 0, 3);

		// Split email
		String[] emailParts = voucherData3.split("@");
		String firstName = emailParts[0];

		// Use it in search bar
		WebElement SearchBar = Driver_register.getSearchBar();
		SearchBar.click();
		SearchBar.sendKeys(firstName);

		Thread.sleep(5000);

		List<WebElement> ActiveDriver = Driver_register.getActivateDriver();

		ActiveDriver.get(0).click();

		WebElement Driverstatus = Driver_register.getDriverStatus();
		web.scrolltoElement(driver, Driverstatus);
		Thread.sleep(2000);
		web.selectIndex(Driverstatus, 0);
		Thread.sleep(2000);
		// Driverstatus.click();

		WebElement ScrollElement = Driver_register.getActiveUpdateButton();
		web.scrolltoElement(driver, ScrollElement);
		ScrollElement.click();

		Thread.sleep(1000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
