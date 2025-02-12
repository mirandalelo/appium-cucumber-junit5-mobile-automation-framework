package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import pages.android.SettingsAndroid;
import pages.base.SettingsBase;

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
            if (waitAndCheckIsClickable(settings.getSettingsFullScreenSwitch(),Duration.ofSeconds(2))) {

                click(settings.getSettingsFullScreenSwitch());
                waitFor(Duration.ofSeconds(1));

            }
        }

    }

    public boolean isFullScreenSwitchEnabled() {

        boolean enabled = false;
        String xpath = "//android.view.View[@resource-id=\"InternalEntry-Switch automatically to fullscreen mode\"]/android.view.View[3]";

        if (waitAndCheckIsVisible(By.xpath(xpath), Duration.ofSeconds(2))) {
            WebElement switchButton = super.getElement(By.xpath(xpath));
            enabled = switchButton.getAttribute("checked").equals("true");
        }

        return enabled;
    }

    public void closeSettings() {

        if (waitAndCheckIsClickable(settings.getRadioSettingsCloseButton(),Duration.ofSeconds(3))) {
            click(settings.getRadioSettingsCloseButton());
        } else {
            pressBackKey();
        }

        waitFor(Duration.ofSeconds(2));

    }

}
