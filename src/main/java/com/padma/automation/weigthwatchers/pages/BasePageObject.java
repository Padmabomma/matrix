package com.padma.automation.weigthwatchers.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
protected WebDriver webdriver;
	
	public BasePageObject() {
		super();

		//waitForPageLoad();
	}

    protected void waitForPageLoad(){
		
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(webdriver, 90);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			org.testng.Assert.fail("Timeout while waiting for Page Load to complete.");
		}
	}
	
}
