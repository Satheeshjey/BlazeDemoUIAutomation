package com.blazedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.TestBase;

public class PassengerDetailsPage extends TestBase{
	
	public PassengerDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="inputName") WebElement name;
	@FindBy(id="address") WebElement address;
	@FindBy(id="city") WebElement city;
	@FindBy(id="state") WebElement state;
	@FindBy(id="zipCode") WebElement zipCode;
	@FindBy(id="cardType") WebElement cardType;
	@FindBy(id="creditCardNumber") WebElement creditCardNumber;
	@FindBy(id="creditCardMonth") WebElement creditCardMonth;
	@FindBy(id="creditCardYear") WebElement creditCardYear;
	@FindBy(id="nameOnCard") WebElement nameOnCard;
	@FindBy(xpath="//input[@value='Purchase Flight']") WebElement purchaseFlightButton;
	
	public ReservationConfirmationPage clickPurchaseFlightButton(){
		purchaseFlightButton.click();
		return new ReservationConfirmationPage();
	}

}
