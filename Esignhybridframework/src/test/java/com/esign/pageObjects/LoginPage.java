package com.esign.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esign.testcases.DriverBase;
import com.esign.utility.ActionDriver;

public class LoginPage extends DriverBase {
	ActionDriver act = new ActionDriver();

	

	public LoginPage() {
//		this.driver = getDriver();
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[contains(text(),'Personal')]")
	@CacheLookup
	WebElement personalButton;

	@FindBy(css = "input#nameInput")
	@CacheLookup
	WebElement emailId;

	@FindBy(xpath = "//span[contains(text(),'Proceed')]")
	@CacheLookup
	WebElement proceedButton;

	@FindBy(xpath = "//span[normalize-space()='Sign in using RIL domain password']")
	@CacheLookup
	WebElement signinusingRILdomainButton;
	
	
	
	public boolean visiblityOfPersonalButton() {
		return personalButton.isDisplayed();
	}

	public boolean visiblityOfemailId() {
		return emailId.isDisplayed();
	}

	public boolean visiblityOfProceedButton() {
		return proceedButton.isDisplayed();
	}

	public Sign_in_Jio_accountPage clickOnProceedButton(String emailIdValue) throws Exception {
//		personalButton.click();
		act.JSClick(getDriver(), personalButton);
		emailId.sendKeys(emailIdValue);
		act.JSClick(getDriver(), proceedButton);
		act.click(getDriver(), signinusingRILdomainButton);
		return new Sign_in_Jio_accountPage();
	}

}
