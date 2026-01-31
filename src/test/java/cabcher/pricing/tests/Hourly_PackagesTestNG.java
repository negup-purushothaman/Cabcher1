package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.cabcher.pricing.Hourly_Packages_Obj;
import com.cabcher.pricing.PricingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Hourly_PackagesTestNG extends BaseClass {

	@Test
	public void Hourly_packges() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		//Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		Hourly_Packages_Obj Hourly = new Hourly_Packages_Obj(driver);

		for (int j = 0; j < 5; j++) {

			Thread.sleep(2000);
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();
			Thread.sleep(2000);
			web.WaitForElementClick(driver, Hourly.getHourlyPackages());
			Thread.sleep(2000);
			Hourly.getHourlyPackages().click();
			Thread.sleep(2000);
			web.WaitForElementClick(driver, Hourly.getAddNew());
			Hourly.getAddNew().click();
			Thread.sleep(2000);
			// ---- Pricing input ----
			List<WebElement> customerPrices = Hourly.getCustomerPrice();
			for (int i = 0; i < customerPrices.size(); i++) {
				String data = excel.getDataFromExcel("Meterfare1", j, i);
				customerPrices.get(i).clear();
				customerPrices.get(i).sendKeys(data);
			}

			Thread.sleep(2000);
			web.WaitForElementClick(driver, Hourly.getAddButton());
			Hourly.getAddButton().click();
			Thread.sleep(2000);
			System.out.println("Time slot completed → moving to next Driver Fare\n");
		}
	}
}
