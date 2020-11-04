package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.TestBase;
import com.blazedemo.pageObjects.FlightsListPage;
import com.blazedemo.pageObjects.LandingPage;

public class FlightsListingPageTest extends TestBase{
	
	LandingPage landingPage;
	FlightsListPage flightsListingPage;
	
	public FlightsListingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		TestBase.initialization();
		landingPage = new LandingPage();
	}
	
	
	@Test
	public void testFlightsListTable(){
		flightsListingPage = landingPage.clickFindFlightsButton();
		Assert.assertEquals(Integer.parseInt(prop.getProperty("numberOfColumns")), flightsListingPage.getListOfColumns().size(),"There are columns missing");
		Assert.assertEquals(Integer.parseInt(prop.getProperty("numberOfFlights")), flightsListingPage.getListOfFlights().size(),"Number of flights are correct");
	}
	
	@AfterMethod
	public void cleanUp(){
		driver.quit();
	}
}
