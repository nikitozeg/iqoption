package my.company.steps;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Screen;

import java.util.concurrent.TimeUnit;


/**
 * @author Nikita Ivanov tazg@ya.ru
 */

public class TestSettings {

    protected Screen screen;
    protected WebDriver driver;

    protected String valid_email;
    protected String valid_password;
    protected String eurUsd="resources/EURusd.png";
    protected String price="resources/price.png";
    protected String priceNew="resources/price100.png";
    protected String oneHundredUSD="00";
    protected String call="resources/call.png";
    protected String put="resources/put.png";
    protected String callConfirmed="resources/100usdGreen.png";
    protected String putConfirmed="resources/99usdRed.png";
    protected String tradeClosedRed="resources/tradeClosedRed.png";
    protected String tradeClosedBlack="resources/tradeClosedBlack.png";
    protected String tradeClosedGreen="resources/tradeClosedGreen.png";

    String user;
    String hostname;
    String domain;


    @Before //will be executed before every test
    public void setUp() {

        valid_password = "726210";
        user = "tazg"; //dirty hack (can not delete test data)
        hostname = "ya";
        domain = "ru";
        valid_email = user + "@" + hostname + "." + domain;
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        screen=new Screen();
        driver = new ChromeDriver(); //chrome will started for visual-control, should be change for headless
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //set implicit wait
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://iqoption.com/ru/"); //open page

    }

    @After //will be executed after every test
    public void tearDown() {
        driver.quit(); //close browser and clear session
    }
}

