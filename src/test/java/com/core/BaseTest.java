package com.core;

import static com.core.DriverFactory.getDriver;
import static com.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseTest {
	
	@AfterMethod
	public void tear(ITestResult testInfo) throws IOException {
		File screen = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("target"+ File.separator + testInfo.getName()+ new Date() +".png"));			
	}
	
	@AfterTest
	public void tearDown() throws IOException {
		killDriver();
	}
}
