package com.test;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.core.SpreadsheetData;
import com.page.ArticlePage;
import com.page.MainPage;

public class SearchCountriesTest extends BaseTest{
	
	@Test(dataProvider = "countriesListExcel")
	public void testSearchCountry(String searchCountry, String expecteCountry) {
		MainPage main = new MainPage();
		main.open();
		ArticlePage article = main.searchCountry(searchCountry);	
		assertEquals(article.getTextTitle(), expecteCountry);
	}


	@DataProvider(name = "countriesListExcel")
	public Object[][] dataProvider() {
		Object[][] testData = SpreadsheetData
				.readExcelData(
						"Paises", 
						"src" + File.separator + "test" +File.separator + "resources" + File.separator + "paises.xls", 
						"Dados");
		return testData;
	}
	
	@DataProvider(name = "countriesList")
	public Object[][] dataProviderCountries() {
		return new Object[][] {
			{"India", "India" },
			{"Brazil", "Brazil" },
			{"Argentina", "Argentina"},
			{"Italy", "Italy"},
			{"Venezuela", "Venezuela"},
			{"United States", "United States"}
		};
	}
	
	@Test(dataProvider = "countriesList")
	public void testSearchCountryList(String searchCountry, String expecteCountry) {
		MainPage main = new MainPage();
		main.open();
		ArticlePage article = main.searchCountry(searchCountry);	
		assertEquals(article.getTextTitle(), expecteCountry);
	}
}
