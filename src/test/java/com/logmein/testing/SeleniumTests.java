package com.logmein.testing;

import java.nio.file.FileSystems;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTests 
{
	private WebDriver browser;
	
	@Before
	public void Before() {
		String driverPath = FileSystems.getDefault().getPath("src/test/resources/geckodriver").toString();
		System.setProperty("webdriver.gecko.driver", driverPath);
   	
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("marionette", true);
		firefoxOptions.setHeadless(false);
		
		browser = new FirefoxDriver(firefoxOptions);
	}

    @Test
	public void searchForTextUseId() throws InterruptedException{
    	browser.get("http://automationpractice.com/");
    	WebElement searchField = browser.findElement(By.id("search_query_top"));
        searchField.sendKeys("by id");
	}
    
    @Test
	public void searchForTextUseName(){
    	browser.get("http://automationpractice.com/");
        WebElement searchField = browser.findElement(By.name("search_query"));
        searchField.sendKeys("by name");
	}
    
    @Test
	public void searchForTextUseClassName(){
    	browser.get("http://automationpractice.com/");
        WebElement searchField = browser.findElement(By.className("search_query"));
        searchField.sendKeys("by className");
	}
    
    // example for tag name
    // also an example for the fact
    // that you really should try to use a specific locator :)
    @Test
	public void signUpForNewsUseTagName(){
    	browser.get("http://automationpractice.com/");
    	// since there are multiple buttons on the site
    	// this locator will return with the first one
    	// which is not really what we're looking for
    	WebElement newsField = browser.findElement(By.id("newsletter_block_left"));
        WebElement signUpButton = newsField.findElement(By.tagName("button"));
        signUpButton.click();
	}
    
    // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
    @Test
	public void contactUsSendEmptyMessage(){
    	browser.get("http://automationpractice.com/");
        WebElement contactUsButton = browser.findElement(By.linkText("Contact us"));
        contactUsButton.click();
        
        (new WebDriverWait(browser, 5)).until(ExpectedConditions.elementToBeClickable(By.id("submitMessage")));
        
        WebElement sendButton = browser.findElement(By.id("submitMessage"));
        sendButton.click();
	}
    
	@After
	public void After() {
		browser.quit();
	}
}
