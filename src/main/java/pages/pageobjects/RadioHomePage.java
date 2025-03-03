package pages.pageobjects;

import data.entity.MediaSession;
import data.type.MediaSessionAppTypes;
import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.android.SettingsAndroid;
import pages.android.StationListAndroid;
import pages.base.SettingsBase;
import pages.base.StationListBase;
import utils.CommonUtils;

import java.time.Duration;
import java.util.Random;

import static io.github.the_sdet.cucumber.CucumberUtils.logToReport;

public class RadioHomePage extends HomePage {

    public SettingsBase settings;
    public StationListBase stationList;
    @Getter
    public StationListPage stationListPage;

    public RadioHomePage(AppiumDriver driver) {

        super(driver);
        settings = new SettingsAndroid();
        stationList = new StationListAndroid();
        stationListPage = new StationListPage(driver);

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

        if (station.equals("any")) {

            stationListPage.loadStationNames();
            Random random = new Random();

            int indexRandomStation = random.nextInt(stationListPage.getStationNames().size()-1);
            while (indexRandomStation == stationListPage.getCurrentStationIndex()) {

                indexRandomStation = random.nextInt(stationListPage.getStationNames().size()-1);

            }

            station = stationListPage.getStationNames().get(indexRandomStation);
            stationListPage.setCurrentStation(station);

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

        String miniStationName = miniPlayerHeader.getText().trim();
        logToReport("Station Playing on Mini: "+miniStationName+" x "+station);

        if (miniStationName.length() < station.length()) {

            station = station.substring(0,miniStationName.length());

        }


        return miniPlayerHeader.getText().trim().equals(station);

    }

    public String getMediaSourceName() {

        String path = "//android.view.View[@resource-id='media_source_header_component']//android.widget.TextView[starts-with(@resource-id,'TextAtom:dynamic_string')]";
        WebElement mediaSourceName = waitAndFindElement(By.xpath(path));

        return mediaSourceName.getText();

    }

    public MediaSession getMediaSession() {

        Integer userId = CommonUtils.getAndroidCurrentUser(driver);
        return CommonUtils.getAndroidMediaSession(driver, userId, MediaSessionAppTypes.TMS);

    }

}
