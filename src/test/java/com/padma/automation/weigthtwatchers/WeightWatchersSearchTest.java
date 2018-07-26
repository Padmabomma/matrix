package com.padma.automation.weigthtwatchers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.padma.automation.weigthwatchers.pages.WeigthWatchersHomePage;

public class WeightWatchersSearchTest extends BaseTestCase {
	
	
	@Test
	public void search() throws InterruptedException{
		String Url="https://www.weightwatchers.com/us/";
		
		if(driver==null){
			driver = new ChromeDriver();
		}
		WeigthWatchersHomePage page= new WeigthWatchersHomePage(driver,Url);
		String ActualText = driver.getTitle();
		String ExpectedText="Weight Loss Program, Recipes & Help | Weight Watchers";
		Assert.assertEquals(ActualText, ExpectedText);
		
		page.FindAMeeting.click();
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="Get Schedules & Times Near You";
	//	Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		
		page.SearchBox.click();
		page.SearchBox.sendKeys("10011");
		page.SearchButton.click();
		
	    Thread.sleep(2000);
		System.out.println("Search result Title :"+driver.getTitle());
		
		String FirstResultName = page.firstResultName.getText();
		System.out.println("First result: "+FirstResultName);
	    String FirstResultDistance= page.firstResultDistance.getText();
	    System.out.println("First result Distance : "+FirstResultDistance);
	    
	    page.firstResultName.click();
	    System.out.println( driver.getTitle());
	    
	    String ResultDetailPageName = page.firstResultDetailName.getText();
	    Assert.assertEquals(FirstResultName, ResultDetailPageName);
	    
	    System.out.println(page.HousOfOperation.getText());
	   
	    
	    
	}

}
