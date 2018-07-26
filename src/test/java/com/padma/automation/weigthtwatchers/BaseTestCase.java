package com.padma.automation.weigthtwatchers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestCase {
	WebDriver driver;
	Properties config = new Properties();

	@BeforeTest
	public void setUp() {
		loadConfig();

		String defaultDriverPath = "C:\\Padma\\ChromeDriver\\chromedriver.exe";

		if (config.getProperty("webdriver.chrome.driver") != null) {
			defaultDriverPath = config.getProperty("webdriver.chrome.driver");
		}
		System.setProperty("webdriver.chrome.driver", defaultDriverPath);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	private void loadConfig() {

		InputStream input = null;

		try {
			String filename = "app.properties";
			// input = new FileInputStream("app.properties");
			input = BaseTestCase.class.getClassLoader().getResourceAsStream(
					filename);
			// load a properties file
			config.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
