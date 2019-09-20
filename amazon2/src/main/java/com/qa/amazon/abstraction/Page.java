package com.qa.amazon.abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.amazon.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;

public abstract class Page {

	public AndroidDriver driver;
	public WebDriverWait wait;

	// page class constructor:
	public Page(AndroidDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}	
	
	public abstract void waitForElementPresent(By locator);
	public abstract void presenceOfElement(By locator);
	public abstract String doGetText(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void doClick(By locator);

}
