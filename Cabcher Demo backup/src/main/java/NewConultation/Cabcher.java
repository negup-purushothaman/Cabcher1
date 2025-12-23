package NewConultation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.binary.XSSFBSheetHandler.SheetContentsHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

public class Cabcher {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options;    options = new ChromeOptions();
        options.addArguments("disable-notifications");
       
		WebDriver driver = new ChromeDriver();
		 driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cabcher-dev.negup.com/dashboard/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@id=\"btnCredentials\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"txtAdminEmail\"]")).sendKeys("test.customer@cabcher.com");
		driver.findElement(By.xpath("//input[@name=\"txtPassword\"]")).sendKeys("a123456b");
		 driver.findElement(By.xpath("//input[@type=\"submit\"]"));
	     driver.findElement(By.xpath("//INPUT[@type=\"submit\"]")).click();
	  
		Thread.sleep(1000);
		driver.findElement(By.xpath(" //a[contains(.,'New Booking')]")).click();
		driver.findElement(By.xpath("//input[@id=\"txtDropOff1Location\"]")).click();

		// Get all elements (fresh reference)
		
		Thread.sleep(1000);
		List<WebElement> booking = driver.findElements(By.xpath("//ul[contains(@class,\"ui-widget-content ui-autocomplete \")]/li"));

		// Click the first one if available
		if (!booking.isEmpty()) {
		    booking.get(1).click();
		} else {
		    System.out.println("No booking suggestions found!");
		}
		
		
		
		/*
		 * Actions act = new Actions(driver); WebElement login =
		 * driver.findElement(By.xpath("//input[@type=\"submit\"]"));
		 * act.scrollToElement(login).perform(); login.click();
		 * 
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//a[contains(text(),'Pricing') ]/i ")).click();
		 * driver.findElement(By.xpath("//a[contains(text(),'Meter')]")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//span[text()='Add New']")).click();
		 * 
		 * 
		 * List<WebElement> inputs =
		 * driver.findElements(By.xpath("//form[@id='form']//input[@type='number']"));
		 * 
		 * // Open Excel file FileInputStream file = new
		 * FileInputStream("G:\\My Drive\\CabcherTestData.xlsx"); Workbook wb =
		 * WorkbookFactory.create(file); Sheet sheet = wb.getSheet("Meterfare1");
		 * 
		 * // Loop through inputs and fill data from Excel for (int i = 0; i <
		 * inputs.size(); i++) { WebElement input = inputs.get(i); input.clear();
		 * 
		 * // Read data from Excel (each row = one input) Row row = sheet.getRow(i); if
		 * (row != null) { Cell cell = row.getCell(0); // data from column A String data
		 * = cell.toString(); // simple conversion input.sendKeys(data); } }
		 * 
		 * // Close Excel wb.close(); file.close();
		 */
		
		

	}

}
