package com.blazedemo.tests;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.TestBase;
import com.blazedemo.pageObjects.LandingPage;

public class LandingPageTest extends TestBase{

	LandingPage landingPage;

	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		TestBase.initialization();
		landingPage = new LandingPage();
	}

	@Test
	public void testLandingPageIsLoadedSuccessfully(){
		Assert.assertNotNull(landingPage.getLandingPageTitle(), "Landing Page Title Element is not found.");
	}

	@Test
	public void testDefaultSelectionOfStartCity(){
		Assert.assertTrue(landingPage.getDefaultStartCity().equals(prop.get("defaultStartCity")),"Default Selected city is not Paris");
	}
	@Test
	public void testDefaultSelectionOfToCity(){
		Assert.assertTrue(landingPage.getDefaultToCity().equals(prop.get("defaultToCity")),"Default Selected city is not Buenos Aires");
	}
	@Test
	public void testNavMenuLinks(){
		Assert.assertNotNull(landingPage.getTravelTheWorldLinkElement(), "Nav Menu Does not contain Travel the world Link");
		Assert.assertNotNull(landingPage.getHomeLinkElement(), "Nav Menu Does not Home Link");
	}

	@AfterMethod
	public void cleanUp(){
		driver.quit();
	}

}
