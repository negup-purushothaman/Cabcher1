package Genericlabaries;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.comcast.crm.ObjectRepositoryUtlity.DemoDashBoardLoginPage;
import com.comcast.crm.ObjectRepositoryUtlity.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	public WebdriverUtility webUtil;
	public DemoDashBoardLoginPage loginPage;
	public DashboardReusableMethod reusableOuter;
	public DashboardReusableMethod.ReusableMethods reusable; // static nested class
	WebdriverUtility web = new WebdriverUtility();

	@BeforeClass
	public void browserSetup() throws IOException {
		reusableOuter = new DashboardReusableMethod(driver);
		reusable = new DashboardReusableMethod.ReusableMethods();

		String browser = reusableOuter.Browser();
		System.out.println("Browser from config: " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Unsupported browser: " + browser);
		}

		System.out.println("Driver initialized: " + driver);
		webUtil = new WebdriverUtility();
	}

	@BeforeMethod
	public void loginSetup() throws InterruptedException, IOException {
		loginPage = new DemoDashBoardLoginPage(driver);

		// ✅ URL comes from ReusableMethods, no need to set in BaseClass
		String URL = reusable.getDashboardLoginUrl();
		String EmailID = reusableOuter.EmailId();
		String Password = reusableOuter.Password();

		System.out.println("Logging in with URL: " + URL + " | Email: " + EmailID);

		loginPage.logintoapp(URL);
		// Thread.sleep(1000);
		loginPage.dashlogin(EmailID, Password);
		// Thread.sleep(1000);
		WebElement actionBtn = loginPage.getAction();
		webUtil.scrolltoElement(driver, actionBtn);
		actionBtn.click();
		System.out.println("Login successful");

	}

	@AfterMethod
	public void logout() {
		try {
			LoginPage logoutPage = new LoginPage(driver);
			Thread.sleep(3000);
			WebElement Logout = logoutPage.getLogoutMenu();
			web.scrolltoElement(driver, Logout);
			Logout.click();
			logoutPage.getLogout().click();
			System.out.println("Logout successful");
		} catch (Exception e) {
			System.out.println("Logout failed: " + e.getMessage());
		}
	}

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed");
		}
	}
}
