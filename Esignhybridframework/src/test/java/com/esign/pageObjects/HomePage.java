package com.esign.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esign.testcases.DriverBase;
import com.esign.utility.ActionDriver;

public class HomePage extends DriverBase {
	ActionDriver act = new ActionDriver();

	public HomePage() {
//		this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[contains(text(),'Sign up for JioSign account')]")
	@CacheLookup
	private WebElement sign_up_JioSign_account;

	public boolean visiblityOfSigUpJioSignAccountButton() {
		return sign_up_JioSign_account.isDisplayed();
	}

	public LoginPage clickOnSigUpJioSignAccountButton() {

		act.click(getDriver(), sign_up_JioSign_account);
		return new LoginPage();
	}

}
