package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestFirstPage {

    WebDriver driver;
    FirstPage firstPage;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\suli\\chromedriver\\chromedriver-win64");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-first-form-demo.html");

    }

    @Test
    public void test_enter_message(){
        firstPage = new FirstPage(driver);
        String message = "asd";
        firstPage.enterMessage(message);
        firstPage.clickShowMessage();

        Assert.isTrue(firstPage.getUserMessage().equals(message),"Messages do not match.");
    }


}
