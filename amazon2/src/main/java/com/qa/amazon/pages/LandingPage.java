package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;

public class LandingPage extends BasePage {

	public LandingPage(AndroidDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// page locators:
	private By shopByCatgory = By.xpath("//android.widget.TextView[contains(@text, 'Shop by Category')]");
	private By header = By.xpath("//android.widget.TextView[contains(starts-with(@text,'Shop')]");
	private By hamburger = By.xpath(
			"//android.widget.ImageView[@resource-id='in.amazon.mShop.android.shopping:id/action_bar_burger_icon']");


	
	public WebElement getHamburger() {
		waitForElementPresent(hamburger);
		return getElement(hamburger);		
	}

	public WebElement getShopByCategory() {
		waitForElementPresent(shopByCatgory);
		return getElement(shopByCatgory);
	}

	public WebElement getHeader() {
		waitForElementPresent(header);
		return getElement(header);
	}
	
	
	public void clickHamburger() {
		waitForElementPresent(hamburger);
		doClick(hamburger);
	}

	public CategorySelectionPage selectShopByCategory() {
		doClick(shopByCatgory);		
		return getInstance(CategorySelectionPage.class);
	}

}
