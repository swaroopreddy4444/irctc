package com.javalaya.irctc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.javalaya.irctc.utility.BasePage;

public class FlightsPage extends BasePage {

	public FlightsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(FlightsPage.super.driver, FlightsPage.this);
	}

	public boolean verifyOneWayRadioBtnSelection() {
		return super.getElement(LocatorType.ID, "OneWay").isSelected();
	}

}
