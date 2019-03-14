package com.logmein.testing.pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage {
	
    private final WebDriver browser;

    public HomePage(WebDriver driver) {
        this.browser = driver;

        // Check that we're on the right page.
        if (!"Login".equals(browser.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }


}
