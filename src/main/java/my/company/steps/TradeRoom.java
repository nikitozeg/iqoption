package my.company.steps;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 */

public class TradeRoom {

    private WebDriver driver;
    private Screen screen;
    private int SECOND=1000;

    public TradeRoom(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public boolean waitForImage(String imageName) throws FindFailed, InterruptedException {
        int i = 0;
        while (!(isImageExists(imageName))) {
            i++;
            if (i > 60) throw new FindFailed("Pattern not found");
            Thread.sleep(SECOND);
        }
        return true;
    }


    @Step
    public boolean isImagesExists(String imageName1, String imageName2, String imageName3) throws FindFailed, InterruptedException {
        int i = 0;
        while (!(isImageExists(imageName1) || (isImageExists(imageName2) || (isImageExists(imageName3))))) {
            Thread.sleep(SECOND);
            i++;
            if (i > 60) throw new FindFailed("Pattern not found");
        }
        return true;
    }


    @Step
    public boolean isImageExists(String imageName) throws FindFailed {
        screen = new Screen();
        Pattern pattern = new Pattern(imageName);
        Match match = screen.exists(pattern);

        if (match != null && match.getScore() > 0.9) {
            match.highlight(1);
            return true;
        } else {
            return false;
        }


    }
}

