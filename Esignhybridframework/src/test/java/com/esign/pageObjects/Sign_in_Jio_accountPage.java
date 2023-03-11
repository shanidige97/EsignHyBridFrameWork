package com.esign.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esign.testcases.DriverBase;
import com.esign.utility.ActionDriver;

public class Sign_in_Jio_accountPage extends DriverBase {
	ActionDriver act = new ActionDriver();

	public Sign_in_Jio_accountPage() {
//		this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//input[@placeholder='user name or email']")
	@CacheLookup
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	@CacheLookup
	WebElement loginButton;

	public boolean visiblityOfUsername() {
		return username.isDisplayed();
	}

	public boolean visiblityOfPassword() {
		return password.isDisplayed();
	}

	public boolean visiblityOfLoginButton() {
		return loginButton.isDisplayed();
	}

	public DashboardPage clickOnLoginButton(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		act.click(getDriver(), loginButton);
		return new DashboardPage();
	}

}
