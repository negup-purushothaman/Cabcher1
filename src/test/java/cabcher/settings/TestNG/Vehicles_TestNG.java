package cabcher.settings.TestNG;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cabcher.pricing.Distance_pricing_Obj;
import com.cabcher.pricing.Fixed_Pricing;
import com.cabcher.pricing.PricingObj;
import com.cacbcher.settings.NameBoard_Obj;
import com.cacbcher.settings.Vehicles_Obj;
import com.cacbcher.settings.com_cabcher_Email;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Vehicles_TestNG extends BaseClass {

	@Test
	public void Setting_Nameboard() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility Excel = new Excelutility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		com_cabcher_Email Setting_Email = new com_cabcher_Email(driver);
		NameBoard_Obj cabcherNameboard = new NameBoard_Obj(driver);
		Vehicles_Obj Vehicles_Setting = new Vehicles_Obj(driver);

		for (int i = 0; i < 3; i++) {

			WebElement settings = cabcherNameboard.getSettings();
			web.scrolltoElement(driver, settings);
			Thread.sleep(2000);
			settings.click();

			WebElement Vehicles = Vehicles_Setting.getVehicles();
			Thread.sleep(2000);
			Vehicles.click();

			WebElement Addnew = Vehicles_Setting.getAddNew();
			web.WaitForElementClick(driver, Addnew);
			Addnew.click();

			List<WebElement> FromEmail = Vehicles_Setting.getPriority();

			String data = Excel.getDataFromExcel("Setting_Vehicles", i, 0);

			Thread.sleep(2000);
			FromEmail.get(0).clear();
			FromEmail.get(0).sendKeys(data);
			List<WebElement> VechicleName = Vehicles_Setting.getVechicleName();
			String  VechicleName_Data= Excel.getDataFromExcel("Setting_Vehicles", i, 1);
			VechicleName.get(0).sendKeys(VechicleName_Data);
			

		}
	}
}
