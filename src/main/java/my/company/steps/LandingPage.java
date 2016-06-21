package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 22.06.16
 */

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By tradeLocator = By.cssSelector(".js-btn-trade");
    By signInFirstLocator = By.cssSelector(".js-login-btn");
    By emailInputLocator = By.cssSelector("#loginFrm input[name='email']");
    By passwordInputLocator = By.cssSelector("#loginFrm input[name='password']");
    By signInButtonLocator = By.cssSelector("#loginFrm button[type='submit']");

    @Step
    public void userClickFirstSignIn() {
        driver.findElement(signInFirstLocator).click();
    }

    @Step
    public void userTypeEmailInForm(String email) {
        driver.findElement(emailInputLocator).sendKeys(email);
    }


    @Step
    public void userTypePasswordInForm(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    @Step
    public void userClickSecondSignIn() {
        driver.findElement(signInButtonLocator).click();
    }

    @Step
    public TradeRoom userClickTrade() {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(tradeLocator));
        driver.findElement(tradeLocator).click();
        return new TradeRoom(driver);
    }

    @Step
    public LandingPage gotoTradeRoom(String email, String password) throws InterruptedException {
        userClickFirstSignIn();
        userTypeEmailInForm(email);
        userTypePasswordInForm(password);
        userClickSecondSignIn();
        return this;
    }


}
