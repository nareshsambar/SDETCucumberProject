package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CRMPage;
import pages.JobsPage;
import pages.OrangeHRMPage;

public class WebSteps {

	@Given("^user is on the Alchemy admin jobs website$")
	public void user_is_on_the_alchemy_admin_jobs_website() throws Throwable {
		System.out.println("Given");
		JobsPage.initiateWebBrowser();
		JobsPage.navigateToAdminJobsPage();
	}

	@When("^user added a new user$")
	public void user_added_a_new_user() throws InterruptedException{
		JobsPage.loginToJobsPage();
		JobsPage.crateNewUser();
	}

	@Then("^user should be able to view created user details$")
	public void user_should_be_able_to_view_created_user_details() {
		System.out.println("Then");
		JobsPage.checkUserCreated();
	}

	@And("^user closes the page$")
	public void user_closes_the_page() {
		System.out.println("And");
		JobsPage.closeBrowser();
	}

	@Given("^user is on the Alchemy jobs website$")
	public void user_is_on_the_alchemy_jobs_website() throws Throwable {
		System.out.println("Given");
		JobsPage.initiateWebBrowser();
		JobsPage.navigateToJobsPage();
	}

	@When("^user searched for a job$") 
	public void user_searched_for_a_job(){
		JobsPage.searchForJob();
	}

	@Then("^user changed the filter to show only FullTime Jobs$") 
	public void user_changed_the_filter_to_show_only_FullTime_Jobs(){
		JobsPage.checkingAllTheBoxes();
	}

	@And("^user prints job list$")
	public void user_prints_job_list() {
		JobsPage.printingAllJobs();
	}

	@Then("^user selects a job and apply for it$")
	public void user_selects_a_job_and_apply_for_it() {
		JobsPage.clickingApplyForJob();
	}

	@When("^user go to Post a Job page$") 
	public void user_go_to_Post_a_Job_page() {
		JobsPage.loginToJobsPage();
		JobsPage.clickingAlchemyJobsLink();
		JobsPage.clickingPostAJobLink();
	}

	@Then("^user enter details \"(.*)\", \"(.*)\" and \"(.*)\"$")
	public void user_enter_and(String newJob, String newLocation, String newCompany) throws Throwable {
		JobsPage.enterNewJobDetails(newJob, newLocation, newCompany);
	}

	@And("^user submit the job$")
	public void user_submit_the_job() {
		JobsPage.submitJob();
	}

	@Then("^user confirm \"(.*)\" listing is shown on page$")
	public void user_confirm_job_listing_is_shown_on_page(String newJob) throws Throwable {
		JobsPage.clickingOnJobsLink();
		JobsPage.confirmSubmittedJobExists(newJob);
	}

	@Given("^user is on the Alchemy CRM website$")
	public void user_is_on_the_Alchemy_CRM_website() throws Throwable {
		System.out.println("Given");
		CRMPage.initiateWebBrowser();
		CRMPage.navigateToCRMPage();
		CRMPage.loginToCRMPage();
	}

	@When("^user count the dashlets$") 
	public void user_count_the_dashlets() {
		CRMPage.countDashlets();
	}

	@Then("^user prints all dashlet titles$") 
	public void user_prints_all_dashlet_titles() {
		CRMPage.printDashlets();
	}

	@And("^user closes the CRM page$")
	public void user_closes_the_CRM_page() {
		CRMPage.closeBrowser();
	}

	@When("^user navigate to the lead$") 
	public void user_navigate_to_the_lead() {
		CRMPage.navigateToLeads();
		CRMPage.clickOnCreateLead();

	}

	@Then("^user creates new lead with the following details \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
	public void user_creates_new_lead(String newSalutation, String newFirstName, String newLastName, String newPhone) throws Throwable {
		CRMPage.fillDetailsForNewLead(newSalutation, newFirstName, newLastName, newPhone);
	}

	@And("^user navigates to view leads$")
	public void user_navigates_to_view_leads() {
		CRMPage.navigatesToViewLeads();
	}

	@When("^user navigates to schedule meeting$")
	public void user_navigates_to_schedule_meeting() {
		CRMPage.navigateToMeetings();
		CRMPage.clickOnScheduleMeetings();
	}

	@Then("^user enter details for meeting \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
	public void enter_new_meeting_details(String newSubject, String newDate, String inv1, String inv2, String inv3) {
		CRMPage.enterMeetingDetails(newSubject, newDate, inv1, inv2, inv3);

	}

	@And("^user verifies the created meeting with \"(.*)\"$")
	public void user_verifies_the_created_meeting(String newSubject) {
		CRMPage.verifyCreatedMeeting(newSubject);
	}

	@When("^user navigates to products$")
	public void user_navigates_to_products() {
		CRMPage.navigateToCreateProduct();
	}

	@Then("user enter details for new product \"(.*)\" and \"(.*)\"$")
	public void user_enter_details_for_new_product_and(String string, String string1) {
		CRMPage.enterDetailsToNewProduct(string, string1);
	}

	@And("user verifies created record \"(.*)\"$")
	public void user_verifies_created_record(String string) {
		CRMPage.verifyCreatedProduct(string);
	}
	
	@Given("user login to the OrangeHRM Page$")
	public void user_login_to_the_OrangeHRM_Page() {
		OrangeHRMPage.initiateWebBrowser();
		OrangeHRMPage.navigateToHRMPage();
		OrangeHRMPage.loginToHRMPage();
	}
	
	@When("^user Navigate to vacancies menu from Recruitment page$")
	public void user_Navigate_to_vacancies_menu_from_Recruitment_page() throws Exception {
		OrangeHRMPage.navigateToRecruitmentPage();
		OrangeHRMPage.navigateToVacanciesPage();
		Thread.sleep(3000);
	}

	@Then("user adds a Job Vacancy$")
	public void user_adds_a_Job_Vacancy() throws Exception {
		OrangeHRMPage.addJobVacancy();
	}
	
	@And("user verifies the added vacancy$")
	public void user_verifies_the_added_vacancy() throws Exception {
		OrangeHRMPage.checkCreatedVacancy();
	}
	
	@And("^user closes OrangeHRM page$")
	public void user_closes_OrangeHRM_page() {
		OrangeHRMPage.closeBrowser();
	}

	@When("^user Navigate to Recruitment page$")
	public void user_Navigate_to_Recruitment_page() {
		OrangeHRMPage.navigateToRecruitmentPage();
	}
	
	@Then("^user adds a candidate$")
	public void user_adds_a_candidate() throws Exception {
		OrangeHRMPage.addCandidate();
	}
	
	@And("^user verifies added candidate$")
	public void user_verifies_added_candidate() throws Exception {
		OrangeHRMPage.checkCreatedCandidate();
	}
	
	@When("^user navigates to PIM page$")
	public void user_Navigate_to_PIM_page() throws Exception {
		OrangeHRMPage.navigateToPIMPage();
	}
	
	
	@Then("user adds a employee with details \"(.*)\", \"(.*)\"$")
	public void user_adds_a_employee_with_details(String newFName, String newLName) throws Exception {
		OrangeHRMPage.addANewEmployee(newFName, newLName);
	}
	
	@And("user enters further details \"(.*)\", \"(.*)\"$")
	public void user_enters_further_details(String newUserName, String newStatus) throws Exception {
		OrangeHRMPage.enterFurtherDetails(newUserName, newStatus);			
	}
	
	@Then("user verifies the created employee \"(.*)\", \"(.*)\"$")
	public void user_verifies_the_created_employee(String newFName, String newLName) throws Exception {
		OrangeHRMPage.verifyCreatedEmployee(newFName, newLName);
	}
	
	@Then("^user adds a candidate with details \"(.*)\", \"(.*)\", \"(.*)\"$")
	public void  user_adds_a_candidate_with_details(String NewVName, String NewHManager, String newJTitle) throws Exception {
		OrangeHRMPage.addJobVacancyWithDetails(NewVName, NewHManager, newJTitle);
	}
	
	@And("^user verifies added candidate with details \"(.*)\", \"(.*)\", \"(.*)\"$")
	public void user_verifies_added_candidate_with_details(String NewVName, String NewHManager, String newJTitle) throws Exception {
		OrangeHRMPage.checkCreatedVacancyWithDetails(NewVName, NewHManager, newJTitle);		
	}
	
}