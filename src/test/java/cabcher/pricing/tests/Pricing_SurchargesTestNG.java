package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cabcher.pricing.PricingObj;
import com.cabcher.pricing.Pricing_Discounts_Obj;
import com.cabcher.pricing.Pricing_Surcharges_Obj;
import com.comcast.crm.ObjectRepositoryUtlity.NewBookingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Pricing_SurchargesTestNG extends BaseClass {

	@Test
	public void NO_Surcharges() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		PricingObj price = new PricingObj(driver);
		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Pricing_Surcharges_Obj Surcharges = new Pricing_Surcharges_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);

		// -------- Navigate to Pricing → Surcharges --------

		for (int j = 0; j <= 5; j++) {
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();

			web.WaitForElementClick(driver, Surcharges.getSurcharges());
			Surcharges.getSurcharges().click();

			// -------- Click Add Button --------
			WebElement addButton = Discount.getAddbuttton();
			Thread.sleep(2000);
			web.scrolltoElement(driver, addButton);
			web.WaitForElementClick(driver, addButton);
			Thread.sleep(2000);
			addButton.click();

			List<WebElement> priceUpdate = Discount.getTextAreaLoactionUpdate();
			List<WebElement> fromDates = Discount.getDateSelectionFROM();
			List<WebElement> toDates = Discount.getDateSelectionTO();

			for (int k = 0; k < priceUpdate.size(); k++) {

				// -------- FROM Date (Row-wise) --------
				web.WaitForElementClick(driver, fromDates.get(k));
				fromDates.get(k).click();

				int fromDate = 2 + j;
				booking.selectDate(fromDate);

				Thread.sleep(1000);

				// -------- Location Price --------
				String locationPrice = excel.getDataFromExcel("Fixedpickup", j, k);
				priceUpdate.get(k).clear();
				priceUpdate.get(k).sendKeys(locationPrice);

				Thread.sleep(1000);

				// -------- TO Date (Row-wise) --------
				web.WaitForElementClick(driver, toDates.get(k));
				toDates.get(k).click();

				int toDate = fromDate + 2;
				booking.selectDate(toDate);

				Thread.sleep(1000);

				// -------- Customer Prices --------
				List<WebElement> customerPrices = Discount.getCustomerPriceUpdate();
				for (int i = 0; i < customerPrices.size(); i++) {
					String customerData = excel.getDataFromExcel("FixedCustomerPrice", j, i);
					customerPrices.get(i).clear();
					customerPrices.get(i).sendKeys(customerData);

					WebElement Add = Discount.getCompleteAddButton();
					web.scrolltoElement(driver, Add);

				}

			}
			WebElement Add = Discount.getCompleteAddButton();
			web.scrolltoElement(driver, Add);
			Add.click();

			Thread.sleep(5000);
		}

	}

	@Test
	public void _Surcharges() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		PricingObj price = new PricingObj(driver);
		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Pricing_Surcharges_Obj Surcharges = new Pricing_Surcharges_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);

		// -------- Navigate to Pricing → Surcharges --------

		for (int j = 0; j <= 5; j++) {
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();

			web.WaitForElementClick(driver, Surcharges.getSurcharges());
			Surcharges.getSurcharges().click();

			// -------- Click Add Button --------
			WebElement addButton = Discount.getAddbuttton();
			Thread.sleep(2000);
			web.scrolltoElement(driver, addButton);
			web.WaitForElementClick(driver, addButton);
			Thread.sleep(2000);
			addButton.click();
			

			List<WebElement> priceUpdate = Discount.getTextAreaLoactionUpdate();
			List<WebElement> fromDates = Discount.getDateSelectionFROM();
			List<WebElement> toDates = Discount.getDateSelectionTO();

			for (int k = 0; k < priceUpdate.size(); k++) {
                   
				WebElement Recurring = Surcharges.getDropDownRecurring();
				web.selectIndex(Recurring, 1);
                
				// -------- FROM Date (Row-wise) --------
				web.WaitForElementClick(driver, fromDates.get(k));
				fromDates.get(k).click();

				int fromDate = 2 + j;
				booking.selectDate(fromDate);

			
                 
				Thread.sleep(1000);

				// -------- Location Price --------
				String locationPrice = excel.getDataFromExcel("Fixedpickup", j, k);
				priceUpdate.get(k).clear();
				priceUpdate.get(k).sendKeys(locationPrice);

				Thread.sleep(1000);

				// -------- TO Date (Row-wise) --------
				web.WaitForElementClick(driver, toDates.get(k));
				toDates.get(k).click();

				int toDate = fromDate + 2;
				booking.selectDate(toDate);
				
				Thread.sleep(2000);
				
				Thread.sleep(1000);

				// -------- Customer Prices --------
				List<WebElement> customerPrices = Discount.getCustomerPriceUpdate();
				for (int i = 0; i < customerPrices.size(); i++) {
					String customerData = excel.getDataFromExcel("FixedCustomerPrice", j, i);
					customerPrices.get(i).clear();
					customerPrices.get(i).sendKeys(customerData);

					WebElement Add = Discount.getCompleteAddButton();
					web.scrolltoElement(driver, Add);

				}

			}
			WebElement Add = Discount.getCompleteAddButton();
			web.scrolltoElement(driver, Add);
			Add.click();

			Thread.sleep(5000);
		}

	}
	
	
	@Test
	public void Weekly_Surcharges() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		PricingObj price = new PricingObj(driver);
		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Pricing_Surcharges_Obj Surcharges = new Pricing_Surcharges_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);

		// -------- Navigate to Pricing → Surcharges --------

		for (int j = 0; j <= 5; j++) {
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();

			web.WaitForElementClick(driver, Surcharges.getSurcharges());
			Surcharges.getSurcharges().click();

			// -------- Click Add Button --------
			WebElement addButton = Discount.getAddbuttton();
			Thread.sleep(2000);
			web.scrolltoElement(driver, addButton);
			web.WaitForElementClick(driver, addButton);
			Thread.sleep(2000);
			addButton.click();
			

			List<WebElement> priceUpdate = Discount.getTextAreaLoactionUpdate();
			List<WebElement> fromDates = Discount.getDateSelectionFROM();
			List<WebElement> toDates = Discount.getDateSelectionTO();

			for (int k = 0; k < priceUpdate.size(); k++) {
                   
				WebElement Recurring = Surcharges.getDropDownRecurring();
				web.selectIndex(Recurring, 2);
                
				// -------- FROM Date (Row-wise) --------
				web.WaitForElementClick(driver, fromDates.get(k));
				fromDates.get(k).click();

				int fromDate = 2 + j;
				booking.selectDate(fromDate);

			
                 
				Thread.sleep(1000);

				// -------- Location Price --------
				String locationPrice = excel.getDataFromExcel("Fixedpickup", j, k);
				priceUpdate.get(k).clear();
				priceUpdate.get(k).sendKeys(locationPrice);

				Thread.sleep(1000);

				// -------- TO Date (Row-wise) --------
				web.WaitForElementClick(driver, toDates.get(k));
				toDates.get(k).click();

				int toDate = fromDate + 2;
				booking.selectDate(toDate);
				
				Thread.sleep(2000);
				
				Thread.sleep(1000);

				// -------- Customer Prices --------
				List<WebElement> customerPrices = Discount.getCustomerPriceUpdate();
				for (int i = 0; i < customerPrices.size(); i++) {
					String customerData = excel.getDataFromExcel("FixedCustomerPrice", j, i);
					customerPrices.get(i).clear();
					customerPrices.get(i).sendKeys(customerData);

					WebElement Add = Discount.getCompleteAddButton();
					web.scrolltoElement(driver, Add);

				}

			}
			WebElement Add = Discount.getCompleteAddButton();
			web.scrolltoElement(driver, Add);
			Add.click();

			Thread.sleep(5000);
		}

	}
	
	@Test
	public void Daily_Surcharges() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		PricingObj price = new PricingObj(driver);
		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Pricing_Surcharges_Obj Surcharges = new Pricing_Surcharges_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);

		// -------- Navigate to Pricing → Surcharges --------

		for (int j = 0; j <= 5; j++) {
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();

			web.WaitForElementClick(driver, Surcharges.getSurcharges());
			Surcharges.getSurcharges().click();

			// -------- Click Add Button --------
			WebElement addButton = Discount.getAddbuttton();
			Thread.sleep(2000);
			web.scrolltoElement(driver, addButton);
			web.WaitForElementClick(driver, addButton);
			Thread.sleep(2000);
			addButton.click();
			

			List<WebElement> priceUpdate = Discount.getTextAreaLoactionUpdate();
			List<WebElement> fromDates = Discount.getDateSelectionFROM();
			List<WebElement> toDates = Discount.getDateSelectionTO();

			for (int k = 0; k < priceUpdate.size(); k++) {
                   
				WebElement Recurring = Surcharges.getDropDownRecurring();
				web.selectIndex(Recurring, 3);
				
				web.WaitForElementClick(driver, fromDates.get(k));
				fromDates.get(k).click();
				Surcharges.getFromPeriod().click();
				

				// -------- Location Price --------
				String locationPrice = excel.getDataFromExcel("Fixedpickup", j, k);
				priceUpdate.get(k).clear();
				priceUpdate.get(k).sendKeys(locationPrice);

				Thread.sleep(1000);

				// -------- Customer Prices --------
				List<WebElement> customerPrices = Discount.getCustomerPriceUpdate();
				for (int i = 0; i < customerPrices.size(); i++) {
					String customerData = excel.getDataFromExcel("FixedCustomerPrice", j, i);
					customerPrices.get(i).clear();
					customerPrices.get(i).sendKeys(customerData);

					WebElement Add = Discount.getCompleteAddButton();
					web.scrolltoElement(driver, Add);

				}

			}
			WebElement Add = Discount.getCompleteAddButton();
			web.scrolltoElement(driver, Add);
			Add.click();

			Thread.sleep(5000);
		}

	}
}

