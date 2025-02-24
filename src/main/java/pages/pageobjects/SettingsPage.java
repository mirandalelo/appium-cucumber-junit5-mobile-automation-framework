package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import pages.android.SettingsAndroid;
import pages.base.SettingsBase;
import utils.CommonUtils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static io.github.the_sdet.cucumber.CucumberUtils.logToReport;

public class SettingsPage extends HomePage {

    public SettingsBase settings;

    public SettingsPage(AppiumDriver driver) {
        super(driver);
        settings = new SettingsAndroid();
    }

    public void openSettings() {

        if (waitAndCheckIsClickable(settings.getSettingsButton(), Duration.ofSeconds(2))) {
            click(settings.getSettingsButton());
            waitFor(Duration.ofSeconds(1));
        }

    }

    public void disableFullScreenSwitch() {

        if (isFullScreenSwitchEnabled()) {

            CommonUtils.tapElement(driver,settings.getSettingsFullScreenSwitch());
            waitFor(Duration.ofSeconds(1));

        }

    }

    public boolean isFullScreenSwitchEnabled() {

        boolean enabled = false;

        if (waitAndCheckIsVisible(settings.getSettingsFullScreenSwitchGlowEffect(), Duration.ofSeconds(2))) {
            enabled = true;
        }

        logToReport("Full Screen mode is: "+enabled);

        return enabled;
    }

    public void closeSettings() {

        pressBackKey();
        waitFor(Duration.ofSeconds(2));

    }

}
