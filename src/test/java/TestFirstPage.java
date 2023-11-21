
import dev.failsafe.internal.util.Assert;
import org.example.FirstPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.awt.*;
import java.time.Duration;


public class TestFirstPage {

    static WebDriver driver;
    FirstPage firstPage;
    WebDriverWait wait;


    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\suli\\chromedriver\\chromedriver-win64");
        // driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }
    @BeforeEach
    public void setup() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://web.archive.org/web/20180926132852/http://www.seleniumeasy.com/test/basic-first-form-demo.html");
        firstPage = new FirstPage(driver);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd","kiskutya","haha", "#ä&đd", "1265asl", "  $a¤ askl"})
    public void test_enter_message(String input){
        firstPage.enterMessage(input);
        firstPage.clickShowMessage();
        Assert.isTrue(input.equals(firstPage.getUserMessage()),"Messages do not match.");
    }


    @ParameterizedTest
    @CsvSource({"1,2,3", "4,5,9", "65,56,121", "-2,-12,-14", "-4,5,1"})
    public void test_calculator(String inputA, String inputB, String expected){
        firstPage.enterValueA(inputA);
        firstPage.enterValueB(inputB);
        firstPage.clickGetTotal();
        Assert.isTrue(expected.equals(firstPage.getTotalValue()), "Calculator is not correct");
    }

}
