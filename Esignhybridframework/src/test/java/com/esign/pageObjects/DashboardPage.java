package com.esign.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esign.testcases.DriverBase;
import com.esign.utility.ActionDriver;

public class DashboardPage extends DriverBase {
	ActionDriver act = new ActionDriver();

	public DashboardPage() {
//		this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//div[contains(text(),'Upload Document')]")
	@CacheLookup
	WebElement uploadDocumentButton;
	
	@FindBy(xpath = "(//span[@class='MuiButton-label'])[1]")
	@CacheLookup
	WebElement NextButton;
	
	

	public boolean visiblityOfUploadDocumentButton() {
		return uploadDocumentButton.isDisplayed();
	}

	public void uploadDocument() throws AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		StringSelection stringselection = new StringSelection("C:\\Users\\Shani.Dige\\Downloads\\55056114-ECard.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.setAutoDelay(1000);

		// Press CTRL+V button
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V button
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(1000);

		// Press the Enter button
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public AddAadhaarEsignPage clickOnUploadDocumentButtonButton() throws AWTException, InterruptedException {
		uploadDocumentButton.click();
		uploadDocument();
		Thread.sleep(2000);
		act.click(getDriver(), NextButton);
		return new AddAadhaarEsignPage();
	}

}
