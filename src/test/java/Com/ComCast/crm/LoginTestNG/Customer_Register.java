package Com.ComCast.crm.LoginTestNG;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cabcher.pricing.PricingObj;
import com.cabcher.pricing.Pricing_Discounts_Obj;
import com.cabcher.pricing.Voucher_Pricing_Obj;
import com.comcast.crm.ObjectRepositoryUtlity.Customers_Register;
import com.comcast.crm.ObjectRepositoryUtlity.NewBookingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Customer_Register extends BaseClass {

	@Test
	public void Single_customer_Register() throws Throwable {
		Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		PricingObj price = new PricingObj(driver);
		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);
		Voucher_Pricing_Obj Voucher = new Voucher_Pricing_Obj(driver);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, CustomerReg.getCustomerRegister());
		CustomerReg.getCustomerRegister().click();

		// Click Add button
		Thread.sleep(2000);
		WebElement addButton = Discount.getAddbuttton();
		// web.scrolltoElement(driver, addButton);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, addButton);
		addButton.click();

		String customername = excel.getDataFromExcel("CustomerRegister", 0, 0);
		CustomerReg.getCustomerName().sendKeys(customername);

		String customeremail = excel.getDataFromExcel("CustomerRegister", 0, 1);
		CustomerReg.getCustomerEmail().sendKeys(customeremail);

		String Contactnumber = excel.getDataFromExcel("CustomerRegister", 0, 2);
		CustomerReg.getContact().sendKeys(Contactnumber);

		CustomerReg.getAdd().click();
 
		Thread.sleep(2000);

	}

	@Test
	public void ActiveMutiple_customer_Register() throws Throwable {
		Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, CustomerReg.getCustomerRegister());
		CustomerReg.getCustomerRegister().click();

		for (int i = 0; i < 3; i++) {
			Thread.sleep(2000);
			WebElement addButton = Discount.getAddbuttton();
			// web.scrolltoElement(driver, addButton);
			Thread.sleep(2000);
			web.WaitForElementClick(driver, addButton);
			addButton.click();

			String customername = excel.getDataFromExcel("CustomerRegister", i, 0);
			CustomerReg.getCustomerName().sendKeys(customername);

			String customeremail = excel.getDataFromExcel("CustomerRegister", i, 1);
			CustomerReg.getCustomerEmail().sendKeys(customeremail);

			String Contactnumber = excel.getDataFromExcel("CustomerRegister", i, 2);
			CustomerReg.getContact().sendKeys(Contactnumber);

			CustomerReg.getAdd().click();

			Thread.sleep(2000);
		}

	}

	@Test
	public void Pending_Mutiple_customer_Register() throws Throwable {
		Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);

		Thread.sleep(2000);
		web.WaitForElementClick(driver, CustomerReg.getCustomerRegister());
		CustomerReg.getCustomerRegister().click();

		for (int i = 0; i < 3; i++) {
			Thread.sleep(2000);
			WebElement addButton = Discount.getAddbuttton();
			// web.scrolltoElement(driver, addButton);
			Thread.sleep(2000);
			web.WaitForElementClick(driver, addButton);
			addButton.click();

			String customername = excel.getDataFromExcel("CustomerRegister", i, 0);
			CustomerReg.getCustomerName().sendKeys(customername);

			String customeremail = excel.getDataFromExcel("CustomerRegister", i, 1);
			CustomerReg.getCustomerEmail().sendKeys(customeremail);

			String Contactnumber = excel.getDataFromExcel("CustomerRegister", i, 2);
			CustomerReg.getContact().sendKeys(Contactnumber);

			WebElement StatusPending = CustomerReg.getCustomerStatus();
			web.selectIndex(StatusPending, 1);

			CustomerReg.getAdd().click();

			Thread.sleep(2000);
		}

	}

	@Test
	public void Suspend_Mutiple_customer_Register() throws Throwable {
		Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();
		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, CustomerReg.getCustomerRegister());
		CustomerReg.getCustomerRegister().click();

		for (int i = 0; i < 3; i++) {
			Thread.sleep(2000);
			WebElement addButton = Discount.getAddbuttton();
			// web.scrolltoElement(driver, addButton);
			Thread.sleep(2000);
			web.WaitForElementClick(driver, addButton);
			addButton.click();

			String customername = excel.getDataFromExcel("CustomerRegister", i, 0);
			CustomerReg.getCustomerName().sendKeys(customername);

			String customeremail = excel.getDataFromExcel("CustomerRegister", i, 1);
			CustomerReg.getCustomerEmail().sendKeys(customeremail);

			String Contactnumber = excel.getDataFromExcel("CustomerRegister", i, 2);
			CustomerReg.getContact().sendKeys(Contactnumber);

			WebElement StatusPending = CustomerReg.getCustomerStatus();
			web.selectIndex(StatusPending, 2);

			CustomerReg.getAdd().click();

			Thread.sleep(2000);
		}

	}

	@Test
	public void Delete_Mutiple_customer_Register() throws Throwable {
		Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();
		Thread.sleep(2000);
		web.WaitForElementClick(driver, CustomerReg.getCustomerRegister());
		CustomerReg.getCustomerRegister().click();

		for (int i = 0; i < 2; i++) {
			Thread.sleep(2000);
			String customername = excel.getDataFromExcel("Customer-active", i, 0);
			WebElement searchbar = CustomerReg.getSearchbar();
			searchbar.click();
			Thread.sleep(3000);
			searchbar.sendKeys(customername);
			Thread.sleep(2000);
			WebElement Delete = CustomerReg.getDeleteCustomer();
			Delete.click();
			Thread.sleep(2000);
			CustomerReg.getConfrim().click();
			searchbar.clear();
			Thread.sleep(2000);		
		}

	}

}
