package pages.pageobjects;

import com.aventstack.extentreports.util.Assert;
import io.appium.java_client.AppiumDriver;
import pages.android.SettingsAndroid;
import pages.android.StationListAndroid;
import pages.base.SettingsBase;
import pages.base.StationListBase;

import java.time.Duration;

public class RadioHomePage extends HomePage {

    public SettingsBase settings;
    public StationListBase stationList;

    public RadioHomePage(AppiumDriver driver) {

        super(driver);
        settings = new SettingsAndroid();
        stationList = new StationListAndroid();

    }

    public void checkIfUIComponentsAreVisible() {

        if (waitAndCheckIsVisible(settings.getSettingsButton(), Duration.ofSeconds(5))) {
            waitFor(Duration.ofSeconds(1));
        }

    }

}
