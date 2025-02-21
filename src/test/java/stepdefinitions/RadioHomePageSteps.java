package stepdefinitions;

import data.entity.MediaSession;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.pageobjects.*;

import java.time.Duration;

import static engine.Engine.getDriver;

public class RadioHomePageSteps {

    HomePage homePage = new HomePage(getDriver());
    RadioHomePage radioHomePage = new RadioHomePage(getDriver());
    StationListPage stationListPage = new StationListPage(getDriver());
    SourcePage sourcePage = new SourcePage(getDriver());
    MiniPlayerPage miniPlayerPage = new MiniPlayerPage(getDriver());

    @Given("all popups are closed after startup")
    public void allPopupsAreClosedAfterStartup() {

        homePage.closeAllPopups();

    }

    @Given("media source menu is opened")
    public void mediaSourceMenuIsOpened() {

        sourcePage.openMediaSource();

    }

    @And("radio is selected from media source")
    public void radioIsSelectedFromMediaSource() {

        sourcePage.clickOnRadio();

    }

    @And("radio screen components are visible")
    public void radioScreenComponentsAreVisible() {

        //Improve this logic ...
        radioHomePage.checkIfUIComponentsAreVisible();

    }

    @Given("the media mini player is visible")
    public void the_media_mini_player_is_visible() {

        Assert.assertTrue("Mini player is not visible!",radioHomePage.isMiniPlayerIsVisible());

    }

    @When("selecting {string} station from the stations list")
    public void selecting_a_station_from_the_stations_list(String station) {

        radioHomePage.selectStation(station);

        if (station.equals("any")) {

            stationListPage = radioHomePage.getStationListPage();
            station = stationListPage.getStationName();

        } else {

            stationListPage.loadStationNames();
            stationListPage.setCurrentStation(station);

        }

        Assert.assertEquals(station + " is not selected!", stationListPage.getStationName(), station);

    }

    @Then("the {string} station is audible")
    public void the_station_is_audible(String station) {

        MediaSession mediaSession = radioHomePage.getMediaSession();
        Assert.assertTrue("Audio focus is not on Radio", mediaSession.isActive());
        Assert.assertEquals("Radio station is not playing", "PLAYING",mediaSession.getState());

    }

    @And("the {string} information is updated")
    public void the_station_information_is_updated(String station) {

        String stationName = null;

        if (station.equals("next")) {

            stationName = stationListPage.getStationName();
            Assert.assertTrue(stationName + " is not displayed in Mini Player", radioHomePage.isStationNameDisplayedInMiniPlayer(stationName));

        } else if (station.equals("previous")) {

            stationName = stationListPage.getStationName();
            Assert.assertTrue(stationName + " is not displayed in Mini Player", radioHomePage.isStationNameDisplayedInMiniPlayer(stationName));

        } else if (station.equals("current")) {

            stationName = stationListPage.getCurrentStationName();
            Assert.assertTrue(stationName + " is not displayed in Mini Player", radioHomePage.isStationNameDisplayedInMiniPlayer(stationName));

        } else {

            Assert.assertTrue(station + " is not displayed in Mini Player", radioHomePage.isStationNameDisplayedInMiniPlayer(station));

        }

    }

    @When("pressing right skip button on Media Mini Player")
    public void pressing_right_skip_button_on_media_mini_player() {

        miniPlayerPage.pressRightSkipButton();

    }

    @Then("the next station in the list is selected")
    public void the_next_station_in_the_list_is_selected() {

        String actualStationName = stationListPage.getNextStationName();
        Assert.assertEquals(miniPlayerPage.getStationName(), actualStationName);

    }

    @When("pressing the left skip button in Media Mini Player")
    public void pressing_the_left_skip_button_in_media_mini_player() {

        miniPlayerPage.pressLeftSkipButton();

    }

    @Then("the previous station in the list is selected")
    public void the_previous_station_in_the_list_is_selected() {

        String actualStationName = stationListPage.getPreviousStationName();
        Assert.assertEquals(miniPlayerPage.getStationName(),actualStationName);

    }

    @When("repeating the skip to the right actions {int} times")
    public void repeating_the_skip_to_the_right_actions_several_times(int times) {

        miniPlayerPage.pressRightSkipButton(times);

    }

    @Then("the corresponding station is always selected in the list")
    public void the_corresponding_station_is_always_selected_in_the_list() {

        stationListPage.loadStationNames();

    }

    @Given("the media source is {string}")
    public void theMediaSourceIs(String mediaSource) {

        Assert.assertEquals(radioHomePage.getMediaSourceName().toLowerCase(),mediaSource);

    }

    @When("scrolling from top to bottom through the all stations list")
    public void scrollingFromTopToBottomThroughTheAllStationsList() {

        stationListPage.loadStationNames();
        while(stationListPage.isTheRadioListAtTheEnd()) {
            stationListPage.swipeRadioListToTheEnd();

            stationListPage.loadStationNames();
        }

    }

    @And("the list of stations is at the beginning")
    public void theListOfStationsIsAtTheBeginning() {

        stationListPage.loadStationNames();
        while(stationListPage.isTheRadioListAtTheBeginning()) {
            stationListPage.swipeRadioListToTop();

            stationListPage.loadStationNames();
        }

    }

    @And("waits for {int} seconds")
    public void waitsForIntSeconds(int seconds) {

        radioHomePage.waitFor(Duration.ofSeconds(seconds));

    }
}
