package com.esign.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.esign.testcases.DriverBase;

public class Listeners extends DriverBase implements ITestListener {
	WebDriver driver;
	ExtentTest test;
	ExtentReports extentReports = ExtentReporterNG.getReportObject();
	ThreadLocal extentTest = new ThreadLocal();

	public void onTestStart(ITestResult result) {
		test = extentReports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test pass Sucessfully");
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test skip Sucessfully");
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.ORANGE));
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("getDriver()")
//					.get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String filePath = null;
		try {

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			filePath = getScreenshot(result.getMethod().getMethodName(), getDriver());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
}
