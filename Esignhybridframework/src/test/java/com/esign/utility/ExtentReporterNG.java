package com.esign.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static Date date = new Date();
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	static String strDate = formatter.format(date);

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "//Reports_Day_Wise//" + strDate + "-Report.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("Web Automation report");
		extentSparkReporter.config().setDocumentTitle("Test Results");

		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Shani Dige");

		return extentReports;

	}

}
