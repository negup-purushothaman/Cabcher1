package NewConultation;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistationFrom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.negup.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[contains(text(),'Get A Free Quote')]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("purushothaman");
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("ppurushoth250@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"website\"]")).sendKeys("https://www.negup.com/");
		driver.findElement(By.xpath("//input[@name=\"phonenumber\"]")).sendKeys("purushothaman");
		WebElement drop = driver.findElement(By.xpath("//div[@class=\"filter-option\"]"));
		drop.click();
		driver.findElement(By.xpath("//span[text()='Afghanistan']")).click();
		driver.findElement(By.xpath("//textarea[@id=\"description\"]")).click();
		driver.findElement(By.xpath("//textarea[@id=\"description\"]")).sendKeys("Register for the application");
		
		// driver.findElement(By.xpath("//button[@id=\"form_submit\"]")).click()
	}

}
