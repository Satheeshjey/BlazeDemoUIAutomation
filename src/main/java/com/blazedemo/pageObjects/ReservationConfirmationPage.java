package com.blazedemo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.TestBase;

public class ReservationConfirmationPage extends TestBase {
	
	@FindBy(tagName="h1") WebElement pageTitle;
	@FindBy(xpath="//td[text()='Id']/following-sibling::td") WebElement id;

	public ReservationConfirmationPage(){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPageTitle(){
		return this.pageTitle;
	}
	
	public String getBookingId(){
		return this.id.getText();
	}

}
