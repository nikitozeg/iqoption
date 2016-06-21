package my.company.tests;

import my.company.steps.LandingPage;
import my.company.steps.TestSettings;
import my.company.steps.TradeRoom;
import org.junit.Test;
import org.sikuli.script.Key;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * @author Nikita Ivanov tazg@ya.ru
 */

@Title("Suite contain onle positive cases")

public class RegistrationFormTest extends TestSettings {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Call and put are closed with valid message. Default currency is EUR/USD")
    @Test
    public void lookAndFeelTest() throws Exception {

        LandingPage lp = new LandingPage(driver);
        TradeRoom tradeRoom = lp.gotoTradeRoom(valid_email, valid_password).userClickTrade();  // Go to TradeRoom

        assert (tradeRoom.waitForImage(eurUsd));                                               // Check EUR/USD is setted by default

        screen.click(price);
        screen.type(oneHundredUSD);
        screen.click(call);
        assert (tradeRoom.waitForImage(callConfirmed));                                        // Check that call is confirmed with valid message

        screen.click(priceNew);
        screen.type(Key.BACKSPACE+Key.BACKSPACE+Key.BACKSPACE);                                // Removing old price
        screen.type("99");
        screen.click(put);
        assert (tradeRoom.waitForImage(putConfirmed));                                         // Check that put is confirmed with valid message

        assert (tradeRoom.isImagesExists(                                                      // Waiting for closing with valid message
                tradeClosedRed,
                tradeClosedBlack,
                tradeClosedGreen
        ));
    }
}

