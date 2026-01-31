package cabcher.pricing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cabcher.pricing.PricingObj;
import com.cabcher.pricing.Pricing_Discounts_Obj;
import com.cabcher.pricing.Voucher_Pricing_Obj;
import com.comcast.crm.ObjectRepositoryUtlity.NewBookingObj;

import Genericlabaries.BaseClass;
import Genericlabaries.Excelutility;
import Genericlabaries.WebdriverUtility;

public class Voucher_PricingTestNG extends BaseClass {

	@Test
	public void Daily_Surcharges_NO() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		PricingObj price = new PricingObj(driver);
		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);
		Voucher_Pricing_Obj Voucher = new Voucher_Pricing_Obj(driver);
		for (int j = 1; j <= 3; j++) {
			// start from 1 if row 0 is header
			
			

			// Navigate to Pricing → Voucher
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();
			Thread.sleep(2000);
			web.WaitForElementClick(driver, Voucher.getVouchers());
			Voucher.getVouchers().click();

			// Click Add button
			Thread.sleep(2000);
			WebElement addButton = Discount.getAddbuttton();
			web.scrolltoElement(driver, addButton);
			Thread.sleep(2000);
			web.WaitForElementClick(driver, addButton);
			addButton.click();

			// ---------- Voucher Name ----------
			List<WebElement> voucherName = Voucher.getvoucher();
			String voucherData = excel.getDataFromExcel("Voucher", j, 0);
			voucherName.get(0).sendKeys(voucherData);

			// ---------- Voucher Quantity ----------
			List<WebElement> voucherQty = Voucher.getVoucherQuantity();
			String qtyData = excel.getDataFromExcel("Voucher", j, 2);
			voucherQty.get(0).sendKeys(qtyData);

			// ---------- Date Selection ----------
			Thread.sleep(2000);

			List<WebElement> dates = Voucher.getDate();

			int date = j + 2;
			dates.get(0).click();
			booking.selectDate(date);

			Thread.sleep(2000);
			// ---------- Customer Quantity ----------
			List<WebElement> customerQty = Voucher.getVoucher_quantity_customer();
			String customerQtyData = excel.getDataFromExcel("Voucher", j, 3);
			customerQty.get(0).sendKeys(customerQtyData);

			// ---------- Discount Value ----------
			List<WebElement> discountValue = Voucher.getDiscountValue();
			String discountData = excel.getDataFromExcel("Voucher", j, 4);
			discountValue.get(0).sendKeys(discountData);

			WebElement Applicable = Voucher.getApplicable();
			Applicable.click();
			Thread.sleep(3000);
			WebElement VoucherApplicable = Voucher.getVoucherApplicable();
			web.selectIndex(VoucherApplicable, 0);

			Thread.sleep(3000);
			// web.selectIndex(Applicable, rowCount);

			// ---------- Save ----------
			web.WaitForElementClick(driver, Voucher.getAddButton123());
			Voucher.getAddButton123().click();

			Thread.sleep(1500);
		}
	}

	@Test
		public void Daily_Surcharges_YES() throws Throwable {

		WebdriverUtility web = new WebdriverUtility();
		Excelutility excel = new Excelutility();

		PricingObj price = new PricingObj(driver);
		Pricing_Discounts_Obj Discount = new Pricing_Discounts_Obj(driver);
		NewBookingObj booking = new NewBookingObj(driver);
		Voucher_Pricing_Obj Voucher = new Voucher_Pricing_Obj(driver);
		for (int j = 1; j <= 3; j++) { // start from 1 if row 0 is header

			// Navigate to Pricing → Voucher
			web.WaitForElementClick(driver, price.getPricing());
			price.getPricing().click();
			Thread.sleep(2000);
			web.WaitForElementClick(driver, Voucher.getVouchers());
			Voucher.getVouchers().click();

			// Click Add button
			Thread.sleep(2000);
			WebElement addButton = Discount.getAddbuttton();
			web.scrolltoElement(driver, addButton);
			Thread.sleep(2000);
			web.WaitForElementClick(driver, addButton);
			addButton.click();

			// ---------- Voucher Name ----------
			List<WebElement> voucherName = Voucher.getvoucher();
			String voucherData = excel.getDataFromExcel("Voucher", j, 0);
			voucherName.get(0).sendKeys(voucherData);

			// ---------- Voucher Quantity ----------
			List<WebElement> voucherQty = Voucher.getVoucherQuantity();
			String qtyData = excel.getDataFromExcel("Voucher", j, 1);
			voucherQty.get(0).sendKeys(qtyData);

			// ---------- Date Selection ----------
			Thread.sleep(2000);

			List<WebElement> dates = Voucher.getDate();

			int date = j + 5;
			dates.get(0).click();
			booking.selectDate(date);

			Thread.sleep(2000);
			// ---------- Customer Quantity ----------
			List<WebElement> customerQty = Voucher.getVoucher_quantity_customer();
			String customerQtyData = excel.getDataFromExcel("Voucher", j, 2);
			customerQty.get(0).sendKeys(customerQtyData);

			// ---------- Discount Value ----------
			

			WebElement Applicable = Voucher.getApplicable();
			Applicable.click();
			Thread.sleep(3000);
			WebElement VoucherApplicable = Voucher.getVoucherApplicable();
			web.selectIndex(VoucherApplicable, 0);

			WebElement DiscountType = Voucher.getDiscountType();
			web.selectIndex(DiscountType, 1);

			List<WebElement>	DiscountValuePercentage	=Voucher.getDiscountValuePercentage();
			String DiscountValuePercentage_Data = excel.getDataFromExcel("Voucher",j,3);
			DiscountValuePercentage.get(0).sendKeys(DiscountValuePercentage_Data);
			
			List<WebElement> discountValue = Voucher.getDiscountValue();
			String discountData = excel.getDataFromExcel("Voucher", j, 4);
			discountValue.get(0).sendKeys(discountData);
			
			Thread.sleep(3000);
		
			web.WaitForElementClick(driver, Voucher.getAddButton123());
			Voucher.getAddButton123().click();

			Thread.sleep(1500);
		}
	}

}
