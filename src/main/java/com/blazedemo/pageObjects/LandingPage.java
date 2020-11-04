package com.blazedemo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.blazedemo.base.TestBase;


public class LandingPage extends TestBase{
	public LandingPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Welcome to the Simple Travel Agency!']") WebElement landingPageTitle;
	@FindBy(xpath="//select[@name='fromPort']") WebElement fromCity;
	@FindBy(xpath="//select[@name='toPort']") WebElement toCity;
	@FindBy(xpath="//input[@value='Find Flights']") WebElement findFlightsButton;
	@FindBy(linkText="Travel The World") WebElement travelTheWorldLink;
	@FindBy(linkText="home") WebElement homeLink;
	
	public void selectFromCity(String startCity){
		Select fromCityDropDown = new Select(fromCity);
		fromCityDropDown.selectByValue(startCity);
	}
	
	public void selectToCity(String endCity){
		Select toCityDropDown = new Select(toCity);
		toCityDropDown.selectByValue(endCity);
	}
	
	public WebElement getLandingPageTitle(){
		return this.landingPageTitle;
	}
	
	public String getDefaultStartCity(){
		return new Select(fromCity).getFirstSelectedOption().getText();
	}
	
	public String getDefaultToCity(){
		return new Select(toCity).getFirstSelectedOption().getText();
	}
	
	public WebElement getTravelTheWorldLinkElement(){
		return this.travelTheWorldLink;
	}
	public WebElement getHomeLinkElement(){
		return this.homeLink;
	}
	
	public WebElement getFindFlightsButton(){
		return this.findFlightsButton;
	}
	
	public FlightsListPage clickFindFlightsButton(){
		findFlightsButton.click();
		return new FlightsListPage();
	}
}
