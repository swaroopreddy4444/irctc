package com.javalaya.irctc.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenshotUtil  {

	public static String fileName;
	
	public static void captureScreenshot(WebDriver driver) {

		Date d = new Date();
		
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\reports\\" + fileName));
			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void captureElementScreenshot(WebElement element) {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		File screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\screenshot\\" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
