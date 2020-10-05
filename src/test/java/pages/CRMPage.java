package pages;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CRMPage{
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
	}

	public static void initiateWebBrowser() {
		//PropertiesFileReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", "C://Selenium//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void navigateToCRMPage(){
		driver.get("https://alchemy.hguy.co/crm/");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void loginToCRMPage() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		boolean suitecrmdashboard=driver.findElement(By.id("tab0")).isDisplayed();
		if (suitecrmdashboard) {
			System.out.println("Suite CRM Homepage is opened");
		}
		else {
			System.out.println("Suite CRM Homepage is not opened");
		}
	}

	public static void countDashlets() {
		List<WebElement> dashletsList=driver.findElements(By.xpath("//td[@class='dashlet-title']/h3/span[2]"));
		//
		////td[@class='dashletcontainer col-50']/ul[@class='noBullet']/li/div
		int dashletsCount= dashletsList.size();
		System.out.println("Count of dashlets : "+dashletsCount);
	}

	public static void printDashlets() {
		List<WebElement> dashletsList=driver.findElements(By.xpath("//td[@class='dashlet-title']/h3/span[2]"));
		//
		////td[@class='dashletcontainer col-50']/ul[@class='noBullet']/li/div
		int dashletsCount= dashletsList.size();
		//System.out.println("Count of dashlets : "+dashletsCount);
		for (int i=1;i<=dashletsCount;i++) {
			String text=driver.findElement(By.xpath("(//td[@class='dashlet-title']/h3/span[2])["+i+"]")).getText();
			System.out.println(text);
		}
	}

	public static void navigateToLeads() {
		Actions actions = new Actions(driver);
		WebElement salesMenu=driver.findElement(By.id("grouptab_0"));
		actions.moveToElement(salesMenu).perform();
		driver.findElement(By.id("moduleTab_9_Leads")).click();
	}

	public static void clickOnCreateLead() {
		driver.findElement(By.xpath("(//div[@class='actionmenulink'][contains(text(),'Create Lead')])[1]")).click();
	}

	public static void fillDetailsForNewLead(String newsalutation, String newFirstName, String newLastName, String newPhone) {
		Select salutation = new Select(driver.findElement(By.id("salutation")));
		salutation.selectByVisibleText(newsalutation);
		driver.findElement(By.id("first_name")).sendKeys(newFirstName);
		driver.findElement(By.id("last_name")).sendKeys(newLastName);
		driver.findElement(By.id("phone_mobile")).sendKeys(newPhone);
		driver.findElement(By.xpath("(//input[@id='SAVE'][@value='Save'])[2]")).click();

	}

	public static void navigatesToViewLeads() {
		driver.findElement(By.xpath("(//div[@class='actionmenulink'][contains(text(),'View Leads')])[1]")).click();

	}

	public static void navigateToMeetings() {
		Actions actions = new Actions(driver);
		WebElement activitiesMenu=driver.findElement(By.id("grouptab_3"));
		actions.moveToElement(activitiesMenu).perform();
		driver.findElement(By.id("moduleTab_9_Meetings")).click();
	}

	public static void clickOnScheduleMeetings() {
		driver.findElement(By.xpath("//div[@class='actionmenulink'][contains(text(),'Schedule Meeting')]")).click();

	}

	public static void enterMeetingDetails(String newSubject, String sDate, String inv1, String inv2, String inv3) {

		driver.findElement(By.id("name")).sendKeys(newSubject);
		driver.findElement(By.id("date_start_date")).clear();
		driver.findElement(By.id("date_start_date")).sendKeys(sDate);
		
		driver.findElement(By.id("search_first_name")).sendKeys(inv1);
		driver.findElement(By.id("invitees_search")).click();
		driver.findElement(By.id("invitees_add_1")).click();
		
		driver.findElement(By.id("search_first_name")).clear();
		driver.findElement(By.id("search_first_name")).sendKeys(inv2);
		driver.findElement(By.id("invitees_search")).click();
		driver.findElement(By.id("invitees_add_1")).click();
		
		driver.findElement(By.id("search_first_name")).clear();
		driver.findElement(By.id("search_first_name")).sendKeys(inv3);
		driver.findElement(By.id("invitees_search")).click();
		driver.findElement(By.id("invitees_add_1")).click();
		//to click on save
		driver.findElement(By.xpath("(//input[@id='SAVE_HEADER'])[2]")).click();
		
		
	}
	
	public static void verifyCreatedMeeting(String newSubject) {
		driver.findElement(By.xpath("//div[@class='actionmenulink'][contains(text(),'View Meetings')]")).click();
		//driver.findElement(By.xpath("(//a[@title='Meetings']/span[2][contains(text(),'"+newSubject+"')])[2]")).click();
		boolean isCreatedMeetingExists = driver.findElement(By.xpath("//a[contains(text(),'"+newSubject+"')]")).isDisplayed();
		if(isCreatedMeetingExists) {
			System.out.println("Created meeting exists");
		}
		else{
			System.out.println("Created meeting not exist");
		}

	}
	
	public static void navigateToCreateProduct() {
		Actions actions = new Actions(driver);
		WebElement activitiesMenu=driver.findElement(By.id("grouptab_5"));
		actions.moveToElement(activitiesMenu).perform();
		//driver.findElement(By.id("moduleTab_9_Meetings")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Products')])[3]")).click();
		driver.findElement(By.xpath("//div[@class='actionmenulink'][contains(text(),'Create Product')]")).click();
	}
	
	public static void enterDetailsToNewProduct(String newName, String newPrice) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Entering Name :"+newName+" and Price : "+newPrice);
		driver.findElement(By.id("name")).sendKeys(newName);
		driver.findElement(By.id("price")).sendKeys(newPrice);
		driver.findElement(By.xpath("(//input[@id='SAVE'][@value='Save'])[2]")).click();
	}
	
	public static void verifyCreatedProduct(String newName) {
		driver.findElement(By.xpath("//div[@class='actionmenulink'][contains(text(),'View Products')]")).click();
		boolean isCreatedProductExists = driver.findElement(By.xpath("//a[contains(text(),'"+newName+"')]")).isDisplayed();
		if(isCreatedProductExists) {
			System.out.println("Created Product exists");
		}
		else{
			System.out.println("Created Product not exist");
		}
			
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	//
}
