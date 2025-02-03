package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.SearchContext;
import pages.android.StationListAndroid;
import pages.base.StationListBase;

@SuppressWarnings("unused")
public class StationListPage extends HomePage {

    public StationListBase stationList;

    public StationListPage(AppiumDriver driver) {
        super(driver);
        stationList = new StationListAndroid();
    }

    public boolean isStationListVisible() {

        return isVisible(stationList.getStationList());
    }

    public boolean isStationListLoaded() {
        return !stationList.getStationList().findElements((SearchContext) stationList.getStation()).isEmpty();
    }

}
