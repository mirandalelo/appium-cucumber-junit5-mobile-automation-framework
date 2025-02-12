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


}
