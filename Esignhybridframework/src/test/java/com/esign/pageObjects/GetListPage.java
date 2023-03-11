package com.esign.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esign.testcases.DriverBase;
import com.esign.utility.ActionDriver;

public class GetListPage extends DriverBase {
	ActionDriver act = new ActionDriver();

	public GetListPage() {
//		this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "(//span[contains(text(),'Sign')])[3]")
	@CacheLookup
	WebElement signButton;

	@FindBy(xpath = "(//span[normalize-space()='Continue to Aadhaar eSign'])[1]")
	@CacheLookup
	WebElement continue_to_Aadhaar_eSign;
//
//	@FindBy(xpath = "//button[normalize-space()='GENERATE OTP']")
//	@CacheLookup
//	WebElement generateOtpButton;
//
//	@FindBy(xpath = "(//input[@placeholder='Enter OTP'])[1]")
//	@CacheLookup
//	WebElement otpField;
//
//	@FindBy(xpath = "//button[normalize-space()='VERIFY']")
//	@CacheLookup
//	WebElement verifyButton;

//	public boolean visiblityOfJioLogo() {
//		return jioLogo.isDisplayed();
//	}
//
//	public boolean visiblityOfConsentManagerText() {
//		return consentManagerText.isDisplayed();
//	}
//
//	public boolean visiblityOfClientIdField() {
//		return clientId.isDisplayed();
//	}
//
//	public boolean visiblityOfGenerateOTP() {
//		return generateOtpButton.isDisplayed();
//	}
//
//	public boolean visiblityOfOtpField() {
//		return otpField.isDisplayed();
//	}
//
//	public boolean visiblityOfVerifyButton() {
//		return verifyButton.isDisplayed();
//	}
//
//	public void enterClientIdValue(String clientIdValue) {
//		clientId.sendKeys(clientIdValue);
//	}

	public void clickOnSignOtpButton() throws Exception {
		act.JSClick(getDriver(), signButton);
		act.explicitWait(getDriver(), continue_to_Aadhaar_eSign, 20);
		act.click(getDriver(), continue_to_Aadhaar_eSign);
	}

}
