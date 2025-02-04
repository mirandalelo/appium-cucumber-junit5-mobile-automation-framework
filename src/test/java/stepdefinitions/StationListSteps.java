package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.pageobjects.HomePage;
import pages.pageobjects.MenuPage;
import pages.pageobjects.SettingsPage;
import pages.pageobjects.StationListPage;

import java.time.Duration;

import static engine.Engine.getDriver;

public class StationListSteps {

    HomePage homePage = new HomePage(getDriver());
    StationListPage stationListPage = new StationListPage(getDriver());

    @Given("The list os stations is visible")
    public void the_list_os_stations_is_visible() {

        Assert.assertTrue("List of stations is not visible",stationListPage.isStationListVisible());

    }

    @Then("User should all stations in the list")
    public void userShouldAllStationsInTheList() {

        Assert.assertTrue("Stations are not loaded!", stationListPage.isStationListLoaded());

    }
}
