package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.android.StationListAndroid;
import pages.base.StationListBase;

import java.util.List;

@SuppressWarnings("unused")
public class StationListPage extends HomePage {

    public StationListBase stationList;

    public StationListPage(AppiumDriver driver) {
        super(driver);
        stationList = new StationListAndroid();
    }

    public boolean isStationListVisible() {

        List<WebElement> allStations =  super.getElement(stationList.getStationList()).findElements(By.id("ImageFrameAtom"));

        if (!allStations.isEmpty()) {
            return allStations.get(0).isDisplayed();
        }

        return false;

    }

    public boolean isStationListLoaded() {

        List<WebElement> allStations = super.getElement(stationList.getStationList()).findElements(By.id("ImageFrameAtom"));

        for (WebElement station:allStations) {

            if(!station.isDisplayed()) {

                return false;

            }
        }

        return true;
    }

}
