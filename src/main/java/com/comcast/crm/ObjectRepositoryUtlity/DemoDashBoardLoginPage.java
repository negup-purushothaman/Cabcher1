package com.comcast.crm.ObjectRepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Genericlabaries.WebdriverUtility;
import java.time.Duration;

public class DemoDashBoardLoginPage extends WebdriverUtility {

    private WebDriver driver;
    public DemoDashBoardLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ======= LOCATORS =======
    @FindBy(id = "btnCredentials")
    private WebElement DashboardLogin;

    @FindBy(xpath = "//input[@name='txtAdminEmail']")
    private WebElement EmailAddress;

    @FindBy(xpath = "//input[@name='txtPassword']")
    private WebElement dashboardPassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement Action;

    @FindBy(id = "ntrans")
    private WebElement Language;

    // ======= GETTERS =======
    public WebElement getAction() { return Action; }
    public WebElement getDashboardLogin() { return DashboardLogin; }
    public WebElement getPassword() { return dashboardPassword; }
    public WebElement getLanguage() { return Language; }

    WebdriverUtility webuti = new WebdriverUtility();

    // ======= METHODS =======
    public void logintoapp(String url) throws InterruptedException {
        webuti.waitForPageToLoad(driver);
        driver.get(url);
        webuti.maximize(driver);
    }

    public void dashlogin(String LoginEmailID, String DashboardPassword) throws InterruptedException {
        // Wait for the page to load
        webuti.waitForPageToLoad(driver);

        // Check if DashboardLogin button is present
        try {
            if (getDashboardLogin().isDisplayed()) {
            //	Thread.sleep(1000);
                getDashboardLogin().click();

                // Wait until URL changes to dashboard login page
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.urlContains("dashboard/login"));
            }
        } catch (Exception e) {
            // Button not present, likely already on the login page
            System.out.println("DashboardLogin button not present, assuming already on login page.");
        }

        // Fill in credentials
        EmailAddress.sendKeys(LoginEmailID);
        dashboardPassword.sendKeys(DashboardPassword);
    }

}

