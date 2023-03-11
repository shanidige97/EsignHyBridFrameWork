package com.esign.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.esign.utility.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverBase {

//	public static WebDriver driver;
	public static Logger logger;
	static ConfigReader cf = new ConfigReader();

	public static ThreadLocal<WebDriver> Tdriver = new ThreadLocal<WebDriver>();

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadLogs() {
		DOMConfigurator.configure("log4j.xml");
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true, groups = { "Smoke", "Sanity", "Regression" })
	public static void intilization(String browser) throws IOException, InterruptedException {

//		String browser = cf.launchBrowser();
		if (browser.equalsIgnoreCase("chrome")) {
//			driver = WebDriverManager.chromedriver().create();
			WebDriverManager.chromedriver().setup();
			Tdriver.set(new ChromeDriver());

		} else if (browser.equalsIgnoreCase("edge")) {
//			driver = WebDriverManager.edgedriver().create();
			WebDriverManager.edgedriver().setup();
			Tdriver.set(new EdgeDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		getDriver().get(cf.jioSignHomeURL());
		//

	}

	public static synchronized WebDriver getDriver() {
		return Tdriver.get();

	}

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
	static LocalDateTime now = LocalDateTime.now();

	public String getScreenshot(String Testname, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(
				System.getProperty("user.dir") + "//Screenshots//" + Testname + "-" + dtf.format(now) + ".png");
		FileUtils.copyFile(src, des);
		return System.getProperty("user.dir") + "//Screenshots//" + Testname + dtf.format(now) + ".png";

	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		getDriver().quit();
	}

}
