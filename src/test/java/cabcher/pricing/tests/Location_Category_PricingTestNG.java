package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cabcher.pricing.Location_Category_Pricing_Obj;
import com.cabcher.pricing.PricingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Location_Category_PricingTestNG extends BaseClass {

	
	@Test
	public void Hourly_packges() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		//Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		Location_Category_Pricing_Obj Location=new Location_Category_Pricing_Obj(driver);

	for (int j = 0; j < 2; j++) {

		Thread.sleep(2000);
		web.WaitForElementClick(driver, price.getPricing());
		price.getPricing().click();
		Thread.sleep(2000);
		web.WaitForElementClick(driver,Location.getLocation());
		Thread.sleep(2000);
		Location.getLocation().click();
		Thread.sleep(2000);
		
		// ---- Pricing input ----
		List<WebElement> customerPrices = Location.getPickupDropoffupdate();
		for (int i = 0; i < customerPrices.size(); i++) {
			String data = excel.getDataFromExcel("Meterfare1", j, i);
			customerPrices.get(i).clear();
			customerPrices.get(i).sendKeys(data);
		}

		Thread.sleep(2000);
		web.WaitForElementClick(driver,Location.getUpdate());
		Location.getUpdate().click();
		Thread.sleep(2000);
		System.out.println("Time slot completed → moving to next Driver Fare\n");
	}
	
	}
	
	
	
}
