package Pomgeneric.Test;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
	WebDriver driver;

	public AboutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//a[text()='About']")
	private WebElement About;
	
	@FindBy(xpath="//a[text()='Contact Now ']") 
	private WebElement ContactNow;

	public WebElement About() {
		return About;
	}
	public WebElement getContactNow() {
		return ContactNow;
	} 
		
}
