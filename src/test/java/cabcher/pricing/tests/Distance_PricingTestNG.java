package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.cabcher.pricing.Distance_pricing_Obj;
import com.cabcher.pricing.Fixed_Pricing;
import com.cabcher.pricing.PricingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Distance_PricingTestNG extends BaseClass {

	@Test
	public void Distance_PricingTest_Slab() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);

		// ================= GENERAL PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		DistancePrice.getGeneralPricing().click();
		Thread.sleep(2000);
		web.selectIndex(DistancePrice.getJourneyFare(), 0);

		web.WaitForElementClick(driver, DistancePrice.getUpdate());
		WebElement update = DistancePrice.getUpdate();
		web.mousemoveOnElement(driver,update);
		update.click();

		Thread.sleep(2000);

		// ================= OPEN DISTANCE PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		Thread.sleep(2000);
		DistancePrice.getDistance().click();
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
		//Thread.sleep(2000);
		String[][] excelData = new String[loopCount][priceFieldCount];

		for (int r = 0; r < loopCount; r++) {
			for (int c = 0; c < priceFieldCount; c++) {
				excelData[r][c] = excel.getDataFromExcel("Meterfare1", r, c);
			}
		}
		//Thread.sleep(2000);
		// ================= MAIN LOOP =================
		for (int j = 0; j < loopCount; j++) {

			if (j > 0) {
				web.WaitForElementClick(driver, price.getPricing());
				price.getPricing().click();
				Thread.sleep(2000);
				DistancePrice.getDistance().click();
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
				//Thread.sleep(2000);
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
	public void Distance_PricingTest_Incremental() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);

		// ================= GENERAL PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		DistancePrice.getGeneralPricing().click();
		Thread.sleep(2000);
		web.selectIndex(DistancePrice.getJourneyFare(), 1);

		web.WaitForElementClick(driver, DistancePrice.getUpdate());
		WebElement update = DistancePrice.getUpdate();
		web.mousemoveOnElement(driver,update);
		update.click();

		Thread.sleep(2000);

		// ================= OPEN DISTANCE PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		Thread.sleep(2000);
		DistancePrice.getDistance().click();
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
		//Thread.sleep(2000);
		String[][] excelData = new String[loopCount][priceFieldCount];

		for (int r = 0; r < loopCount; r++) {
			for (int c = 0; c < priceFieldCount; c++) {
				excelData[r][c] = excel.getDataFromExcel("Meterfare1", r, c);
			}
		}
		//Thread.sleep(2000);
		// ================= MAIN LOOP =================
		for (int j = 0; j < loopCount; j++) {

			if (j > 0) {
				web.WaitForElementClick(driver, price.getPricing());
				price.getPricing().click();
				Thread.sleep(2000);
				DistancePrice.getDistance().click();
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
				//Thread.sleep(2000);
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
	public void Distance_PricingTimeSlot_GeneralPrice() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj distancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		//Driver_Pricing_obj driverPricing = new Driver_Pricing_obj(driver);
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);

		/* ===================== GENERAL PRICING / DRIVER FARE ===================== */
		for (int run = 1; run <= 1; run++) {

			// ---- Go to General Pricing ----
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();
			distancePrice.getGeneralPricing().click();

			// ---- Select Driver Fare ----
			Thread.sleep(2000);
			WebElement journeyFare = distancePrice.getJourneyFare();
			web.selectIndex(journeyFare, run);
			Thread.sleep(2000);
			WebElement update = distancePrice.getUpdate();
			web.mousemoveOnElement(driver, update);
			update.click();
			System.out.println("General Pricing Execution : " + run);

			/* ===================== DRIVER PRICING ===================== */

			// Navigate ONCE to Driver Pricing
			Thread.sleep(2000);
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();
			Thread.sleep(2000);
			web.WaitForElementClick(driver, distancePrice.getDistance());
			Thread.sleep(2000);
			distancePrice.getDistance().click();
			Thread.sleep(2000);
			// Get dropdown size ONCE
			WebElement timeSlotElement = fixedPrice.getTimeSlot();
			Select select = new Select(timeSlotElement);
			int optionCount = select.getOptions().size();

			System.out.println("Total Time Slots : " + optionCount);

			// Loop based on DROPDOWN, not Excel
			for (int j = 0; j < optionCount; j++) {

				Thread.sleep(2000);
				web.WaitForElementClick(driver, price.getPricing());
				price.getPricing().click();
				Thread.sleep(2000);
				web.WaitForElementClick(driver, distancePrice.getDistance());
				Thread.sleep(2000);
				distancePrice.getDistance().click();
				Thread.sleep(2000);
				web.WaitForElementClick(driver, fixedPrice.getAddButton());
				fixedPrice.getAddButton().click();

				web.selectIndex(timeSlotElement, j);
				System.out.println("Time slot selected index : " + j);

				// ---- Pricing input ----
				List<WebElement> customerPrices = distancePrice.getcustomprice();
				for (int i = 0; i < customerPrices.size(); i++) {
					String data = excel.getDataFromExcel("Meterfare1", j, i);
					customerPrices.get(i).clear();
					customerPrices.get(i).sendKeys(data);
				}

				fixedPrice.getUpdate().click();
			}
			System.out.println("Time slot completed → moving to next Driver Fare\n");
		}
	}
@Test
	public void Distance_PricingTestNG1() throws Throwable {

	    WebdriverUtility web = new WebdriverUtility();
	    Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
	    PricingObj price = new PricingObj(driver);
	    Excelutility Excel = new Excelutility();
	    Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);

	    // ---------- Navigate to General Pricing ----------
	    web.WaitForElementClick(driver, price.getPricing());
	    price.getPricing().click();

	    DistancePrice.getGeneralPricing().click();

	    WebElement journeyFare = DistancePrice.getJourneyFare();
	    web.selectIndex(journeyFare, 1);

	    WebElement update = DistancePrice.getUpdate();
	    web.mousemoveOnElement(driver, update);
	    update.click();

	  //  web.waitForPageLoad(driver);

	    // ---------- Excel Row Count ----------
	    int rowCount = Excel.getRowCount("Fixedpickup");

	    // ---------- Loop for Each Time Slot ----------
	    for (int j = 0; j < rowCount; j++) {

	        web.WaitForElementClick(driver, price.getPricing());
	        price.getPricing().click();

	        DistancePrice.getDistance().click();
	        fixedPrice.getAddButton().click();

	        // ---------- Time Slot Handling ----------
	        try {
	            WebElement timeSlot = fixedPrice.getTimeSlot();
	            //web.waitForVisibility(driver, timeSlot);

	            if (timeSlot.isDisplayed() && timeSlot.isEnabled()) {
	                Select select = new Select(timeSlot);
	                int optionCount = select.getOptions().size();

	                if (optionCount > 0 && j < optionCount) {
	                    select.selectByIndex(j);
	                    System.out.println("✅ Time slot selected at index: " + j);
	                } else {
	                    System.out.println("⚠ Time slot index not available, skipping selection");
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("⚠ Time slot not available in UI, continuing flow");
	        }

	        // ---------- Customer Price Entry ----------
	        List<WebElement> customerPrices = DistancePrice.getcustomprice();

	        for (int i = 0; i < customerPrices.size(); i++) {
	            String data = Excel.getDataFromExcel("Meterfare1", j, i);
	            WebElement priceField = customerPrices.get(i);
	            priceField.clear();
	            priceField.sendKeys(data);
	        }

	        // ---------- Update ----------
	        fixedPrice.getUpdate().click();
	      
	    }
	}

	
	
}
