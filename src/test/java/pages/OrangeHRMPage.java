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

public class OrangeHRMPage{
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

	public static void navigateToHRMPage(){
		driver.get("http://alchemy.hguy.co/orangehrm");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void loginToHRMPage() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		
		String hrmTitle=driver.getTitle();
		assertEquals("OrangeHRM", hrmTitle);
	}

	public static void navigateToRecruitmentPage() {
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
	}

	public static void navigateToVacanciesPage() {
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	}
	
	public static void addJobVacancy() throws Exception {
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(3000);
		Select jobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		jobTitle.selectByVisibleText("Automation Test Engineer");
		driver.findElement(By.id("addJobVacancy_name")).sendKeys("newJobVacancyName1");
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("FirstName1 LastName1");
		driver.findElement(By.id("btnSave")).click();	
		Thread.sleep(3000);
	}
	
	public static void checkCreatedVacancy() throws Exception {
		navigateToRecruitmentPage();
		navigateToVacanciesPage();
		Thread.sleep(3000);
		Select vacancySearchHiringMan = new Select(driver.findElement(By.id("vacancySearch_hiringManager")));
		vacancySearchHiringMan.selectByVisibleText("FirstName1 LastName1");
		driver.findElement(By.id("btnSrch")).click();
		
		List<WebElement> createdVac =  driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
		for(WebElement vac : createdVac) {
			if ((vac.getText().equals("newJobVacancyName1"))) {
				System.out.println("Created Vacancy Exists");
				break;
			}
			else {
				System.out.println("Created Vacancy not Exist");
			}
		}
	}
	
	public static void addCandidate() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("NewCandidateFirstName1");
		driver.findElement(By.id("addCandidate_lastName")).sendKeys("NewCandidateLastName1");
		driver.findElement(By.id("addCandidate_email")).sendKeys("NewCandidate@test.com");
		
		Select candidateVacancy = new Select(driver.findElement(By.id("addCandidate_vacancy")));
		candidateVacancy.selectByVisibleText("newJobVacancyName1");
		Thread.sleep(3000);
		WebElement uploadResume = driver.findElement(By.xpath(".//input[@type='file']"));
		uploadResume.sendKeys("C:\\Users\\SambarNaresh\\Desktop\\NareshSambar.txt");
		//sendkeys should work for sending input file path as per my knowledge but its not working
		/*
		driver.findElement(By.xpath("//input[@type='file']")).click();
		Thread.sleep(3000);
		String text = "C:\\Users\\SambarNaresh\\Desktop\\NareshSambar.txt";
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		*/
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);
	}
	
	public static void checkCreatedCandidate() throws Exception {
		navigateToRecruitmentPage();
		Thread.sleep(3000);
		Select vacancySearchHiringMan = new Select(driver.findElement(By.id("candidateSearch_hiringManager")));
		vacancySearchHiringMan.selectByVisibleText("FirstName1 LastName1");
		driver.findElement(By.id("btnSrch")).click();
		
		List<WebElement> createdCandidates =  driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
		for(WebElement can : createdCandidates) {
			if ((can.getText().equals("NewCandidateFirstName1  NewCandidateLastName1"))) {
				System.out.println("Created Candidate Exists");
				break;
			}
			else {
				System.out.println("Created Candidate not Exist");
			}
		}
	}
	
	public static void navigateToPIMPage() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(5000);
	}
	
	public static void addANewEmployee(String newFName, String newLName) throws Exception {
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("firstName")).sendKeys(newFName);
		driver.findElement(By.id("lastName")).sendKeys(newLName);
		driver.findElement(By.id("chkLogin")).click();
		Thread.sleep(3000);
	}
	
	public static void enterFurtherDetails(String newUserName, String newStatus) throws Exception {
		driver.findElement(By.id("user_name")).sendKeys(newUserName);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Select state = new Select(driver.findElement(By.id("status")));
		state.selectByVisibleText(newStatus);
		Thread.sleep(3000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);
	}
	
	public static void verifyCreatedEmployee(String newFName, String newLName) throws Exception{
		navigateToPIMPage();
		Thread.sleep(3000);
		driver.findElement(By.id("empsearch_employee_name_empName")).clear();
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(newFName+" "+newLName);
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(3000);
		List<WebElement> empList = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]/a"));
		for(WebElement emp: empList) {
			if ((emp.getText().equals(newFName))){
				System.out.println("Employee Found");
				break;
			}
			else {
				System.out.println("Created Employee not Exist");
			}
		}
	}
	
	public static void addJobVacancyWithDetails(String NewVName, String NewHManager, String newJTitle) throws Exception {
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(5000);
		Select jobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		jobTitle.selectByVisibleText(newJTitle);
		driver.findElement(By.id("addJobVacancy_name")).sendKeys(NewVName);
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(NewHManager);
		driver.findElement(By.id("btnSave")).click();	
		Thread.sleep(3000);
	}
	
	public static void checkCreatedVacancyWithDetails(String NewVName, String NewHManager, String newJTitle) throws Exception {
		navigateToRecruitmentPage();
		navigateToVacanciesPage();
		Thread.sleep(5000);
		Select vacancySearchHiringMan = new Select(driver.findElement(By.id("vacancySearch_hiringManager")));
		vacancySearchHiringMan.selectByVisibleText(NewHManager);
		driver.findElement(By.id("btnSrch")).click();
		
		List<WebElement> createdVac =  driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
		for(WebElement vac : createdVac) {
			if ((vac.getText().equals(NewVName))) {
				System.out.println("Created Vacancy Exists");
				break;
			}
			else {
				System.out.println("Created Vacancy not Exist");
			}
		}
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	//
}
