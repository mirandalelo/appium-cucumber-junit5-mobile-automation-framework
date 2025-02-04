package pages.android;

import org.openqa.selenium.By;
import pages.base.StationListBase;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class StationListAndroid extends StationListBase {

    //UiLib:VerticalListContainer
    private final String stationListId = "UiLib:VerticalListContainer";
    private final String stationList = "//android.view.View[ends-with(@resource-id,'VerticalListContainer')]";
    private final String station = "com.bmwgroup.apinext.mediaapp:id/ListImageComponent ImageRightIcon";

    @Override
    public By getStationList() {
        return By.xpath(stationList);
    }

    @Override
    public By getStation() {
        return By.xpath(station);
    }

}
