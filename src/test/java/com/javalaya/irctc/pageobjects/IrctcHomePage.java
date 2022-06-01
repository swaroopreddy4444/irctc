package com.javalaya.irctc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.javalaya.irctc.utility.BasePage;

public class IrctcHomePage extends BasePage {

	public IrctcHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(IrctcHomePage.super.driver, IrctcHomePage.this);
	}

	public IrctcHomePage clickPopup() {

		super.getElement("OR.popup_XPATH").click();
		return this;
	}
	public FlightsPage clickonFlights() {
		super.getElement(LocatorType.LINK,"FLIGHTS").click();
		super.switchToWindow(1);  //		switching to the new tab opened for driver actions
		return new FlightsPage(super.driver);
	}

}
