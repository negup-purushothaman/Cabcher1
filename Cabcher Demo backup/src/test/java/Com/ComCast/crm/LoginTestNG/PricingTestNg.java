package Com.ComCast.crm.LoginTestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.ObjectRepositoryUtlity.PricingObj;
import Genericlabaries.BaseClass;
import Genericlabaries.WebdriverUtility;
import gereriUtility.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class PricingTestNg extends BaseClass {

	@Test
	public void login() throws InterruptedException {
		WebdriverUtility web = new WebdriverUtility();
		PricingObj price = new PricingObj(driver); // use inherited driver

		WebElement priceButton = price.getPricing(); // getPricingButton() was wrong
		web.WaitForElementClick(driver, priceButton); // now WebElement is not null
		priceButton.click();
     
		// Uncomment and continue further steps if needed:

		price.getGeneral().click();
		WebElement DecimalsPrice = price.getPriceDecimals();
		DecimalsPrice.clear();
		DecimalsPrice.sendKeys("0");
		

		WebElement DropOff = price.getDropOffMinimumPrice();
		DropOff.clear();
		DropOff.sendKeys("3");
		Assert.assertEquals(false, "ScreenShot");

		WebElement childseat = price.getChildSeatPrice();
		childseat.clear();
		childseat.sendKeys("3");

		WebElement journey = price.getJourneyFare();
		web.selectIndex(journey, 0);

		WebElement meter = price.getMeterFareDistance();
		web.selectIndex(meter, 0);

		WebElement driverFare = price.getDriverFareCategory();
		web.selectIndex(driverFare, 0);

		WebElement card = price.getCardPaymentPriceType();
		web.selectIndex(card, 0);

		WebElement cardPrice = price.getCardPricepercentage();
		cardPrice.clear();
		cardPrice.sendKeys("6");
		Thread.sleep(2000);
		WebElement scroll = price.getUpDate();
		web.scrolltoElement(driver, scroll);
		scroll.click();

	}
}
