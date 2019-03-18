package com.logmein.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
    private final WebDriver browser;

    By emailLocator = By.id("email");
    By passwordLocator = By.id("passwd");
    By submitLoginButtonLocator = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        this.browser = driver;
    }

    public LoginPage typeEmail(String email) {
        browser.findElement(emailLocator).sendKeys(email);
        return this;	
    }

    public LoginPage typePassword(String password) {
        browser.findElement(passwordLocator).sendKeys(password);
        return this;	
    }

    public HomePage submitLogin() {
        browser.findElement(submitLoginButtonLocator).click();
        return new HomePage(browser);	
    }

    public HomePage loginAs(String email, String password) {
    	typeEmail(email);
        typePassword(password);
        return submitLogin();
    }
}
