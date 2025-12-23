package Com.ComCast.crm.LoginTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtlity.DispatchDashBoardObj;
import Genericlabaries.BaseClass;
import Genericlabaries.WebdriverUtility;

public class Dispatch extends BaseClass {

	@Test
	public void DisPatch() throws  InterruptedException  {
		WebdriverUtility ResWeb = new WebdriverUtility();
		DispatchDashBoardObj dispatch = new DispatchDashBoardObj(driver);

		// Open Dispatch page
		dispatch.getDispatch().click();
		Thread.sleep(1000);

		// Search for "test"
		WebElement search = dispatch.getFilterSearch();
		ResWeb.WaitForElementClick(driver, search);
		search.click();
		search.sendKeys("");
		Thread.sleep(2000);

		List<WebElement> assignBtns = dispatch.getDriverassin();

		// Loop through each button and click
		for (WebElement btn : assignBtns) {
			btn.click();
			// Optionally, add wait or verification here
			WebElement drivername = driver.findElement(By.xpath("//input[@id=\"driverAllocationID2\"]"));
			Thread.sleep(2000);
			drivername.click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@id=\"driverUpdate\"]")).click();
			
			Thread.sleep(2000);
			List<WebElement> threeDots = dispatch.getThreeIcon();
			for (WebElement icon : threeDots) {

				icon.click();

				WebElement deleteBtn = dispatch.getDelete();
				deleteBtn.click();
				Thread.sleep(500);
				driver.findElement(By.id("confirmDelete")).click();

				// small pause
			}
			
		}
		/*
		 * Thread.sleep(1000); WebElement driver2 =
		 * driver.findElement(By.id("driverAllocationSearch")); //driver2.click();
		 * driver2.sendKeys("John");
		 */

	}
	
	@Test
	public void DriverAllocation () throws InterruptedException {
		
		WebdriverUtility ResWeb = new WebdriverUtility();
		DispatchDashBoardObj dispatch = new DispatchDashBoardObj(driver);

		// Open Dispatch page
		dispatch.getDispatch().click();
		Thread.sleep(1000);

		// Search for "test"
		WebElement search = dispatch.getFilterSearch();
		ResWeb.WaitForElementClick(driver, search);
		search.click();
		search.sendKeys("test");
		Thread.sleep(2000);

		List<WebElement> assignBtns = dispatch.getDriverassin();

		// Loop through each button and click
		for (WebElement btn : assignBtns) {
			btn.click();
			// Optionally, add wait or verification here
			WebElement drivername = driver.findElement(By.xpath("//input[@id=\"driverAllocationID1\"]"));
			Thread.sleep(2000);
			drivername.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id=\"sendNotificationDriver\"]")).click();
			
			driver.findElement(By.xpath("//button[@id=\"driverUpdate\"]")).click();
		
		
		
	}
	
	}	
	
	
}

/*
 * // Get all rows in the table List<WebElement> rows =
 * driver.findElements(By.xpath("//table//tr"));
 * 
 * // Loop through each row for (int i = 1; i <= rows.size(); i++) { // Find the
 * changeDriver button in this row WebElement changeDriverBtn =
 * driver.findElement( By.xpath("//table//tr[" + i +
 * "]//td[@class='reorder']//div[@class='changeDriver']") );
 * 
 * // Perform action (e.g., click) changeDriverBtn.click();
 * 
 * // Optional: break if you only want the first click // break; }
 */

/*
 * Thread.sleep(2000); List<WebElement> driver1 = Dispatch.getDriverassin();
 * 
 * int repeat2 = 3; for (int r = 0; r < repeat2; r++) { for (WebElement icon1 :
 * driver1) { icon1.click();
 * 
 * Thread.sleep(1000); WebElement res = Dispatch.getDelete(); res.click();
 * Thread.sleep(500); // optional wait }
 */
// }

/*
 * WebElement driver2 = driver.findElement(By.xpath(
 * "//input[@id=\"driverAllocationSearch\"]"));driver2.click();driver2.sendKeys(
 * "John");Thread.sleep(1000); WebElement drivername =
 * driver.findElement(By.xpath(
 * "//input[@id=\"driverAllocationID1\"]"));drivername.click();driver.
 * findElement(By.xpath("//button[@id=\"driverUpdate\"]")).click();
 * 
 */
 



