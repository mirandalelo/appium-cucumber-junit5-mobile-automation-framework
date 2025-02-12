package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.android.SettingsAndroid;
import pages.android.StationListAndroid;
import pages.base.SettingsBase;
import pages.base.StationListBase;

import java.time.Duration;

import static io.github.the_sdet.cucumber.CucumberUtils.logToReport;

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

        if (waitAndCheckIsVisible(settings.getSettingsFullScreenSwitch(), Duration.ofSeconds(5))) {
            waitFor(Duration.ofSeconds(1));
        }

    }

    public boolean isMiniPlayerIsVisible() {

        String path = "//android.view.View[@resource-id=\"TEST_TAG_COMPONENT\"]";
        WebElement miniPlayer = getElement(By.xpath(path));

        return (miniPlayer.isDisplayed());

    }

    public void selectStation(String station) {

        if (station == null || station.isEmpty()) {
            throw new IllegalArgumentException("Station name cannot be null or empty");
        }

        String xpath = "//android.view.View[normalize-space(@resource-id)='ListImageComponent ImageRightIcon' and .//android.widget.TextView[@text='"+station+"']]";

        WebElement selectedStation = waitAndFindElement(By.xpath(xpath));

        selectedStation.click();
        waitFor(Duration.ofSeconds(2));

    }

    public boolean isStationNameDisplayedInMiniPlayer(String station) {

        if (station == null || station.isEmpty()) {
            throw new IllegalArgumentException("Station name cannot be null or empty");
        }

        String path = "//android.view.View[@resource-id='miniplayer_control']//android.view.View[@resource-id='TEST_TAG_HEADER']//android.widget.TextView";
        WebElement miniPlayerHeader = waitAndFindElement(By.xpath(path));

        logToReport("Station Playing on Mini: "+station);
        return station.equals(miniPlayerHeader.getText());

    }
}
