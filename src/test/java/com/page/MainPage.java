package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public MainPage open() {
		getDriver().get("https://en.wikipedia.org/wiki/Main_Page");
		return this;
	}
	
	public ArticlePage searchCountry(String country) {
		WebElement tfSearch = getDriver().findElement(By.name("search"));
		tfSearch.sendKeys(country);
		
		WebElement btnSearch = getDriver().findElement(By.xpath("//*[@id='searchform']//button"));
		btnSearch.click();
		
		return new ArticlePage();
	}

}
