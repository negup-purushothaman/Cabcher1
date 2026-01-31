package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.cabcher.pricing.Fixed_Pricing;
import com.cabcher.pricing.PricingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class FixedPricingTestNG extends BaseClass {

	@Test
	public void FixedPricing() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();

		// Navigate to Fixed Pricing
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		fixedPrice.getFixed_pricing().click();

		// 🔁 SAME TEST – RUN 5 TIMES WITH DIFFERENT DATA
		for (int run = 1; run <= 3; run++) {

			System.out.println("Running Test Iteration : " + run);
			Thread.sleep(2000);

			// ➕ Click Add Button
			fixedPrice.getAddButton().click();
			Thread.sleep(2000);

			// 📄 Pickup & Drop (Different row each run)
			String pickupData = excel.getDataFromExcel("Fixedpickup", run, 1);
			String dropoffData = excel.getDataFromExcel("Fixedpickup", run, 2);

			WebElement pickup = fixedPrice.getPickuplocation();
			pickup.clear();
			pickup.sendKeys(pickupData);

			WebElement dropoff = fixedPrice.getDropOff();
			dropoff.clear();
			dropoff.sendKeys(dropoffData);

			// 🚗 Customer Price (row = run)
			List<WebElement> customerPrices = fixedPrice.getFixedCustomerPrice();
			for (int i = 0; i < customerPrices.size(); i++) {
				String data = excel.getDataFromExcel("Meterfare1", run, i);
				WebElement car = customerPrices.get(i);
				car.clear();
				car.sendKeys(data);
			}

			// 🚕 Driver Price (row = run)
			List<WebElement> driverPrices = fixedPrice.getDriverPrice();
			for (int i = 0; i < driverPrices.size(); i++) {
				String data = excel.getDataFromExcel("Meterfare1", run, i);
				WebElement car = driverPrices.get(i);
				car.clear();
				car.sendKeys(data);
			}

			// ✅ Submit
			fixedPrice.getUpdate().click();
			Thread.sleep(3000);
		}
	}

	@Test
	public void TimingFixedPrice() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();

		// Navigate to Fixed Pricing
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		fixedPrice.getFixed_pricing().click();
		int rowCount = excel.getRowCount("Fixedpickup");
		for (int run = 0; run <= rowCount; run++) {

			System.out.println("Running Test Iteration : " + run);
			Thread.sleep(2000);

			// ➕ Click Add Button
			fixedPrice.getAddButton().click();
			Thread.sleep(2000);
			WebElement timeSlot = fixedPrice.getTimeSlot();
               
			if (timeSlot.isDisplayed() && timeSlot.isEnabled()) {
			    Select select = new Select(timeSlot);
			    if (select.getOptions().size() > run) {
			        web.selectIndex(timeSlot, run);
			    } else {
			        System.out.println("No time slots available, skipping selection");
			    }
			} else {
			    System.out.println("Time slot element not available, continuing script");
			}


			// 📄 Pickup & Drop (Different row each run)
			String pickupData = excel.getDataFromExcel("Fixedpickup", run, 0);
			String dropoffData = excel.getDataFromExcel("Fixedpickup", run, 1);

			WebElement pickup = fixedPrice.getPickuplocation();
			pickup.clear();
			pickup.sendKeys(pickupData);

			WebElement dropoff = fixedPrice.getDropOff();
			dropoff.clear();
			dropoff.sendKeys(dropoffData);

			// 🚗 Customer Price (row = run)
			List<WebElement> customerPrices = fixedPrice.getFixedCustomerPrice();
			for (int i = 0; i < customerPrices.size(); i++) {
				String data = excel.getDataFromExcel("Meterfare1", run, i);
				WebElement car = customerPrices.get(i);
				car.clear();
				car.sendKeys(data);
			}

			// 🚕 Driver Price (row = run)
			List<WebElement> driverPrices = fixedPrice.getDriverPrice();
			for (int i = 0; i < driverPrices.size(); i++) {
				String data = excel.getDataFromExcel("Meterfare1", run, i);
				WebElement car = driverPrices.get(i);
				car.clear();
				car.sendKeys(data);
			}

			// ✅ Submit
			fixedPrice.getUpdate().click();
			Thread.sleep(3000);
		}
	}

	@Test
	public void CopyPricing() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		PricingObj price = new PricingObj(driver);
		//Excelutility excel = new Excelutility();

		// Navigate to Fixed Pricing
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		fixedPrice.getFixed_pricing().click();
		for (int run = 0; run <= 10; run++) {

			System.out.println("Running Test Iteration : " + run);
			Thread.sleep(2000);

			// ➕ Click Add Button
			fixedPrice.getAddButton().click();
			Thread.sleep(2000);

			WebElement timeSlot = fixedPrice.CopyPricingTimefrom();
			//String indexes = excel.getDataFromExcel("Fixedpickup", run, 0);

			web.selectIndex(timeSlot, run);

		}

	}

	@Test
	public void AccountPrice() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();

		// Navigate to Fixed Pricing
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		fixedPrice.getFixed_pricing().click();

		for (int account = 1; account <= 10; account++) {

			WebElement Accountprice = fixedPrice.getAccountPrice();
			
			web.selectIndex(Accountprice, account);

			for (int run = 0; run <= 10; run++) {

				System.out.println("Running Test Iteration : " + run);
				Thread.sleep(2000);

				// ➕ Click Add Button
				fixedPrice.getAddButton().click();
				Thread.sleep(2000);
				WebElement timeSlot = fixedPrice.getTimeSlot();
				//String indexes = excel.getDataFromExcel("Fixedpickup", run, 0);

				web.selectIndex(timeSlot, run);

				// 📄 Pickup & Drop (Different row each run)
				String pickupData = excel.getDataFromExcel("Fixedpickup", run, 0);
				String dropoffData = excel.getDataFromExcel("Fixedpickup", run, 1);

				WebElement pickup = fixedPrice.getPickuplocation();
				pickup.clear();
				pickup.sendKeys(pickupData);

				WebElement dropoff = fixedPrice.getDropOff();
				dropoff.clear();
				dropoff.sendKeys(dropoffData);

				// 🚗 Customer Price (row = run)
				List<WebElement> customerPrices = fixedPrice.getFixedCustomerPrice();
				for (int i = 0; i < customerPrices.size(); i++) {
					String data = excel.getDataFromExcel("Meterfare1", run, i);
					WebElement car = customerPrices.get(i);
					car.clear();
					car.sendKeys(data);
				}

				// 🚕 Driver Price (row = run)
				List<WebElement> driverPrices = fixedPrice.getDriverPrice();
				for (int i = 0; i < driverPrices.size(); i++) {
					String data = excel.getDataFromExcel("Meterfare1", run, i);
					WebElement car = driverPrices.get(i);
					car.clear();
					car.sendKeys(data);
				}

				// ✅ Submit
				fixedPrice.getUpdate().click();
				Thread.sleep(3000);
			}

		}
	}
}
