package pages.android;

import org.openqa.selenium.By;
import pages.base.StationListBase;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class StationListAndroid extends StationListBase {

    //UiLib:VerticalListContainer
    private final String stationListId = "VerticalListContainer";
    private final String stationList = "com.bmwgroup.apinext.mediaapp:id/VerticalListContainer";
    private final String station = "com.bmwgroup.apinext.mediaapp:id/ListImageComponent ImageRightIcon";

    @Override
    public By getStationList() {
        return By.id(stationList);
    }

    @Override
    public By getStation() {
        return By.xpath(station);
    }

}
