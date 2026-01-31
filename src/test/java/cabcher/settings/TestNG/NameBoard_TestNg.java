package cabcher.settings.TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.cabcher.pricing.Distance_pricing_Obj;
import com.cabcher.pricing.Fixed_Pricing;
import com.cabcher.pricing.PricingObj;
import com.cacbcher.settings.NameBoard_Obj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class NameBoard_TestNg extends BaseClass {

	@Test
	public void Setting_Nameboard() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Distance_pricing_Obj DistancePrice = new Distance_pricing_Obj(driver);
		PricingObj price = new PricingObj(driver);
		Excelutility Excel = new Excelutility();
		Fixed_Pricing fixedPrice = new Fixed_Pricing(driver);

		NameBoard_Obj cabcherNameboard = new NameBoard_Obj(driver);

		web.WaitForElementClick(driver, cabcherNameboard.getSettings());

		WebElement settings = cabcherNameboard.getSettings();
		web.scrolltoElement(driver, settings);
		settings.click();
		web.WaitForElementClick(driver, cabcherNameboard.getNameboard());
		WebElement Nameboard = cabcherNameboard.getNameboard();
		web.scrolltoElement(driver, Nameboard);
		Nameboard.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id=\"select2-mergeCategorySelect2-container\"]")).click();
		driver.findElement(By.xpath("//span[text()='General']")).click();
		Thread.sleep(2000);
		WebElement	datafetch = driver.findElement(By.xpath("//select[@id=\"mergeCategoryFieldsSelect2\"]"));
		Select sel = new Select(datafetch);
		List<WebElement> datafetch1 = sel.getOptions();
		for (WebElement datafetch2 : datafetch1) {
			datafetch2.click();
			String data1 = datafetch2.getText();
			System.out.println(data1);

		}

	}

}
