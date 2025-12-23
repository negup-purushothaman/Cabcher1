package Com.ComCast.crm.LoginTestNG;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtlity.MeterFareGeneralsetting;
import com.comcast.crm.ObjectRepositoryUtlity.MeterFareObj;
import com.comcast.crm.ObjectRepositoryUtlity.PricingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class MeterFare extends BaseClass {
	MeterFareObj Meterfare;

	@Test
	public void MeterFareAdding() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		PricingObj price = new PricingObj(driver);
		Meterfare = new MeterFareObj(driver);
		Excelutility excel = new Excelutility();

		// Navigate to Pricing
		WebElement priceButton = price.getPricing();
		web.WaitForElementClick(driver, priceButton);
		priceButton.click();

		// Navigate to Meter
		WebElement meter = Meterfare.getMeter();
		web.WaitForElementClick(driver, meter);
		meter.click();

		// Run same process 5 times with different Excel data
		for (int j = 0; j < 5; j++) {

			Thread.sleep(2000);

			WebElement addButton = Meterfare.getAdd();
			web.WaitForElementClick(driver, addButton);
			addButton.click();

			List<WebElement> carList = Meterfare.getCarlist();

			if (carList != null && !carList.isEmpty()) {
				for (int i = 0; i < carList.size(); i++) {
					WebElement car = carList.get(i);
					Thread.sleep(1000);
					// ✅ Get data from different row each loop
					String data = excel.getDataFromExcel("Meterfare1", j, i);
					car.clear();
					car.sendKeys(data);
					Thread.sleep(1000);
				}
				// }

				// Click update after filling the form
				Meterfare.getUpdate().click();
				Thread.sleep(1000);

			}

			Thread.sleep(15000);
		}
	}

	@Test
	public void MeterFareGeneral1() throws Throwable {
		WebdriverUtility web = new WebdriverUtility();
		PricingObj price = new PricingObj(driver); // use inherited driver
		Meterfare = new MeterFareObj(driver);
		Excelutility excel = new Excelutility();
		WebElement priceButton = price.getPricing(); // getPricingButton() was wrong
		web.WaitForElementClick(driver, priceButton); // now WebElement is not null
		priceButton.click();
		WebElement meter = Meterfare.getMeter();
		web.WaitForElementClick(driver, meter);
		meter.click();
		MeterFareGeneralsetting MeterGeneral = new MeterFareGeneralsetting(driver);
		WebElement Setting = MeterGeneral.getSettings();
		web.WaitForElementClick(driver, Setting);
		Setting.click();
		List<WebElement> Meterfaresetting = MeterGeneral.getMeterFaresetting();
		if (Meterfaresetting != null && !Meterfaresetting.isEmpty()) {
			for (int i = 0; i < Meterfaresetting.size(); i++) {

				WebElement Meter = Meterfaresetting.get(i);
				String data = excel.getDataFromExcel("MeterFareSettings",1, i);
				Meter.clear();
				Meter.sendKeys(data);
			}

		}

	}

}