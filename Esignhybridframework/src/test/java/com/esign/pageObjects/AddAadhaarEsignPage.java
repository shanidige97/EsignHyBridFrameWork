package com.esign.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esign.testcases.DriverBase;
import com.esign.utility.ActionDriver;

public class AddAadhaarEsignPage extends DriverBase {
	ActionDriver act = new ActionDriver();

	public AddAadhaarEsignPage() {
//		this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "(//div[@aria-labelledby='demo-mutiple-checkbox-label demo-mutiple-checkbox'])[1]")
	@CacheLookup
	WebElement dropdown;

	@FindBy(xpath = "(//span[contains(text(),'Next')])[1]")
	@CacheLookup
	WebElement NextButton;
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
//	public void clickOnNextButton() {
//		act.click(getDriver(), NextButton);
//	}

	public void clickOnAadhaarEsignDropdownButton() {
		act.click(getDriver(), dropdown);
		List<WebElement> allOptions = getDriver().findElements(By.tagName("label"));

		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains("Aadhaar eSign"))

			{
				allOptions.get(i).click();
				break;
			}
		}

		WebElement element = getDriver().switchTo().activeElement();
		element.sendKeys(Keys.ESCAPE);
		System.out.println("espace");
	}

	public AddSignatureCardPage navigateToNextPage() {
		clickOnAadhaarEsignDropdownButton();
		System.out.println("click on next button after dropdown");
		NextButton.click();
		System.out.println("clicked----------------------- on next button after dropdown");
		return new AddSignatureCardPage();

	}
}
