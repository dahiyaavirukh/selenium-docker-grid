package com.flipkart.generic;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Generic {
    public WebDriver driver;
    public WebDriverWait wait;

    public Generic(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findElement(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> findElements(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElements(By.xpath(xpath));
    }

    public Boolean isElementDisplayed(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public Boolean isElementDisplayed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void scrollToElement(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpath)));
    }

    public void clickElement(String xpath){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeysElement(String xpath,String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public void sendKeysElement(WebElement element,String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public void sendKeysElement(String xpath, Keys value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public String getTextElement(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String getTextElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public String getAttributeElement(String xpath,String attribute){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath)).getAttribute(attribute);
    }

    public String getAttributeElement(WebElement element,String attribute){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attribute);
    }

    public void switchToFrame(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
    }

    public void switchToFrame(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void switchToWindow(String windowName){
        driver.switchTo().window(windowName);
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void switchToActiveElement(){
        driver.switchTo().activeElement();
    }

    public void doMouseHover(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void doMouseHover(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(xpath))).perform();
    }

    public void doMouseHoverAndSelectFromList(String xpath,String listElementsXpath,String valueToSelect){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(xpath))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listElementsXpath)));
        driver.findElements(By.xpath(listElementsXpath)).stream().filter(e->e.getText().equals(valueToSelect)).findFirst().get().click();
    }
}
