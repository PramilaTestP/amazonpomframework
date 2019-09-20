package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;

public class CategorySelectionPage extends BasePage {

	public CategorySelectionPage(AndroidDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// page locators:

	private By electronics = By.xpath("//android.view.View[contains(@text, 'TV, Appliances, Electronics')]");

	private By kindle = By.xpath("//android.view.View[contains(@text, 'Kindle E-Readers & eBooks')]");

	private By kindleEreader = By.xpath("//android.view.View[contains(@text, 'Kindle E-Readers ')]");

	// To simulate error when element does not exist
	// By nonexistingElement = By.xpath("//android.view.View[contains(@text,
	// 'nonexistingElement')]");

	public WebElement getElectronics() {
		waitForElementPresent(electronics);
		return getElement(electronics);
	}

	public WebElement getKindle() {
		waitForElementPresent(kindle);
		return getElement(kindle);
	}

	public WebElement getKindleEreader() {
		waitForElementPresent(kindleEreader);
		return getElement(kindleEreader);
	}

	public void clickElectronincs() {
		waitForElementPresent(electronics);
		doClick(electronics);
	}
	
	public void clickKindle() {
		waitForElementPresent(kindle);
		doClick(kindle);
	}
	
	
	public void verifyKindleElement() throws Exception {
		doClick(electronics);
		Assert.assertEquals(doGetText(electronics), "TV, Appliances, Electronics");
		doClick(kindle);
		Assert.assertEquals(doGetText(kindle), "Kindle E-Readers & eBooks");
		try {
			presenceOfElement(kindleEreader);
		} catch (Exception e) {
			throw new Exception("Element Not found");
		}
	}
	
	


}
