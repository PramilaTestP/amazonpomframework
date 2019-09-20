package com.qa.amazon.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.qa.amazon.abstraction.Page;
import com.qa.amazon.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest  {
	
	public BasePage page;
	public  AndroidDriver driver;
	public WebDriverWait wait;
	public DesiredCapabilities dsrdCaps = new DesiredCapabilities();
	public Logger log = Logger.getLogger(Logger.class.getName());

	@Parameters({ "deviceName_","UDID_","platformVersion_", "ip_","port_" })
	@BeforeTest
	public void setup(String deviceName_,String UDID_,String platformVersion_,String ip_,String port_) throws MalformedURLException {
		 log.info("Capabilities setting is started");
		dsrdCaps.setCapability("automationName", "UiAutomator2");
		dsrdCaps.setCapability("platformVersion", platformVersion_);
		dsrdCaps.setCapability("platformName", "Android");
		dsrdCaps.setCapability("deviceName", deviceName_);
		dsrdCaps.setCapability("udid", UDID_);
		// dsrdCaps.setCapability("noReset", "false");
		dsrdCaps.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		dsrdCaps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		dsrdCaps.setCapability("app", "C:\\SeleniumPramila\\amazon2\\resources\\Apks\\Amazon.apk");
		String serverUrl = "http://"+ip_+":"+port_+"/wd/hub";
		try {
			driver = new AndroidDriver<MobileElement>(new URL(serverUrl), dsrdCaps);
		} catch (MalformedURLException e) {
			System.out.println("Error in launching driver"+e);
		}
		
		System.out.println("Android Driver init done");
		wait=new WebDriverWait(driver,20);
		page = new BasePage(driver, wait);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}



