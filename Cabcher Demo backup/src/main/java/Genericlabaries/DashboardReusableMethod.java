package Genericlabaries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardReusableMethod {

    public WebDriver driver;

    public DashboardReusableMethod(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String Browser() {
        return "chrome";  // Change browser if needed
    }

    public String EmailId() {
        return "demo@cabcher.com";
    }

    public String Password() {
        return "@a123456b";
    }
 // https://cabcher-dev.negup.com/dashboard/login
   // https://demo.cabcher.com/dashboard/login
    // ✅ Static nested class for dashboard URL
    public static class ReusableMethods {
        private static String DASHBOARD_URL ="https://demo.cabcher.com/dashboard/login"; // default URL

        public String getDashboardLoginUrl() {
            return DASHBOARD_URL;
        }

        public static void setDashboardUrl(String url) {
            DASHBOARD_URL = url;
        } 
    }
}

