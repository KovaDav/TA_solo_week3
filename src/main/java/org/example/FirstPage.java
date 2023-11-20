package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPage {
    WebDriver driver;
    By messageInput = By.id("user-message");
    By aInput = By.id("sum1");
    By bInput = By.id("sum2");
    By showMessageButton = By.xpath("//*[@id=\"get-input\"]/button");
    By getTotalButton = By.xpath("//*[@id=\"gettotal\"]/button");
    By userMessage = By.id("display");
    By totalValue = By.id("displayvalue");

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
    }

    public void enterValueA(String value){
        driver.findElement(aInput).sendKeys(value);
    }

    public void enterValueB(String value){
        driver.findElement(bInput).sendKeys(value);
    }

    public void clickShowMessage(){
        driver.findElement(showMessageButton).click();
    }

    public void clickGetTotal(){
        driver.findElement(getTotalButton).click();
    }

    public String getUserMessage(){
        return driver.findElement(userMessage).getText();
    }

    public String getTotalValue(){
        return driver.findElement(totalValue).getText();
    }
}