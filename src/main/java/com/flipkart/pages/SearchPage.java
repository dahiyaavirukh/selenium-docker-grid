package com.flipkart.pages;

import com.flipkart.generic.Generic;
import com.flipkart.locators.SearchPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage implements SearchPageObjects {
    public WebDriver driver;
    public Generic generic;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.generic = new Generic(driver);
    }

    public void printSearchedItemsTable() {
        List<WebElement> searchedItems = generic.findElements(itemsList);
        System.out.println("Total number of items: " + searchedItems.size());

        // Print table header
        System.out.printf("%-20s | %-30s | %-10s | %-10s%n", "Brand", "Name", "Price", "Discount%");
        System.out.println("---------------------------------------------------------------------------");

        // Print each item in table format
        for (WebElement item : searchedItems) {
            String brand = item.findElement(By.xpath(itemBrand)).getText();
            String name = item.findElement(By.xpath(itemName)).getText();
            String price = item.findElement(By.xpath(itemPrice)).getText();
            String discount = item.findElement(By.xpath(itemDiscountPercentage)).getText();
            System.out.printf("%-20s | %-30s | %-10s | %-10s%n", brand, name, price, discount);
        }
    }
}
