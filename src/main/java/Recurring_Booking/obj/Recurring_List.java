package Recurring_Booking.obj;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recurring_List {

	private WebDriver driver;

	public Recurring_List(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy (xpath="//a[contains(text(),'Recurring')]")
	private WebElement Recurring;
	
	@FindBy (xpath="//a[contains(text(),\" Recurring\")]/../descendant::a[text()='List']")
	private WebElement List  ;
	
	@FindBy(xpath = "//form[@id='formCabcher']//input[@id='recurringTitle']")
	private List<WebElement> recurringTitle;

	@FindBy(id="recurringType")
	private WebElement recurringType;

	@FindBy(id="recurringDaysWeekly")
	private WebElement recurringdaysWeekly;
	
	@FindBy(xpath="//div[@class=\"dropdown-menu show\"]/descendant::button[text()='Select All'] ")
	private WebElement SelectAll;
	
	@FindBy(xpath="//div[@id=\"recurringDaysWeeklyElem\"]")
	private WebElement recurringDays ;
	
	@FindBy(id="selDateHr")
	private WebElement PickupTimeHH ;
	
	@FindBy(id="recurringStartDate")
	private WebElement StartDate ;
	
	@FindBy(id="recurringEndDate")
	private WebElement EndDate ;
	
	@FindBy(id="select2-customerID-container")
	private WebElement CustomerSelect ;
	
	@FindBy(xpath="//ul[@id=\"select2-customerID-results\"]/li")
	private WebElement Selectcustomer;
	
	@FindBy(xpath="//input[@class=\"select2-search__field\"]")
	private WebElement SearchCustomer;
	
	@FindBy(id="select2-accountID-container")
	private WebElement AccountSelect;
	
	@FindBy(xpath="//span[@id=\"select2-driverID-container\"]")
	private WebElement Driverupdate;
	
	@FindBy(xpath="//ul[@id=\"select2-driverID-results\"]/li")
	private WebElement SelectDriver;
	
	@FindBy(xpath="//div[text()='Additional services you might want?']")
	private WebElement Scrollelement;
	
	@FindBy(xpath="//label[text()='Vehicle:-']")
	private WebElement scrollVehicle;
	
         
	
	@FindBy(xpath="	//div[@class=\"dropdown dropdown-vehicle\"]")
	private WebElement Selectvehicle;
	
	

	public WebElement getSelectvehicle() {
		return Selectvehicle;
	}

	public WebElement getscrollVehicle() {
		return scrollVehicle;
	}

	public WebElement getScrollelement() {
		return Scrollelement;
	}

	public WebElement getSelectDriver() {
		return SelectDriver;
	}

	public WebElement getDriverupdate() {
		return Driverupdate;
	}

	public WebElement getAccountSelect() {
		return AccountSelect;
	}

	public WebElement getSelectcustomer() {
		return Selectcustomer;
	}

	public WebElement getSearchCustomer() {
		return SearchCustomer;
	}

	public WebElement getCustomerSelect() {
		return CustomerSelect;
	}

	public WebElement getEndDate() {
		return EndDate;
	}

	public WebElement getStartDate() {
		return StartDate;
	}

	public WebElement getPickupTimeHH() {
		return PickupTimeHH;
	}

	@FindBy(id="selDateMn")
	private WebElement MM ;
	
	
	
	public WebElement getMM() {
		return MM;
	}

	public WebElement getRecurringDays() {
		return recurringDays;
	}

	public WebElement getSelectAll() {
		return SelectAll;
	}

	public WebElement getRecurringdaysWeekly() {
		return recurringdaysWeekly;
	}

	public WebElement getRecurringType() {
		return recurringType;
	}

	@FindBy (id="recurringDescription")
	private List<WebElement> RecurringDescription;


	public List<WebElement> getRecurringTitile() {
		return recurringTitle;
	}

	public List<WebElement> getRecurringDescription() {
		return RecurringDescription;
	}

	public WebElement getRecurring() {
		return Recurring;
	}

	public WebElement getList() {
		return List;
	}
	
	
	
	
	
	
}
