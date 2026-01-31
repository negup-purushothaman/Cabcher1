package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cabcher.pricing.Extra_Services_Obj;
import com.cabcher.pricing.Hourly_Packages_Obj;
import com.cabcher.pricing.Location_Category_Pricing_Obj;
import com.cabcher.pricing.PricingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Extra_ServicesTestNG extends BaseClass {

	@Test
	public void Extra_Services_NO() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		Extra_Services_Obj Extra = new Extra_Services_Obj(driver);
		// Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		Location_Category_Pricing_Obj Location = new Location_Category_Pricing_Obj(driver);
		Hourly_Packages_Obj Hourly = new Hourly_Packages_Obj(driver);
		for (int j = 0; j < 0; j++) {
			Thread.sleep(2000); 
			web.WaitForElementClick(driver, price.getPricing());
			// Thread.sleep(2000);
			price.getPricing().click(); 
			web.WaitForElementClick(driver, Extra.getExtraServices());
			Thread.sleep(2000);
			Extra.getExtraServices().click();
			Thread.sleep(2000);
			Hourly.getAddNew().click();

			// ---- Pricing input ----
			List<WebElement> customerPrices = Location.getPickupDropoffupdate();
			for (int i = 0; i < customerPrices.size(); i++) {
				String data = excel.getDataFromExcel("ExtraServicesNO", j, i);

				customerPrices.get(i).clear();
				customerPrices.get(i).sendKeys(data);
			}

			Thread.sleep(2000);
			web.WaitForElementClick(driver, Extra.getAdd());
			Extra.getAdd().click();
			Thread.sleep(2000);
			System.out.println("Time slot completed → moving to next Driver Fare\n");
		}

	}

	@Test
	public void Extra_Services_YES() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		PricingObj price = new PricingObj(driver);
		Excelutility excel = new Excelutility();
		Extra_Services_Obj Extra = new Extra_Services_Obj(driver);
		// Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		Location_Category_Pricing_Obj Location = new Location_Category_Pricing_Obj(driver);
		Hourly_Packages_Obj Hourly = new Hourly_Packages_Obj(driver);
		for (int j = 0; j < 0; j++) {

			Thread.sleep(2000);
			web.WaitForElementClick(driver, price.getPricing());
			// Thread.sleep(2000);
			price.getPricing().click();
			web.WaitForElementClick(driver, Extra.getExtraServices());
			Thread.sleep(2000);
			Extra.getExtraServices().click();
			Thread.sleep(2000);
			Hourly.getAddNew().click();

			// ---- Pricing input ----
			List<WebElement> customerPrices = Extra.getCustomPriceYES();
			for (int i = 0; i < customerPrices.size(); i++) {
				String data = excel.getDataFromExcel("ExtraServicesYES", j, i);

				customerPrices.get(i).clear();
				WebElement CustomPrice = Extra.getCustomPriceSelect();
				web.selectIndex(CustomPrice, 1);
				customerPrices.get(i).sendKeys(data);
			}

			Thread.sleep(2000);
			web.WaitForElementClick(driver, Extra.getAdd());
			Extra.getAdd().click();
			Thread.sleep(1000);
			System.out.println("Time slot completed → moving to next Driver Fare\n");
		}

	}

}
