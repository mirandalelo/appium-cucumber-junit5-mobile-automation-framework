package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import pages.android.SourcePageAndroid;
import pages.base.SourcePageBase;
import utils.CommonUtils;
import utils.ScreenCoordinate;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SourcePage extends HomePage {

    public SourcePageBase sourcePageBase;

    /**
     * Constructor to initialize AppiumUtils.
     *
     * @param driver The Appium Driver (AndroidDriver/IOSDriver) instance to use.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public SourcePage(AppiumDriver driver) {
        super(driver);
        sourcePageBase = new SourcePageAndroid();
    }

    public void openMediaSource() {

        if (waitAndCheckIsClickable(sourcePageBase.getSourceButton(), Duration.ofSeconds(3))) {

            click(sourcePageBase.getSourceButton());
            waitFor(Duration.ofSeconds(1));

        } else {

            ScreenCoordinate sourceButtonCoordinates = CommonUtils.loadScreenCoordinates("source.button");
            CommonUtils.tap(driver, sourceButtonCoordinates.getX(), sourceButtonCoordinates.getY());
           // CommonUtils.tap(driver,600,237);

        }

    }

    public void clickOnRadio() {

        if(waitAndCheckIsClickable(sourcePageBase.getRadioButton(), Duration.ofSeconds(5))) {
            click(sourcePageBase.getRadioButton());
        }

    }

}
