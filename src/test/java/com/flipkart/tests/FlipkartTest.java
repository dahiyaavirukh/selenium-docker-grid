package com.flipkart.tests;

import com.flipkart.pages.HomePage;
import com.flipkart.pages.SearchPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartTest extends BaseRemoteTest {

    HomePage homepage;
    SearchPage searchPage;
    @BeforeClass
    public  void setUp() {
        homepage = new HomePage(driver);
        searchPage  = new SearchPage(driver);
    }

    @Test
    public void testFlipkartHomepage() throws InterruptedException {
            homepage.goToFlipKart();
            homepage.clickOnSearchBoxAndSearch("Nike Shoes");
            searchPage.printSearchedItemsTable();
            Thread.sleep(10000);
        }
}
