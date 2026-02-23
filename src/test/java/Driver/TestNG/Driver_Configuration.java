package Driver.TestNG;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cabcher.pricing.Distance_pricing_Obj;
import com.cabcher.pricing.Fixed_Pricing;
import com.cabcher.pricing.PricingObj;
import com.comcast.crm.ObjectRepositoryUtlity.Driver_Configuration_Obj;
import com.comcast.crm.ObjectRepositoryUtlity.Driver_Register_Obj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Driver_Configuration extends BaseClass {

	@Test
	public void DriverConfig() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Excelutility Excel = new Excelutility();
		Driver_Configuration_Obj configuration = new Driver_Configuration_Obj(driver);
		Driver_Register_Obj Driver_register = new Driver_Register_Obj(driver);

		web.WaitForElementClick(driver, Driver_register.getDriverDropdown());
		Driver_register.getDriverDropdown().click();
		WebElement Driverconfig = configuration.getDriverConfig();
		web.WaitForElementClick(driver, Driverconfig);
		Driverconfig.click();
		List<WebElement> profile=configuration.getProfilePicture();
		web.WaitForElementClick(driver, profile.get(0));
		web.selectIndex(profile.get(0), 1);
	
		List<WebElement> Address=configuration.getAddress();
		web.WaitForElementClick(driver, Address.get(0));
		web.selectIndex(Address.get(0), 1);
	
		List<WebElement> DOB=configuration.getDOB();
		web.WaitForElementClick(driver, DOB.get(0));
		web.selectIndex(DOB.get(0), 1);
		
	}

}
