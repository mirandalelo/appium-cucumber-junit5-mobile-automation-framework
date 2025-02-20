package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.android.StationListAndroid;
import pages.base.StationListBase;
import utils.CommonUtils;
import utils.ScreenCoordinate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static io.github.the_sdet.cucumber.CucumberUtils.logToReport;

@SuppressWarnings("unused")
public class StationListPage extends HomePage {

    public StationListBase stationList;
    public List<String> previousStationNames;
    @Getter
    public List<String> stationNames;
    public int currentStationIndex;

    public StationListPage(AppiumDriver driver) {
        super(driver);
        stationList = new StationListAndroid();
        currentStationIndex = 0;
        previousStationNames = new ArrayList<>();
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

    public void loadStationNames() {

        String xpath = "(//android.view.View[@resource-id=\"ListImageComponent ImageRightIcon\"]//android.widget.TextView)";
        List<WebElement> stations = driver.findElements(By.xpath(xpath));
        logToReport("Stations loaded: "+stations.size());

        stationNames = new ArrayList<>();
        for (WebElement station : stations) {

            stationNames.add(station.getText());
            //logToReport("Station "+i+": "+stations.get(i).getText());

        }
    }

    public boolean isItEndOfTheRadioList() {

        boolean endOfStationList = false;

        if (!previousStationNames.isEmpty()) {

            endOfStationList =  stationNames.get(stationNames.size()-1).equals(previousStationNames.get(previousStationNames.size()-1));
            logToReport("Last station from current list: "+stationNames.get(stationNames.size()-1));
            logToReport("Last station from previous list:"+previousStationNames.get(previousStationNames.size()-1));

        }

        previousStationNames = new ArrayList<>(stationNames);

        return endOfStationList;

    }

    public void setCurrentStation(String stationName) {

        logToReport("Checking stations: "+stationNames.size());

        for(int i=0; i<stationNames.size();i++) {
            if (stationNames.get(i).equals(stationName)) {

                currentStationIndex = i;
                break;

            }
        }
    }

    public String getStationName() {

        return stationNames.get(currentStationIndex);

    }

    public String getPreviousStationName() {

        currentStationIndex = currentStationIndex-1;
        return getStationName();

    }

    public String getNextStationName() {

        currentStationIndex = currentStationIndex+1;
        return getStationName();

    }

    public WebElement getSelectedStation() {

        //to be implemented
        return null;

    }

    public String getSelectedStationName() {

        String xpath = "//android.widget.TextView";
        return getSelectedStation().findElement(By.xpath(xpath)).getText();

    }

    public void swipeRadioListToTheEnd() {

        ScreenCoordinate radioListSwipeFrom = CommonUtils.loadScreenCoordinates("radio.list.swipe.from");
        ScreenCoordinate radioListSwipeTo = CommonUtils.loadScreenCoordinates("radio.list.swipe.to");
        CommonUtils.swipe(driver, radioListSwipeFrom, radioListSwipeTo);
        waitFor(Duration.ofSeconds(3));

    }
}
