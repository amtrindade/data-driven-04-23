package com.core;

import static com.core.DriverFactory.killDriver;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class BaseTest {
	
	@AfterMethod
	public void tearDown() throws IOException {
//		File screen = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screen , 
//				new File("target"+ File.separator + testInfo.getDisplayName() +".png"));	
		killDriver();
	}
}
