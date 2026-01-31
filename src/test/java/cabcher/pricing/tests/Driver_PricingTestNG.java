package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import com.cabcher.pricing.Distance_pricing_Obj;
import com.cabcher.pricing.Driver_Pricing_obj;
import com.cabcher.pricing.Fixed_Pricing;
import com.cabcher.pricing.PricingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Driver_PricingTestNG extends BaseClass {
	@Test
	public void Driver_PricingTestNG_Slab_Incremental() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility Excel = new Excelutility();
		Driver_Pricing_obj Driver = new Driver_Pricing_obj(driver);
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);

		for (int run = 1; run <= 2; run++) {

			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();
			
			WebElement GeneralPricing = DistancePrice.getGeneralPricing();
			web.WaitForElementClick(driver, GeneralPricing);
			GeneralPricing.click();
			WebElement JourneyFare = Driver.getDriverFare();
			web.selectIndex(JourneyFare, run);
			Thread.sleep(1000);
			WebElement update = DistancePrice.getUpdate();

			web.mousemoveOnElement(driver, update);
			update.click();
			System.out.println("Running Test Iteration : " + run);
			Thread.sleep(3000);
			// int rowCount = Excel.getRowCount("Fixedpickup");
			Thread.sleep(2000);

			for (int j = 0; j < 3; j++) {

				web.WaitForElementClick(driver, price.getPricing());
				price.getPricing().click();
				Thread.sleep(2000);
				web.WaitForElementClick(driver, Driver.getDriverModule());
				Driver.getDriverModule().click();
				Thread.sleep(2000);
				web.WaitForElementClick(driver, fixedPrice.getAddButton());
				fixedPrice.getAddButton().click();
				Thread.sleep(2000);

				try {
					WebElement timeSlot = fixedPrice.getTimeSlot();

					if (timeSlot != null && timeSlot.isDisplayed() && timeSlot.isEnabled()) {

						Select select = new Select(timeSlot);
						int optionCount = select.getOptions().size();

						// ✅ Skip dropdown when options are finished
						if (j < optionCount) {
							web.selectIndex(timeSlot, j);
							System.out.println("Time slot selected at index: " + j);
						} else {
							System.out.println("Time slot options completed. Skipping dropdown selection.");
						}
					}
				} catch (Exception e) {
					System.out.println("Time slot not available. Continuing without selection.");
				}

				// ✅ Pricing continues always
				List<WebElement> customerPrices = DistancePrice.getcustomprice();
				for (int i = 0; i < customerPrices.size(); i++) {
					String data = Excel.getDataFromExcel("Meterfare1", j, i);
					WebElement car = customerPrices.get(i);
					car.clear();
					car.sendKeys(data);
				}

				fixedPrice.getUpdate().click();

				Thread.sleep(2000);
			}

		}
	}

	@Test
	public void Driver_PricingTestNG_Slab() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		Driver_Pricing_obj Driver = new Driver_Pricing_obj(driver);
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);

		// ================= GENERAL PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		DistancePrice.getGeneralPricing().click();
		Thread.sleep(2000);
		web.selectIndex(Driver.getDriverFare(), 1);

		web.WaitForElementClick(driver, DistancePrice.getUpdate());
		WebElement update = DistancePrice.getUpdate();
		web.mousemoveOnElement(driver, update);
		update.click();

		Thread.sleep(2000);

		// ================= OPEN DISTANCE PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		Thread.sleep(2000);
		Driver.getDriverModule().click();
		Thread.sleep(2000);

		fixedPrice.getAddButton().click();

		// ================= DETECT TIME SLOT =================
		int loopCount = 1;
		boolean isTimeSlotAvailable = false;

		try {
			WebElement timeSlot = fixedPrice.getTimeSlot();
			// web.waitForVisibility(driver, timeSlot);
			Thread.sleep(2000);
			Select select = new Select(timeSlot);
			loopCount = select.getOptions().size();
			isTimeSlotAvailable = true;
			Thread.sleep(2000);
			System.out.println("Time slot count: " + loopCount);
		} catch (Exception e) {
			System.out.println("Normal pricing flow (No time slot)");
		}

		// ================= READ EXCEL ONCE =================
		List<WebElement> customerPrices = DistancePrice.getcustomprice();
		int priceFieldCount = customerPrices.size();
		// Thread.sleep(2000);
		String[][] excelData = new String[loopCount][priceFieldCount];

		for (int r = 0; r < loopCount; r++) {
			for (int c = 0; c < priceFieldCount; c++) {
				excelData[r][c] = excel.getDataFromExcel("Meterfare1", r, c);
			}
		}
		// Thread.sleep(2000);
		// ================= MAIN LOOP =================
		for (int j = 0; j < loopCount; j++) {

			if (j > 0) {
				web.WaitForElementClick(driver, price.getPricing());
				price.getPricing().click();
				Thread.sleep(2000);
				Driver.getDriverModule().click();
				Thread.sleep(2000);
				web.WaitForElementClick(driver, fixedPrice.getAddButton());
				fixedPrice.getAddButton().click();
			}

			// ===== Select Time Slot =====
			if (isTimeSlotAvailable) {
				Thread.sleep(2000);
				Select select = new Select(fixedPrice.getTimeSlot());
				select.selectByIndex(j);
			}

			// ===== Enter Prices (FAST - memory read) =====
			customerPrices = DistancePrice.getcustomprice();

			for (int i = 0; i < customerPrices.size(); i++) {
				// Thread.sleep(2000);
				WebElement priceField = customerPrices.get(i);
				priceField.clear();
				priceField.sendKeys(excelData[j][i]);
			}

			web.WaitForElementClick(driver, fixedPrice.getUpdate());
			fixedPrice.getUpdate().click();
			Thread.sleep(2000);
		}
	}

	@Test
	public void Driver_PricingTestNG_Incremental() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		Driver_Pricing_obj Driver = new Driver_Pricing_obj(driver);
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);

		// ================= GENERAL PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		DistancePrice.getGeneralPricing().click();
		Thread.sleep(2000);
		web.selectIndex(Driver.getDriverFare(), 2);

		web.WaitForElementClick(driver, DistancePrice.getUpdate());
		WebElement update = DistancePrice.getUpdate();
		web.mousemoveOnElement(driver, update);
		update.click();

		Thread.sleep(2000);

		// ================= OPEN DISTANCE PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		Thread.sleep(2000);
		Driver.getDriverModule().click();
		Thread.sleep(2000);

		fixedPrice.getAddButton().click();

		// ================= DETECT TIME SLOT =================
		int loopCount = 1;
		boolean isTimeSlotAvailable = false;

		try {
			WebElement timeSlot = fixedPrice.getTimeSlot();
			// web.waitForVisibility(driver, timeSlot);
			Thread.sleep(2000);
			Select select = new Select(timeSlot);
			loopCount = select.getOptions().size();
			isTimeSlotAvailable = true;
			Thread.sleep(2000);
			System.out.println("Time slot count: " + loopCount);
		} catch (Exception e) {
			System.out.println("Normal pricing flow (No time slot)");
		}

		// ================= READ EXCEL ONCE =================
		List<WebElement> customerPrices = DistancePrice.getcustomprice();
		int priceFieldCount = customerPrices.size();
		// Thread.sleep(2000);
		String[][] excelData = new String[loopCount][priceFieldCount];

		for (int r = 0; r < loopCount; r++) {
			for (int c = 0; c < priceFieldCount; c++) {
				excelData[r][c] = excel.getDataFromExcel("Meterfare1", r, c);
			}
		}
		// Thread.sleep(2000);
		// ================= MAIN LOOP =================
		for (int j = 0; j < loopCount; j++) {

			if (j > 0) {
				web.WaitForElementClick(driver, price.getPricing());
				price.getPricing().click();
				Thread.sleep(2000);
				Driver.getDriverModule().click();
				Thread.sleep(2000);
				web.WaitForElementClick(driver, fixedPrice.getAddButton());
				fixedPrice.getAddButton().click();
			}

			// ===== Select Time Slot =====
			if (isTimeSlotAvailable) {
				Thread.sleep(2000);
				Select select = new Select(fixedPrice.getTimeSlot());
				select.selectByIndex(j);
			}

			// ===== Enter Prices (FAST - memory read) =====
			customerPrices = DistancePrice.getcustomprice();

			for (int i = 0; i < customerPrices.size(); i++) {
				// Thread.sleep(2000);
				WebElement priceField = customerPrices.get(i);
				priceField.clear();
				priceField.sendKeys(excelData[j][i]);
			}

			web.WaitForElementClick(driver, fixedPrice.getUpdate());
			fixedPrice.getUpdate().click();
			Thread.sleep(2000);
		}
	}

}
