package com.esign.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esign.pageObjects.AddAadhaarEsignPage;
import com.esign.pageObjects.AddSignatureCardPage;
import com.esign.pageObjects.DashboardPage;
import com.esign.pageObjects.GetListPage;
import com.esign.pageObjects.HomePage;
import com.esign.pageObjects.LoginPage;
import com.esign.pageObjects.Sign_in_Jio_accountPage;
import com.esign.utility.ConfigReader;
import com.esign.utility.Log;

public class AddSignatureCardEsignPageTestcases extends DriverBase {

	public AddSignatureCardEsignPageTestcases() {
		super();
	}

	ConfigReader cf = new ConfigReader();
	HomePage homePage;
	LoginPage loginPage;
	Sign_in_Jio_accountPage sign_in_Jio_accountPage;
	DashboardPage dashboardPage;
	AddAadhaarEsignPage addAadhaarEsignPage;
	AddSignatureCardPage addSignatureCardPage;
	GetListPage getListPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void name(String browser) throws Exception {
		intilization(browser);
		homePage = new HomePage();
		loginPage = new LoginPage();
		sign_in_Jio_accountPage = new Sign_in_Jio_accountPage();
		dashboardPage = new DashboardPage();
		addAadhaarEsignPage = new AddAadhaarEsignPage();
		addSignatureCardPage = new AddSignatureCardPage();

		loginPage = homePage.clickOnSigUpJioSignAccountButton();
		sign_in_Jio_accountPage = loginPage.clickOnProceedButton(cf.emailIdValue());
		dashboardPage = sign_in_Jio_accountPage.clickOnLoginButton(cf.username(), cf.password());
		addAadhaarEsignPage = dashboardPage.clickOnUploadDocumentButtonButton();
		addSignatureCardPage = addAadhaarEsignPage.navigateToNextPage();
	}

	@Test(priority = 0, groups = { "sanity", "regression" })
	public void clickOnaddSignatureCardPageButton() throws Exception {
		Log.startTestCase("clickOnaddSignatureCardPageButton");
		getListPage = addSignatureCardPage.clickOnGenerateOtpButton();
		Log.endTestCase("clickOnaddSignatureCardPageButton");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() throws IOException, InterruptedException {
		getDriver().close();
	}
}
