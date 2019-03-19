package com.logmein.testing;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
 
public class VisualVerificationTest {
 
    public static void main(String[] args) throws URISyntaxException, InterruptedException {
		String driverPath = FileSystems.getDefault().getPath("src/test/resources/chromedriver").toString();
		System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
 
        Eyes eyes = new Eyes();
        // This is your api key, make sure you use it in all your tests.
        eyes.setApiKey("50CNzP1031rHlgSKOPhHcUQrlI36h5h8I82jx0giQy107AQ110");
 
        try {
            // Start visual testing with browser viewport set to 1024x768.
            // Make sure to use the returned driver from this point on.
            driver = eyes.open(driver, "Applitools", "Test Web Page");
 
            driver.get("http://applitools.com");
 
            // Visual validation point #1
            eyes.checkWindow("Main Page");
 
            driver.findElement(By.linkText("Features")).click();
 
            // Visual validation point #2
            eyes.checkWindow("Features page");
 
            // End visual testing. Validate visual correctness.
            eyes.close();
        } finally {
            // Abort test in case of an unexpected error.
            eyes.abortIfNotClosed();
            driver.close();
        }
    }
 }