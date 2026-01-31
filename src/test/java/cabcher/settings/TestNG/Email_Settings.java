package cabcher.settings.TestNG;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cabcher.pricing.Distance_pricing_Obj;
import com.cabcher.pricing.Fixed_Pricing;
import com.cabcher.pricing.PricingObj;
import com.cacbcher.settings.NameBoard_Obj;
import com.cacbcher.settings.com_cabcher_Email;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Email_Settings extends BaseClass {

	@Test
	public void Setting_Nameboard() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility Excel = new Excelutility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);
		com_cabcher_Email Setting_Email = new com_cabcher_Email(driver);
		NameBoard_Obj cabcherNameboard = new NameBoard_Obj(driver);
		for (int i = 0; i < 3; i++) {

			WebElement settings = cabcherNameboard.getSettings();
			web.scrolltoElement(driver, settings);
			Thread.sleep(2000);
			settings.click();

			WebElement Email = Setting_Email.getEmail();
			Thread.sleep(2000);
			Email.click();

			List<WebElement> FromEmail = Setting_Email.getFromEmail();

			String data = Excel.getDataFromExcel("Setting-Email", i, 0);

			Thread.sleep(2000);
			FromEmail.get(0).clear();
			FromEmail.get(0).sendKeys(data);

			List<WebElement> FromName = Setting_Email.getFromName();
			String FromNamedata = Excel.getDataFromExcel("Setting-Email", i, 1);
			FromName.get(0).clear();
			Thread.sleep(2000);
			FromName.get(0).sendKeys(FromNamedata);

			List<WebElement> SMTPHost = Setting_Email.getSMTPHost();
			String SMTPHostdata = Excel.getDataFromExcel("Setting-Email", i, 2);
			SMTPHost.get(0).clear();
			Thread.sleep(2000);
			SMTPHost.get(0).sendKeys(SMTPHostdata);

			List<WebElement> SMTPUsername = Setting_Email.getSMTPUsername();
			String SMTPUsernamedata = Excel.getDataFromExcel("Setting-Email", i, 2);
			SMTPUsername.get(0).clear();
			Thread.sleep(2000);
			SMTPUsername.get(0).sendKeys(SMTPUsernamedata);

			WebElement Updatebutton = Setting_Email.getUpdatebutton();
			Updatebutton.click();

			Thread.sleep(2000);
		}

	}

}
