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

public class JobsPage{
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

	public static void navigateToAdminJobsPage(){
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void navigateToJobsPage(){
		driver.get("https://alchemy.hguy.co/jobs/jobs/");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void loginToJobsPage() {
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
	// //div[@class='wp-menu-name'][contains(text(),'Users')]
		//a[contains(text(),'Add New')]
	}
	
	public static void crateNewUser() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement UsersMenu=driver.findElement(By.xpath("//div[@class='wp-menu-name'][contains(text(),'Users')]"));
    	actions.moveToElement(UsersMenu).perform();
		//driver.findElement(By.xpath("//a[contains(text(),'Add New')]")).click();
    	driver.findElement(By.xpath("//a[@href='user-new.php']")).click();
		driver.findElement(By.id("user_login")).sendKeys("newuser3");
		driver.findElement(By.id("email")).sendKeys("newuser3@gmail.com");
		driver.findElement(By.id("first_name")).sendKeys("NewUserFirstName3");
		driver.findElement(By.id("last_name")).sendKeys("NewUserLastName3");
		//driver.findElement(By.xpath("//button[contains(text(),'Show password')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("createusersub")).click();
	}
	
	public static void checkUserCreated() {
		String ActualnewUserCreatedMessage=driver.findElement(By.xpath("//div[@id='message']/p")).getText();
		System.out.println(ActualnewUserCreatedMessage);
		String ExpectednewUserCreatedMessage = "New user created. Edit user";
		assertEquals(ActualnewUserCreatedMessage, ExpectednewUserCreatedMessage);
	}
	
	public static void searchForJob() {
		driver.findElement(By.id("search_keywords")).sendKeys("Automation Tester");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public static void checkingAllTheBoxes() {
		driver.findElement(By.id("job_type_freelance")).click();
		driver.findElement(By.id("job_type_internship")).click();
		driver.findElement(By.id("job_type_part-time")).click();
		driver.findElement(By.id("job_type_temporary")).click();
	}
	
	public static void printingAllJobs() {
		List<WebElement> jobList=driver.findElements(By.xpath("//ul[@class='job_listings']/li/a/div[1]/h3"));
		System.out.println("Job Listing : ");
		for (WebElement job : jobList) {
			System.out.println(job.getText());
		}
	}
	
	public static void clickingApplyForJob() {
		driver.findElement(By.xpath("(//ul[@class='job_listings']/li/a/div[1]/h3)[1]")).click();
		driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
		String jobTitle=driver.findElement(By.xpath("//div[@class='ast-single-post-order']/h1")).getText();
		System.out.println("Job Title : "+jobTitle);
	}
	
	public static void clickingPostAJobLink() {
		driver.findElement(By.xpath("//a[contains(text(),'Post a Job')]")).click();
	}
	
	public static void enterNewJobDetails(String newJob, String newLocation, String newCompany) {
		driver.findElement(By.id("job_title")).sendKeys(newJob);
		driver.findElement(By.id("job_location")).sendKeys(newLocation);
		driver.findElement(By.id("company_name")).clear();
		driver.findElement(By.id("company_name")).sendKeys(newCompany);
		Select dropDownJobType = new Select(driver.findElement(By.id("job_type")));
		dropDownJobType.selectByVisibleText("Full Time");
		// switch to frame
		driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.xpath("/html/body")).sendKeys("New job posting");

		driver.switchTo().defaultContent();
	}
	
	public static void submitJob() {
		driver.findElement(By.xpath("//input[@name='submit_job']")).click();
		driver.findElement(By.id("job_preview_submit_button")).click();
	}
	
	public static void clickingAlchemyJobsLink() {
		driver.findElement(By.xpath("//a[contains(text(),'Alchemy Jobs')]")).click();
	}
	
	public static void clickingOnJobsLink() {
		driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
	}
	
	public static void confirmSubmittedJobExists(String newJob) throws InterruptedException {
		driver.findElement(By.id("search_keywords")).sendKeys(newJob);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(10000);
		String jobTitle=driver.findElement(By.xpath("(//ul[@class='job_listings']/li/a/div[1]/h3)[1]")).getText();
		System.out.println("Job Title : "+jobTitle);
		assertEquals(jobTitle, newJob);
	}
	
	public static void closeBrowser() {
		driver.close();
	}
//
}
