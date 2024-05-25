package com.flipkart.locators;

public interface SearchPageObjects {

    String itemPrice = ".//div[starts-with(text(),\"₹\") and @class=\"Nx9bqj\"]";
    String itemName = ".//a[contains(@class,\"WKTcLC\")]";
    String itemDiscountPercentage = ".//div[@class=\"UkUFwK\"]/span";
    String itemBrand = ".//div[@class=\"syl9yP\"]";
    String itemsList = "//div[@class=\"hCKiGj\"]";
}
