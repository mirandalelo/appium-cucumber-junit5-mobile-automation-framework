package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import pages.android.SettingsAndroid;
import pages.base.SettingsBase;

import java.util.List;

public class SettingsPage extends HomePage {

    public SettingsBase settings;

    public SettingsPage(AppiumDriver driver) {
        super(driver);
        settings = new SettingsAndroid();
    }

    public void openSettings() {

        click(settings.getSettingsButton());

    }

    public void disableFullScreenSwitch() {

        if (isFullScreenSwitchEnabled()) {  click(settings.getSettingsFullScreenSwitch()); }

    }

    public boolean isFullScreenSwitchEnabled() {

        WebElement fullScreenSwitch = super.getElement(settings.getSettingsFullScreenSwitch());
        return fullScreenSwitch.findElements(By.className("android.view.View")).get(1).getAttribute("checked").equals("true");

    }

    public void closeSettings() {

        click(settings.getRadioSettingsCloseButton());

    }

}
