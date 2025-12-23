package demo.cabookie;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;






public class Democabookie   {
	public static void main(String[] arg) throws InterruptedException {
		// Step 1: Set Chrome preferences to block browser notification popup
		
		
		 ChromeOptions options=new ChromeOptions();
		 options.addArguments("disable-notifications"); WebDriver driver = new
		 ChromeDriver(options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 

		driver.get("https://demo.cabcher.com/dashboard/stats");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id=\"btnCredentials\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"txtAdminEmail\"]")).sendKeys("test.customer@cabcher.com");
		driver.findElement(By.xpath("//input[@name=\"txtPassword\"]")).sendKeys("a123456b");
		Actions act = new Actions(driver);
		WebElement login = driver.findElement(By.xpath("//input[@name=\"sbtLogin\"]"));
		act.scrollToElement(login).perform();
		login.click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[@id=\"allow-push-notification\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),' New Booking')]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[@id=\"allow-push-notification\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"txtPickUp1Location\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"txtPickUp1Location\"]")).click();
		driver.findElement(By.xpath("//ul[contains(@class,\"ui-menu ui-widget ui-widget-content \")]")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//input[@id=\"txtDropOff1Location\"]")).click();
		// driver.findElement(By.xpath("//ul[contains(@class,\"ui-menu ui-widget
		// ui-widget\")]")).click();
		WebElement select = driver.findElement(By.id("customerID"));
		Select sel = new Select(select);
		sel.selectByIndex(1);
		// driver.findElement(By.xpath("//div[@id='ui-id-126']"));
		// Alert alr=driver.switchTo().alert();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("//a[contains(text(), 'Home')]")).click();
		// driver.findElement(By.xpath("//input[@name=\"txtAdminEmail\"]")).sendKeys("demo@cabookie.com");
		// Thread.sleep(1000);
		/*
		 * driver.findElement(By.xpath("//button[@class=\"btn-close\"]")).click();
		 * driver.findElement(By.xpath("//input[@name=\"sbtLogin\"]")).click();
		 * driver.findElement(By.xpath("//a[contains(.,'Users')]")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//button[@id=\"allow-push-notification\"]")).
		 * click();
		 * driver.findElement(By.xpath("//button[@id=\"allow-push-notification\"]")).
		 * click(); WebElement records =
		 * driver.findElement(By.xpath("//select[@id=\"selPageSize\"]")); Select sel =
		 * new Select(records); sel.selectByIndex(3);
		 */
	}

}
