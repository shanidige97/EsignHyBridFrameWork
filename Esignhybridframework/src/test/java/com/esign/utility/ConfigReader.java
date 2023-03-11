package com.esign.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;

	public ConfigReader() {

		File file = new File("./Configuration/Config.properties");
		try {
			FileInputStream src = new FileInputStream(file);
			prop = new Properties();
			prop.load(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public String launchBrowser() {
//		String browser = prop.getProperty("browser");
//		return browser;
//
//	}

	public String jioSignHomeURL() {
		String jioSignHomeURL = prop.getProperty("jioSignHomeURL");
		return jioSignHomeURL;

	}

		public String emailIdValue() {
			String emailId = prop.getProperty("emailId");
			return emailId;

		}
//
//		public String emailId() {
//			String emailId = prop.getProperty("emailId");
//			return emailId;
//
//		}
//
		public String username() {
			String username = prop.getProperty("username");
			return username;

		}

		public String password() {
			String password = prop.getProperty("pwd");
			return password;

		}
//		public String otp() {
//			String otp = prop.getProperty("otp");
//			return otp;
//
//		}
//	}

}
