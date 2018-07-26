package com.padma.automation.weigthtwatchers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.padma.automation.weigthwatchers.pages.WeigthWatchersHomePage;

public class WeightWatchersSearchTest extends BaseTestCase {
	
	
	@Test
	public void findAMeeting() throws InterruptedException{
		String Url="https://www.weightwatchers.com/us/";
		
		if(driver==null){
			driver = new ChromeDriver();
		}
		WeigthWatchersHomePage homepage= new WeigthWatchersHomePage(driver,Url);
		String ActualText = driver.getTitle();
		String ExpectedText="Weight Loss Program, Recipes & Help | Weight Watchers";
		Assert.assertEquals(ActualText, ExpectedText, "Page titles not matches.");
		
		homepage.FindAMeeting.click();
		String ActualTitle=driver.getTitle();
	    Assert.assertTrue(ActualTitle.contains("Get Schedules & Times Near You"), "Page title not contains 'Get Schedules & Times Near You'");
	    
	    homepage.SearchBox.click();
	    homepage.SearchBox.sendKeys("10011");
	    homepage.SearchButton.click();
		
	    homepage.waitForPageLoad();
		System.out.println("Search result Title :"+driver.getTitle());
		
		String FirstResultName = homepage.firstResultName.getText();
		System.out.println("First result: "+FirstResultName);
		
	    String FirstResultDistance= homepage.firstResultDistance.getText();
	    System.out.println("First result Distance : "+FirstResultDistance);
	    
	    homepage.firstResultName.click();
	 	    
	    String ResultDetailPageName = homepage.firstResultDetailName.getText();
	    Assert.assertEquals(FirstResultName, ResultDetailPageName);
	    
	    System.out.println("TODAY’s hours of operation :- "+homepage.HousOfOperation.getText());
	   
	    
	    
	}

}
