package com.logmein.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystems;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest 
{
	private WebDriver browser;
	
	@Before
	public void Before() {
		String driverPath = FileSystems.getDefault().getPath("src/test/resources/chromedriver").toString();
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		browser = new ChromeDriver(options);
	}

    @Test
	public void openNewTabsWindows(){
    	browser.get("http://automationpractice.com/");
    	
    	WebElement signInButton = browser.findElement(By.cssSelector("a.login"));
    	signInButton.click();
    	
    	WebElement submitLoginButton = browser.findElement(By.id("SubmitLogin"));
        (new WebDriverWait(browser, 10)).until(ExpectedConditions.elementToBeClickable(submitLoginButton));
        
        WebElement email = browser.findElement(By.id("email"));
        WebElement passwd = browser.findElement(By.id("passwd"));
    	
        email.sendKeys("najzer.helga@gmail.com");
        passwd.sendKeys("test1234");
        submitLoginButton.click();
        
    	WebElement myAccountButton = browser.findElement(By.cssSelector("a.account"));
        (new WebDriverWait(browser, 5)).until(ExpectedConditions.elementToBeClickable(myAccountButton));
        
        assertEquals("The account logged in is not the expected one!", "szte test", myAccountButton.getText());
	}
    
    @Test
	public void openNewTabsWindowsWithPOs(){

	}
    
	@After
	public void After() {
		browser.quit();
	}
}
