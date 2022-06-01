package com.javalaya.irctc.testrunner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.javalaya.irctc.pageobjects.FlightsPage;
import com.javalaya.irctc.pageobjects.IrctcHomePage;
import com.javalaya.irctc.utility.BasePage;
import com.javalaya.irctc.utility.BrowserFactory;
import com.javalaya.irctc.utility.CommonUtility;

public class IRCTC_Runner {
	WebDriver driver;

	@Test
	public void validate_OneWayRadioTest() throws Throwable {
		String result = "fail", errorMessage = null;
		try {
			// step 1 - open browser - read browser name, and open browser
			String browserName = CommonUtility.getPropertyValue("config", "config.browsername");
			this.driver = BrowserFactory.openLocalBrowser(browserName);
			Reporter.log("Step 1: " + browserName + " is loaded successfully");

			// Step 2- launch application - read url name, and launch that url in the
			// browser
			String url = CommonUtility.getPropertyValue("config", "config.url");
			BrowserFactory.launchApp(url);
			Reporter.log("Step 2: " + url + " is loaded successfully");

			// Step3- click ok in popup in home page
			IrctcHomePage home = new IrctcHomePage(driver);
			home.clickPopup();
			Reporter.log("Step 3: ok clicked successfully");

			// Step4 - click on FLGIHTs link in the Homepage
			FlightsPage Flights = home.clickonFlights();
			Reporter.log("Step 4: clicked Flights successfully");

			// Step4 - check for one way radio button default selection in flights page
			Assert.assertTrue(Flights.verifyOneWayRadioBtnSelection());
			Reporter.log("Step 5: Verified One-Way Selected");

			// home.clickonFlights().verifyOneWayRadioBtnSelection()
			result = "pass";
		} catch (Throwable t) {
			errorMessage = t.getMessage();
			BasePage.saveScreenshot(this.driver);
			throw t;
		} finally {
			Reporter.log(result);
			if (errorMessage != null)
				Reporter.log(errorMessage);
			BrowserFactory.KillBrowser();
			Reporter.log("6. Browser is closed");
		}
	}
}
