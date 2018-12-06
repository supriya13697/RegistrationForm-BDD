package com.cg.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageFactory {
	WebDriver driver;

	//Locates an element by its name
	@FindBy(name="userid")
	@CacheLookup
	WebElement userID;
	
	@FindBy(name="passid")
	@CacheLookup
	WebElement pwdID;
	
	@FindBy(name="submit")
	@CacheLookup
	WebElement submit;
	
	//Locates an element by its ID
	@FindBy(id="usrname")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(name="country")
	@CacheLookup
	WebElement country;
	
	@FindBy(name="zip")
	@CacheLookup
	WebElement zipCode;
	
	@FindBy(name="email")
	@CacheLookup
	WebElement emailID;
	
	@FindBy(name="sex")
	@CacheLookup
	WebElement gender1;
	
	@FindBy(name="sex")
	@CacheLookup
	WebElement gender2;
	
	public RegistrationPageFactory()
	{	
	}

	public RegistrationPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUID(String uid) {
		userID.sendKeys(uid);
	}
	
	public void setPWD(String pwd) {
		pwdID.sendKeys(pwd);
	}
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	
	public void setAddress(String add) {
		address.sendKeys(add);
	}
	
	public void setCountry(String c) {
		country.sendKeys(c);
	}
	
	public void setZipCode(String zcode) {
		zipCode.sendKeys(zcode);
	}
	
	public void setEmailID(String eid) {
		emailID.sendKeys(eid);
	}
	
	public void setGender(String gen) {
		if(gen.equalsIgnoreCase("female"))
			gender2.click();
		else
			gender1.click();
	}
	
	public void clickLoginButton() {
		submit.click();
	}
}
