package com.flipkart.pages;

import com.flipkart.generic.Generic;
import com.flipkart.locators.SearchPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        // Check if the file exists and is not empty
        boolean fileExistsAndNotEmpty = false;
        File file = new File("searched_items.csv");
        if (file.exists() && file.length() != 0) {
            fileExistsAndNotEmpty = true;
        }


        // Write to CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("searched_items.csv", true))) {
            // If the file doesn't exist yet or is empty, write the table header
            if (!fileExistsAndNotEmpty) {
                writer.write("Brand,Name,Price,Discount%");
                writer.newLine();
            }

            // Print each item in table format
            for (WebElement item : searchedItems) {
                String brand = "N/A";
                String name = "N/A";
                String price = "N/A";
                String discount = "N/A";

                try {
                    brand = item.findElement(By.xpath(itemBrand)).getText();
                    name = item.findElement(By.xpath(itemName)).getText();
                    price = item.findElement(By.xpath(itemPrice)).getText();
                    discount = item.findElement(By.xpath(itemDiscountPercentage)).getText();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                price = price.replaceAll(",","");
                System.out.printf("%-20s | %-30s | %-10s | %-10s%n", brand, name, price, discount);

                // Write item to CSV file
                writer.write(String.format("%s,%s,%s,%s", brand, name, price, discount));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public void goToNextPage() {
        generic.scrollToElement(nextPageButton);
        generic.doMouseHover(nextPageButton);
        generic.clickElement(nextPageButton);
    }


    public void getTenPageData() throws InterruptedException {
        for(int i=0;i<10;i++){
            printSearchedItemsTable();
            goToNextPage();
            Thread.sleep(2000);
        }
    }


}
