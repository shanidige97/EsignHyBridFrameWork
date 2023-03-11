package com.esign.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esign.testcases.DriverBase;
import com.esign.utility.ActionDriver;

public class AddSignatureCardPage extends DriverBase {
	ActionDriver act = new ActionDriver();

	public AddSignatureCardPage() {
//		this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//div[contains(text(),'Signature')]")
	@CacheLookup
	WebElement signatureCard;

	@FindBy(xpath = "(//span[contains(text(),'Next')])[1]")
	@CacheLookup
	WebElement NextButton;

	@FindBy(xpath = "(//span[normalize-space()='Send'])[1]")
	@CacheLookup
	WebElement SendButton;

	@FindBy(xpath = "//span[normalize-space()='Go to Document List']")
	@CacheLookup
	WebElement getListButton;

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
	public void dragSignature() throws Exception {
		act.draggableAndRelaese(getDriver(), signatureCard, 400, 200);
	}

	public GetListPage clickOnGenerateOtpButton() throws Exception {
		Thread.sleep(3000);
		dragSignature();
		act.click(getDriver(), NextButton);
		act.implicitWait(getDriver(), 20);
		act.click(getDriver(), SendButton);
		Thread.sleep(1000);
		act.click(getDriver(), getListButton);
		Thread.sleep(1000);
		return new GetListPage();
	}

}
