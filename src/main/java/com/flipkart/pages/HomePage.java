package com.flipkart.pages;

import com.flipkart.generic.Generic;
import com.flipkart.locators.HomePageObjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage implements HomePageObjects {

    public WebDriver driver;
    public Generic generic;

    public HomePage(WebDriver driver) {
          this.driver = driver;
          this.generic = new Generic(driver);
    }

    public void goToGrocerySection(){
        generic.clickElement(grocerySection);
    }

    public void goToElectronicsSection(){
        generic.clickElement(electronicsSection);
    }

    public void goToMobileSection(){
        generic.clickElement(mobileSection);
    }

    public void goToFashionSection(){
        generic.clickElement(fashionSection);
    }

    public void goToHomeAndFurnitureSection(){
        generic.clickElement(homeAndFurnitureSection);
    }

    public void goToAppliancesSection(){
        generic.clickElement(appliancesSection);
    }

    public void goToTravelSection(){
        generic.clickElement(travelSection);
    }

    public void clickLoginButton(){
        generic.clickElement(loginButton);
    }

    public void clickOnSearchBoxAndSearch(String value){
        generic.clickElement(searchBox);
        generic.sendKeysElement(searchBox,value);
        generic.sendKeysElement(searchBox, Keys.ENTER);
    }


    public void goToFlipKart() {
        driver.get("https://www.flipkart.com/");
    }
}
