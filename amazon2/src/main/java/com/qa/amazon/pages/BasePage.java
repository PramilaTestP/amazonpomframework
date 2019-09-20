package com.qa.amazon.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.amazon.abstraction.Page;
import io.appium.java_client.android.AndroidDriver;

public class BasePage extends Page {
	
	// create a method with Java Generics and return a new page	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(AndroidDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
		} catch (Exception e) {
			//logger
			return null;
		}
	}
	

	public BasePage(AndroidDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public void doClick(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}

	@Override
	public String doGetText(By locator) {
		return driver.findElement(locator).getText();
	}

	@Override
	public void presenceOfElement(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	
	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;

		try {
			driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("error occured in getting an element" + locator.toString());
		}
		return element;

	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		} catch (Exception e) {
			System.out.println("error occured in waiting an element" + locator.toString());
		}

	}
	
	

}
