package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cabcher.pricing.Distance_pricing_Obj;
import com.cabcher.pricing.Fixed_Pricing;
import com.cabcher.pricing.MeterFareObj;
import com.cabcher.pricing.PricingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;
import gereriUtility.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class MeterFare extends BaseClass {
	MeterFareObj Meterfare;
	public class Distance_PricingTestNG extends BaseClass {

		@Test
		public void Meter_PricingTest_Slab() throws Throwable {

			WebdriverUtility web = new WebdriverUtility();
			Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
			PricingObj price = new PricingObj(driver);
			Excelutility excel = new Excelutility();
			Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
			MeterFareObj Meter=new MeterFareObj(driver);
			

			// ================= GENERAL PRICING =================
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();
			DistancePrice.getGeneralPricing().click();
			Thread.sleep(2000);
			web.selectIndex(Meter.getMeterGeneral(), 0);

			web.WaitForElementClick(driver, DistancePrice.getUpdate());
			WebElement update = DistancePrice.getUpdate();
			web.mousemoveOnElement(driver,update);
			update.click();

			Thread.sleep(2000);

			// ================= OPEN DISTANCE PRICING =================
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();
			Thread.sleep(2000);
			Meter.getMeter().click();
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
					Meter.getMeter().click();
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
	}
	@Test
	public void Meter_PricingTest_Incremental() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		MeterFareObj Meter=new MeterFareObj(driver);
		

		// ================= GENERAL PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		DistancePrice.getGeneralPricing().click();
		Thread.sleep(2000);
		web.selectIndex(Meter.getMeterGeneral(), 1);

		web.WaitForElementClick(driver, DistancePrice.getUpdate());
		WebElement update = DistancePrice.getUpdate();
		web.mousemoveOnElement(driver,update);
		update.click();

		Thread.sleep(2000);

		// ================= OPEN DISTANCE PRICING =================
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		Thread.sleep(2000);
		Meter.getMeter().click();
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
				Meter.getMeter().click();
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
}

	/*
	 * @Test public void MeterFareAdding() throws Throwable {
	 * 
	 * WebdriverUtility web = new WebdriverUtility(); PricingObj price = new
	 * PricingObj(driver); Meterfare = new MeterFareObj(driver); Excelutility excel
	 * = new Excelutility();
	 * 
	 * // Navigate to Pricing WebElement priceButton = price.getPricing();
	 * web.WaitForElementClick(driver, priceButton); priceButton.click();
	 * 
	 * // Navigate to Meter WebElement meter = Meterfare.getMeter();
	 * web.WaitForElementClick(driver, meter); meter.click();
	 * 
	 * // Run same process 5 times with different Excel data for (int j = 0; j < 5;
	 * j++) {
	 * 
	 * Thread.sleep(2000);
	 * 
	 * WebElement addButton = Meterfare.getAdd(); web.WaitForElementClick(driver,
	 * addButton); addButton.click();
	 * 
	 * List<WebElement> carList = Meterfare.getCarlist();
	 * 
	 * if (carList != null && !carList.isEmpty()) { for (int i = 0; i <
	 * carList.size(); i++) { WebElement car = carList.get(i); Thread.sleep(1000);
	 * // ✅ Get data from different row each loop String data =
	 * excel.getDataFromExcel("Meterfare1", j, i); car.clear(); car.sendKeys(data);
	 * Thread.sleep(1000); } // }
	 * 
	 * // Click update after filling the form Meterfare.getUpdate().click();
	 * Thread.sleep(1000);
	 * 
	 * }
	 * 
	 * Thread.sleep(15000); } }
	 * 
	 * @Test public void MeterFareGeneral1() throws Throwable { WebdriverUtility web
	 * = new WebdriverUtility(); PricingObj price = new PricingObj(driver); // use
	 * inherited driver Meterfare = new MeterFareObj(driver); Excelutility excel =
	 * new Excelutility(); WebElement priceButton = price.getPricing(); //
	 * getPricingButton() was wrong web.WaitForElementClick(driver, priceButton); //
	 * now WebElement is not null priceButton.click();
	 * 
	 * WebElement meter = Meterfare.getMeter(); web.WaitForElementClick(driver,
	 * meter); meter.click();
	 * 
	 * MeterFareGeneralsetting MeterGeneral = new MeterFareGeneralsetting(driver);
	 * WebElement Setting = MeterGeneral.getSettings();
	 * web.WaitForElementClick(driver, Setting); Setting.click();
	 * 
	 * List<WebElement> Meterfaresetting = MeterGeneral.getMeterFaresetting(); if
	 * (Meterfaresetting != null && !Meterfaresetting.isEmpty()) { for (int i = 0; i
	 * < Meterfaresetting.size(); i++) {
	 * 
	 * WebElement Meter = Meterfaresetting.get(i); String data =
	 * excel.getDataFromExcel("MeterFareSettings", 1, i); Meter.clear();
	 * Meter.sendKeys(data); }
	 * 
	 * }}
	 */
	
