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

        // Check that we're on the right page.
        if (!"Login".equals(browser.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage typeEmail(String email) {
        // This is the only place that "knows" how to enter the email
        browser.findElement(emailLocator).sendKeys(email);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;	
    }

    // The login page allows the user to type their password into the password field
    public LoginPage typePassword(String password) {
        // This is the only place that "knows" how to enter a password
        browser.findElement(passwordLocator).sendKeys(password);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;	
    }

    // The login page allows the user to submit the login form
    public HomePage submitLogin() {
        // This is the only place that submits the login form and expects the destination to be the home page.
        // A seperate method should be created for the instance of clicking login whilst expecting a login failure. 
        browser.findElement(submitLoginButtonLocator).click();

        // Return a new page object representing the destination. Should the login page ever
        // go somewhere else (for example, a legal disclaimer) then changing the method signature
        // for this method will mean that all tests that rely on this behaviour won't compile.
        return new HomePage(browser);	
    }

    // Conceptually, the login page offers the user the service of being able to "log into"
    // the application using a user name and password. 
    public HomePage loginAs(String email, String password) {
        // The PageObject methods that enter username, password & submit login have already defined and should not be repeated here.
    	typeEmail(email);
        typePassword(password);
        return submitLogin();
    }
}
