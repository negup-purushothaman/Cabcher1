package com.cabcher.pricing;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Voucher_Pricing_Obj {

	WebDriver driver;

	public Voucher_Pricing_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"select2-selection select2-selection--multiple\"]/../../.. ")
	private WebElement Applicable;

	@FindBy(id = "voucherApplicable")
	private WebElement voucherApplicable;

	public WebElement getVoucherApplicable() {
		return voucherApplicable;
	}

	@FindBy(id = "selDiscountType")
	private WebElement DiscountType;

	public WebElement getDiscountType() {
		return DiscountType;
	}
	@FindBy(id="discount_value_max")
	private List<WebElement> DiscountValuePercentage;

	
	public List<WebElement> getDiscountValuePercentage() {
		return DiscountValuePercentage;
	}

	@FindBy(id = "txtVoucher")
	private List<WebElement> voucher;

	@FindBy(id = "voucherQuantity")
	private List<WebElement> voucherQuantity;

	@FindBy(id = "voucher_quantity_customer")
	private List<WebElement> voucher_quantity_customer;

	@FindBy(id = "discount_value_max")
	private List<WebElement> discount_value_max;

	@FindBy(id = "txtValidity")
	private List<WebElement> Validity;
	@FindBy(id = "txtDiscountValue")
	private List<WebElement> DiscountValue;

	public List<WebElement> getValidity() {
		return Validity;
	}

	public List<WebElement> getDiscountValue() {
		return DiscountValue;
	}

	public List<WebElement> getVoucherQuantity() {
		return voucherQuantity;
	}

	public List<WebElement> getVoucher_quantity_customer() {
		return voucher_quantity_customer;
	}

	public List<WebElement> getDiscount_value_max() {
		return discount_value_max;
	}

	public WebElement getApplicable() {
		return Applicable;
	}

	public List<WebElement> getvoucher() {
		return voucher;
	}

	@FindBy(xpath = "//a[text()='Vouchers']")
	private WebElement Vouchers;

	public WebElement getVouchers() {
		return Vouchers;
	}

	@FindBy(xpath = "//button[@id='primaryBtn']")
	private WebElement AddButton123;

	public WebElement getAddButton123() {
		return AddButton123;
	}

	@FindBy(xpath = "//input[@id=\"txtValidity\"]")
	private List<WebElement> Date;

	public List<WebElement> getDate() {
		return Date;
	}

}
