package com.logmein.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
    private final WebDriver browser;
    By signInButtonLocator = By.cssSelector("a.login");
    By myAccountButtonLocator = By.cssSelector("a.account");

    public HomePage(WebDriver driver) {
        this.browser = driver;

        // Check that we're on the right page.
        if (!"Login".equals(browser.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage signIn(String email, String password) {
    	browser.findElement(signInButtonLocator).click();
        return new LoginPage(browser);
    }
}
