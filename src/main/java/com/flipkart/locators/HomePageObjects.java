package com.flipkart.locators;

public interface HomePageObjects {
    String searchBox = "//input[@placeholder='Search for Products, Brands and More']";
    String loginButton = "//span[normalize-space()='Login']";
    String cartButton = "//a[normalize-space()='Cart']";
    String becomeASellerButton = "//a[contains(text(),'Become a Seller')]";
    String grocerySection = "//a[@aria-label='Grocery']";
    String mobileSection = "//a[@aria-label='Mobiles']//div//div[@class='YBLJE4']";
    String fashionSection = "//div[@class='_1wE2Px']";
    String electronicsSection = "//div[@class='_1wE2Px']";
    String homeAndFurnitureSection = "//div[@class='_1wE2Px']";
    String appliancesSection = "//div[@class='_1wE2Px']";
    String travelSection = "//a[@aria-label='Travel']";
}
