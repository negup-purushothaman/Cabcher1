package com.cacbcher.settings;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class com_cabcher_Email {

	 private WebDriver driver;
	    public com_cabcher_Email(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    @FindBy(xpath="//div[@id=\"settings-menu\"]/descendant::a[text()='Email']")
	    private WebElement Email;
	
	    @FindBy(id="txtFromEmailAddress")
	    private List<WebElement>  FromEmail;
	    
	    @FindBy(id="txtFromName")
	    private List<WebElement>  FromName;
	    
	    @FindBy(  id="txtSMTPHost")
	    private List<WebElement>  SMTPHost;
	  
	    @FindBy(id="txtSMTPUsername")
	    private List<WebElement>  SMTPUsername;
	    
	    @FindBy(xpath="//button[text()='UPDATE']")
	    private WebElement Updatebutton;
	  
		public WebElement  getUpdatebutton() {
			return Updatebutton;
		}


		public WebElement getEmail() {
			return Email;
		}

		public List<WebElement>  getFromEmail() {
			return FromEmail;
		}

		public List<WebElement>  getFromName() {
			return FromName;
		}

		public List<WebElement>  getSMTPHost() {
			return SMTPHost;
		}

		public List<WebElement>  getSMTPUsername() {
			return SMTPUsername;
		}
	    
	
	
}
