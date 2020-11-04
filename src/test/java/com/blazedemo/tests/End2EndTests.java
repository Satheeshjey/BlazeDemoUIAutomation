package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.TestBase;
import com.blazedemo.pageObjects.FlightsListPage;
import com.blazedemo.pageObjects.LandingPage;
import com.blazedemo.pageObjects.PassengerDetailsPage;
import com.blazedemo.pageObjects.ReservationConfirmationPage;

public class End2EndTests extends TestBase {
	LandingPage landingPage;
	FlightsListPage flightListingPage;
	PassengerDetailsPage passengerDetailsPage;
	ReservationConfirmationPage reservationConfirmationPage;
	
	public End2EndTests() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		TestBase.initialization();
		landingPage = new LandingPage();
	}
	
	@Test(priority=0)
	public void testSuccessFullBooking(){
		landingPage.selectFromCity(prop.getProperty("startCity"));
		landingPage.selectToCity(prop.getProperty("toCity"));
		flightListingPage = landingPage.clickFindFlightsButton();
		passengerDetailsPage = flightListingPage.selectFlight();
		//testing the booking without passing any details
		reservationConfirmationPage = passengerDetailsPage.clickPurchaseFlightButton();
		Assert.assertNotNull(reservationConfirmationPage.getPageTitle());
		Assert.assertEquals(reservationConfirmationPage.getPageTitle().getText(), prop.getProperty("reservationConfirmationPageHeader") );
	}
	
	@AfterMethod
	public void cleanUp(){
		driver.quit();
	}

}
