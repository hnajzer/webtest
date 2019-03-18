package com.logmein.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	
    private final WebDriver browser;

    By subjectSelectorLocator = By.id("id_contact");
    By emailLocator = By.id("email");
    By orderRefNumLocator = By.id("id_order");
    By messageLocator = By.id("message");
    By sendMessageButtonLocator = By.id("submitMessage");

    public ContactUsPage(WebDriver browser) {
        this.browser = browser;
        
        // wait until the page is interactable
        WebElement sendButton = browser.findElement(sendMessageButtonLocator);
        (new WebDriverWait(browser, 5)).until(ExpectedConditions.elementToBeClickable(sendButton));
    }

    public ContactUsPage selectSubject(String subject) {
    	Select subjectSelector = new Select(browser.findElement(subjectSelectorLocator));
    	subjectSelector.selectByVisibleText(subject);
        return this;	
    }
    
    public ContactUsPage typeEmail(String email) {
        browser.findElement(emailLocator).sendKeys(email);
        return this;	
    }

    public ContactUsPage typeOrderRefNum(String orderRefNum) {
        browser.findElement(orderRefNumLocator).sendKeys(orderRefNum);
        return this;	
    }

    public ContactUsPage typeMessage(String message) {
        browser.findElement(messageLocator).sendKeys(message);
        return this;	
    }

    public HomePage sendMessage() {
    	browser.findElement(sendMessageButtonLocator).click();
        return new HomePage(browser);
    }
}
