package com.blazedemo.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.TestBase;


public class FlightsListPage extends TestBase {
	public FlightsListPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()=Flights from Paris to Buenos Aires: ']") WebElement flightsListPageTitle;
	
	public WebElement getFlightsPageTitle(){
		return this.flightsListPageTitle;
	}
	
	public List<WebElement> getListOfFlights(){
		return driver.findElements(By.xpath("//input[@value='Choose This Flight']"));
	}
	
	public List<WebElement> getListOfColumns(){
		return driver.findElements(By.xpath("//thead//th"));
	}
	
	public PassengerDetailsPage selectFlight(){
		driver.findElements(By.xpath("//input[@value='Choose This Flight']")).get(0).click();
		return new PassengerDetailsPage();
	}
}

