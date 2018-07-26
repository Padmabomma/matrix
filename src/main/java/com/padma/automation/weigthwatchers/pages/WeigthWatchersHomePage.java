package com.padma.automation.weigthwatchers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeigthWatchersHomePage extends BasePageObject{
	
	@FindBy(xpath="//div[@class='header__right']//a[text()='Find a Meeting ']")
	public
	
	WebElement FindAMeeting;
	
	@FindBy(xpath="//input[@id='meetingSearch']")
	public
	
	WebElement SearchBox;
	
	@FindBy(xpath="//button[@class='btn btn-default form-blue-pill__btn']")
	public
	
	WebElement SearchButton;
	
	@FindBy(xpath="//div[@id='ml-1180510']//div[@class='location__name']")
	public WebElement firstResultName;
	
	@FindBy(xpath="//div[@id='ml-1180510']//div[@class='location__distance']")
	public WebElement firstResultDistance;
	
	@FindBy(xpath="//div[@class='meeting-columns__spacing-wrapper']//div[@class='location__name']")
	public WebElement firstResultDetailName;
	
	@FindBy(xpath="//div[@class='hours-list-item-wrapper hours-list--currentday']")
	public WebElement HousOfOperation;
	
	public WeigthWatchersHomePage(WebDriver driver ,String url) throws InterruptedException{
		super.webdriver=driver;
		webdriver.get(url);
		Thread.sleep(3000);
		PageFactory.initElements(driver, this);
		
	}

}
