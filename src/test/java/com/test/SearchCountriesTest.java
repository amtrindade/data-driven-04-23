package com.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.page.ArticlePage;
import com.page.MainPage;

public class SearchCountriesTest extends BaseTest{
	
	@Test
	public void testSearchCountry() {
		MainPage main = new MainPage();
		main.open();
		ArticlePage article = main.searchCountry("Argentina");
		
		assertEquals(article.getTextTitle(), "Argentina");
	}


	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}
}
