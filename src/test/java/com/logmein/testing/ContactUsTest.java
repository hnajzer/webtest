package com.logmein.testing;

import static org.junit.Assert.assertEquals;

import java.nio.file.FileSystems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsTest 
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
	public void contactUsSendMessage(){
    	browser.get("http://automationpractice.com/");
        WebElement contactUsButton = browser.findElement(By.linkText("Contact us"));
        contactUsButton.click();
        
        Select subjectSelector = new Select(browser.findElement(By.id("id_contact")));
        subjectSelector.selectByVisibleText("Webmaster");
        
        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys("test@example.com");
        
        WebElement orderRefNum = browser.findElement(By.id("id_order"));
        orderRefNum.sendKeys("98765");
        
        WebElement message = browser.findElement(By.id("message"));
        message.sendKeys("test msg");
        
        WebElement sendButton = browser.findElement(By.id("submitMessage"));
        (new WebDriverWait(browser, 5)).until(ExpectedConditions.elementToBeClickable(sendButton));
        
        sendButton.click();
        
        WebElement successField = browser.findElement(By.cssSelector("p.alert-success"));
        (new WebDriverWait(browser, 5)).until(ExpectedConditions.visibilityOf(successField));

        assertEquals("Success message is not the expected!", "Your message has been successfully sent to our team.", successField.getText());
	}
    
	@After
	public void After() {
		browser.quit();
	}
}
