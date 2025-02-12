package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class MiniPlayerPage extends HomePage {

    /**
     * Constructor to initialize AppiumUtils.
     *
     * @param driver The Appium Driver (AndroidDriver/IOSDriver) instance to use.
     * @author Leandro Miranda
     */
    public MiniPlayerPage(AppiumDriver driver) {
        super(driver);
    }

    public void pressRightSkipButton() {

        pressRightSkipButton(1);
        waitFor(Duration.ofSeconds(2));

    }

    public void pressRightSkipButton(int times) {

        if (times<1) {
            throw new IllegalArgumentException("Number of times needs to be greater than 0");
        }

        for(int i=0; i<times; i++) {

            String xpath = "//android.view.View[@resource-id='miniplayer_control']//android.view.View[@resource-id='miniplayer_right_control']";
            click(By.xpath(xpath));
            waitFor(Duration.ofMillis(750)); // 1000 = 1 second

        }

    }

    public void pressLeftSkipButton() {

        pressLeftSkipButton(1);
        waitFor(Duration.ofSeconds(2));

    }

    public void pressLeftSkipButton(int times) {

        if (times<1) {
            throw new IllegalArgumentException("Number of times needs to be greater than 0");
        }

        for(int i=0; i<times; i++) {

            String xpath = "//android.view.View[@resource-id='miniplayer_control']//android.view.View[@resource-id='miniplayer_left_control']";
            click(By.xpath(xpath));
            waitFor(Duration.ofMillis(750)); // 1000 = 1 second

        }

    }

    public String getStationName() {

        String xpath = "//android.view.View[@resource-id='miniplayer_control']//android.view.View[@resource-id='TEST_TAG_HEADER']//android.widget.TextView";
        return getElementTextContent(By.xpath(xpath));

    }

}
