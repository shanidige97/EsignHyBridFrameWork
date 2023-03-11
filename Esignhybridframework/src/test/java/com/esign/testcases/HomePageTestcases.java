package com.esign.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esign.pageObjects.HomePage;
import com.esign.pageObjects.LoginPage;
import com.esign.utility.Log;
import com.github.dockerjava.api.model.Info;

public class HomePageTestcases extends DriverBase {

	public HomePageTestcases() {
		super();
	}

	HomePage homePage;
	LoginPage loginPage;

	@Parameters("browser")
	@BeforeMethod( groups = { "Smoke", "Sanity", "Regression" })
	public void name(String browser) throws Exception {
		intilization(browser);
		homePage = new HomePage();

	}

	@Test(priority = 0, groups = { "regression" })
	public void verifyPageTitlePage() throws InterruptedException {
		Assert.assertEquals("Jio Sign", getDriver().getTitle());
	}

	@Test(priority = 1, groups = { "regression" })
	public void visiblityOfSigUpJioSignAccountButtonTest() throws InterruptedException {
		Log.info("checked visiblityOfSigUpJioSignAccountButton");
		Assert.assertEquals(true, homePage.visiblityOfSigUpJioSignAccountButton());
	}

	@Test(priority = 2, groups = { "sanity", "regression" })
	public void clickOnSignUpButton() throws InterruptedException {
		Log.startTestCase("clickOnSignUpButton");
		loginPage = homePage.clickOnSigUpJioSignAccountButton();
		Log.endTestCase("clicked on sign up button");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() throws IOException, InterruptedException {
		getDriver().close();

	}
}
