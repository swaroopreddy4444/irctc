package com.javalaya.irctc.utility;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public enum LocatorType {
		ID, NAME, CLASS, TAG, LINK, PARTIAL_LINK, XPATH, CSS
	}

	/*
	 * public WebElement getElement(LocatorType locator, String locator_value) {
	 * switch (locator) { case ID: return
	 * this.driver.findElement(By.id(locator_value)); case NAME: return
	 * this.driver.findElement(By.name(locator_value)); case CLASS: return
	 * this.driver.findElement(By.className(locator_value)); case TAG: return
	 * this.driver.findElement(By.tagName(locator_value)); case LINK: return
	 * this.driver.findElement(By.linkText(locator_value)); case PARTIAL_LINK:
	 * return this.driver.findElement(By.partialLinkText(locator_value)); case
	 * XPATH: return this.driver.findElement(By.xpath(locator_value)); case CSS:
	 * return this.driver.findElement(By.cssSelector(locator_value)); default:
	 * return null; } }
	 * 
	 * public WebElement getElement(String value_locator) { String loc =
	 * value_locator.substring(value_locator.lastIndexOf("_") + 1); String value =
	 * null; try { value = CommonUtility.getPropertyValue("OR", value_locator); }
	 * catch (FileNotFoundException e) { System.out.println(); e.printStackTrace();
	 * } return getElement(LocatorType.valueOf(loc), value); }
	 */
	
	public WebElement getElement(LocatorType locator, String locator_value) {
		return driver.findElement(getLocator(locator, locator_value));
	}

	public WebElement getElement(String key_locator_name) {
		String loc = key_locator_name.substring(key_locator_name.lastIndexOf("_") + 1);
		String value = null;
		try {
			value = CommonUtility.getPropertyValue("OR", key_locator_name);
		} catch (FileNotFoundException e) {
			System.out.println();
			e.printStackTrace();
		}
		return getElement(LocatorType.valueOf(loc), value);
	}

	
	public WebDriver switchToWindow(int index_from_0) {
		return driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(index_from_0));
	}

	public By getLocator(LocatorType locator, String locator_value) {
		switch (locator) {
		case ID:
			return By.id(locator_value);
		case NAME:
			return By.name(locator_value);
		case CLASS:
			return By.className(locator_value);
		case TAG:
			return By.tagName(locator_value);
		case LINK:
			return By.linkText(locator_value);
		case PARTIAL_LINK:
			return By.partialLinkText(locator_value);
		case XPATH:
			return By.xpath(locator_value);
		case CSS:
			return By.cssSelector(locator_value);
		default:
			return null;
		}
	}

	public By getLocator(String value_locator) {
		String loc = value_locator.substring(value_locator.lastIndexOf("_") + 1);
		String value = null;
		try {
			value = CommonUtility.getPropertyValue("OR", value_locator);
		} catch (FileNotFoundException e) {
			System.out.println();
			e.printStackTrace();
		}
		return getLocator(LocatorType.valueOf(loc), value);
	}

	public WebElement waiting_for(String locator_value, int time, int polling) {
		 WebDriverWait w = new WebDriverWait(this.driver,Duration.ofSeconds(time));
		 
		w.pollingEvery(Duration.ofSeconds(polling));
		w.ignoring(NoSuchElementException.class);
		return w.until(ExpectedConditions.presenceOfElementLocated(getLocator(locator_value)));
	}

	public static void saveScreenshot(SearchContext driver_element) {
		
	}
}