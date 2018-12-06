package registration;

import static org.testng.Assert.assertEquals;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.cg.registration.RegistrationPageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	RegistrationPageFactory registrationPage;
	WebDriver driver;

	@Given("^User is on registration page$")
	public void user_is_on_registration_page() throws Throwable {
		//create a new instance of firefox driver
		driver = new FirefoxDriver();

		//used to navigate to registration form
		driver.get("D:\\RegistrationDemo\\RegistrationForm.html");

		//creating object of LoginPageFactory
		registrationPage = new RegistrationPageFactory(driver);

		System.out.println("Page loaded in browser");
	}

	@Then("^Display Error Message 'check the title of the web page'$")
	public void display_Error_Message_check_the_title_of_the_web_page() throws Throwable {
		String strheading =driver.findElement(By.xpath("/html/body/h1")).getText();
		if(strheading.contentEquals("Registration Form"))
			System.out.println("Title Matched");
		else
			System.out.println("Title Not Matched");
		driver.manage();
		driver.close();
	}

	@When("^User Id is empty/length should be between (\\d+) and (\\d+)$")
	public void user_Id_is_empty_length_should_be_between_and(int arg1, int arg2) throws Throwable {
		registrationPage.setUID("");
		registrationPage.clickLoginButton();
	}

	@Then("^Display Error Message 'Please enter User Id/check the length it should lies between (\\d+) and (\\d+)'$")
	public void display_Error_Message_Please_enter_User_Id_check_the_length_it_should_lies_between_and(int arg1, int arg2) throws Throwable {
		//To get the text of the alert
		String actualErrorMsg = driver.switchTo().alert().getText();

		String expErrorMsg = "User Id should not be empty / length be between "+arg1+" to "+arg2;
		assertEquals(expErrorMsg, actualErrorMsg);

		//To accept the alert(switch from main window to an alert)
		driver.switchTo().alert().accept();
		driver.close();
	}

	@When("^Password is empty/length should be between (\\d+) and (\\d+)$")
	public void password_is_empty_length_should_be_between_and(int arg1, int arg2) throws Throwable {
		registrationPage.setUID("161417");
		registrationPage.setPWD("");
		registrationPage.clickLoginButton();
	}

	@Then("^Display Error Message 'Please enter Password/check the length it should lies between (\\d+) and (\\d+)'$")
	public void display_Error_Message_Please_enter_Password_check_the_length_it_should_lies_between_and(int arg1, int arg2) throws Throwable {
		//To get the text of the alert
		String actualErrorMsg = driver.switchTo().alert().getText();

		String expErrorMsg = "Password should not be empty / length be between "+arg1+" to "+arg2;
		assertEquals(expErrorMsg, actualErrorMsg);

		//To accept the alert(switch from main window to an alert)
		driver.switchTo().alert().accept();
		driver.close();
	}

	@When("^Name Field is empty/Invalid name$")
	public void name_Field_is_empty_Invalid_name() throws Throwable {
		registrationPage.setUID("161417");
		registrationPage.setPWD("supreddy");
		registrationPage.setUserName("321243");
		registrationPage.clickLoginButton();
	}

	@Then("^Display Error Message 'Please enter Name/enter alphabet characters'$")
	public void display_Error_Message_Please_enter_Name_enter_alphabet_characters() throws Throwable {
		//To get the text of the alert
		String actualErrorMsg = driver.switchTo().alert().getText();

		String expErrorMsg = "Name should not be empty and must have alphabet characters only";
		assertEquals(expErrorMsg, actualErrorMsg);

		//To accept the alert(switch from main window to an alert)
		driver.switchTo().alert().accept();
		driver.close();
	}

	@When("^Invalid address$")
	public void invalid_address() throws Throwable {
		registrationPage.setUID("161417");
		registrationPage.setPWD("supreddy");
		registrationPage.setUserName("Supriya");
		registrationPage.setAddress("#@$%476");
		registrationPage.clickLoginButton();
	}

	@Then("^Display Error Message 'Please enter alphabetnumeric characters'$")
	public void display_Error_Message_Please_enter_alphabetnumeric_characters() throws Throwable {
		//To get the text of the alert
		String actualErrorMsg = driver.switchTo().alert().getText();

		String expErrorMsg = "User address must have alphanumeric characters only";
		assertEquals(expErrorMsg, actualErrorMsg);

		//To accept the alert(switch from main window to an alert)
		driver.switchTo().alert().accept();
		driver.close();
	}

	@When("^Upon no country selected from dropdown$")
	public void upon_no_country_selected_from_dropdown() throws Throwable {
		registrationPage.setUID("161417");
		registrationPage.setPWD("supreddy");
		registrationPage.setUserName("Supriya");
		registrationPage.setAddress("Kukatpally");
		registrationPage.clickLoginButton();
	}

	@Then("^Display Error Message 'Please select country from list'$")
	public void display_Error_Message_Please_select_country_from_list() throws Throwable {
		//To get the text of the alert
		String actualErrorMsg = driver.switchTo().alert().getText();

		String expErrorMsg = "Select your country from the list";
		assertEquals(expErrorMsg, actualErrorMsg);

		//To accept the alert(switch from main window to an alert)
		driver.switchTo().alert().accept();
		driver.close();
	}

	@When("^Invalid Zip Code$")
	public void invalid_Zip_Code() throws Throwable {
		registrationPage.setUID("161417");
		registrationPage.setPWD("supreddy");
		registrationPage.setUserName("Supriya");
		registrationPage.setAddress("Kukatpally");
		registrationPage.setCountry("India");
		registrationPage.setZipCode("xyz@");
		registrationPage.clickLoginButton();
	}

	@Then("^Display Error Message 'Please enter numeric characters only'$")
	public void display_Error_Message_Please_enter_numeric_characters_only() throws Throwable {
		//To get the text of the alert
		String actualErrorMsg = driver.switchTo().alert().getText();

		String expErrorMsg = "ZIP code must have numeric characters only";
		assertEquals(expErrorMsg, actualErrorMsg);

		//To accept the alert(switch from main window to an alert)
		driver.switchTo().alert().accept();
		driver.close();
	}

	@When("^Email Id entered$")
	public void email_Id_entered() throws Throwable {
		registrationPage.setUID("161417");
		registrationPage.setPWD("supreddy");
		registrationPage.setUserName("Supriya");
		registrationPage.setAddress("Kukatpally");
		registrationPage.setCountry("India");
		registrationPage.setZipCode("500072");
		registrationPage.setEmailID("supriya.kovvuri@capgemini.com");
		registrationPage.clickLoginButton();
	}
	@When("^Invalid Email Id$")
	public void invalid_Email_Id() throws Throwable {
		registrationPage.setUID("161417");
		registrationPage.setPWD("supreddy");
		registrationPage.setUserName("Supriya");
		registrationPage.setAddress("Kukatpally");
		registrationPage.setCountry("India");
		registrationPage.setZipCode("500072");
		registrationPage.setEmailID("abc");
		registrationPage.clickLoginButton();
	}

	@Then("^Display Error Message 'Please enter valid email ID'$")
	public void display_Error_Message_Please_enter_valid_email_ID() throws Throwable {
		//To get the text of the alert
		String actualErrorMsg = driver.switchTo().alert().getText();

		String expErrorMsg = "You have entered an invalid email address!";
		assertEquals(expErrorMsg, actualErrorMsg);

		//To accept the alert(switch from main window to an alert)
		driver.switchTo().alert().accept();
		driver.close();
	}

	@When("^Upon no gender selected$")
	public void upon_no_gender_selected() throws Throwable {
		registrationPage.setUID("161417");
		registrationPage.setPWD("supreddy");
		registrationPage.setUserName("Supriya");
		registrationPage.setAddress("Kukatpally");
		registrationPage.setCountry("India");
		registrationPage.setZipCode("500072");
		registrationPage.setEmailID("supriya.kovvuri@capgemini.com");
		registrationPage.clickLoginButton();
	}

	@Then("^Display Error Message 'Please select gender'$")
	public void display_Error_Message_Please_select_gender() throws Throwable {
		//To get the text of the alert
		String actualErrorMsg = driver.switchTo().alert().getText();

		String expErrorMsg = "Please Select gender";
		assertEquals(expErrorMsg, actualErrorMsg);

		//To accept the alert(switch from main window to an alert)
		driver.switchTo().alert().accept();
		driver.close();
	}

	@When("^User entered valid details$")
	public void user_entered_valid_details() throws Throwable {
		registrationPage.setUID("161417");
		registrationPage.setPWD("supreddy");
		registrationPage.setUserName("Supriya");
		registrationPage.setAddress("Kukatpally");
		registrationPage.setCountry("India");
		registrationPage.setZipCode("500072");
		registrationPage.setEmailID("supriya.kovvuri@capgemini.com");
		registrationPage.setGender("Female");
		registrationPage.clickLoginButton();
	}

	@Then("^Display Error Message 'Your Registration with JobsWorld\\.com has successfully done'$")
	public void display_Error_Message_Your_Registration_with_JobsWorld_com_has_successfully_done() throws Throwable {
		//To get the text of the alert
		String actualErrorMsg = driver.switchTo().alert().getText();

		String expErrorMsg = "Your Registration with JobsWorld.com has successfully done plz check your registred email addres to activate your profile";
		assertEquals(expErrorMsg, actualErrorMsg);
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
