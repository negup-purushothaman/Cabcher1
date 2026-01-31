package Com.ComCast.crm.LoginTestNG;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtlity.Accounts_Obj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Account_BookingTestNG extends BaseClass {

	@Test
	public void ActiveMutiple_customer_Register() throws Throwable {
		// Customers_Register CustomerReg = new Customers_Register(driver);
		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();
		Accounts_Obj Account = new Accounts_Obj(driver);
		// Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		Thread.sleep(2000);
		web.WaitForElementClick(driver, Account.getAccounts());
		for (int j = 0; j < 2; j++) {
             Thread.sleep(2000);
			web.WaitForElementClick(driver, Account.getAccounts());
			Account.getAccounts().click();

			web.WaitForElementClick(driver, Account.getAddNew());
			
			Account.getAddNew().click();
			web.WaitForElementClick(driver, Account.getPyamentSelect());
			Account.getPyamentSelect().click();
			web.WaitForElementClick(driver,Account.getSelectAll());
			Account.getSelectAll().click();
			web.WaitForElementClick(driver,Account.getPayment());
			Account.getPayment().click();

			Thread.sleep(2000);
			WebElement AccountName = Account.getAccountName();
			String Accountname = excel.getDataFromExcel("Account-Register", 0, 0);
			AccountName.sendKeys(Accountname);
			String AccountEmail = excel.getDataFromExcel("Account-Register", 0, 1);
			Account.getAccountEmail().sendKeys(AccountEmail);
			String Contactnumber = excel.getDataFromExcel("Account-Register", 0, 2);
			Account.getContactnumber().sendKeys(Contactnumber);
			Thread.sleep(2000);
			String AccountPrimary = excel.getDataFromExcel("Account-Register", 0, 3);
			Account.getAccountPrimary().sendKeys(AccountPrimary);

			String AccountPrimaryContact = excel.getDataFromExcel("Account-Register", 0, 4);
			Account.getAccountPrimaryContact().sendKeys(AccountPrimaryContact);
			String InvoiceDueDays = excel.getDataFromExcel("Account-Register", 0, 5);
			Account.getInvoiceDueDays().sendKeys(InvoiceDueDays);
			Thread.sleep(2000);
			WebElement updatebutton = Account.getUpdateButton();
			web.scrolltoElement(driver, updatebutton);
			updatebutton.click();

			Thread.sleep(2000);
			Account.getVerifed().click();
			Thread.sleep(2000);
			Account.getEdit().click();

			Thread.sleep(3000);
			WebElement Active = Account.getActive();
			web.scrolltoElement(driver, Active);
			web.selectIndex(Active, 0);
			WebElement updatebuttonActive = Account.getUpdateButton();
			web.scrolltoElement(driver, updatebuttonActive);
			updatebutton.click();
			Thread.sleep(2000);
			Alert alt = driver.switchTo().alert();
			alt.accept();
		}
	}
}
