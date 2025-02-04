package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.pageobjects.HomePage;
import pages.pageobjects.RadioHomePage;
import pages.pageobjects.SettingsPage;
import pages.pageobjects.StationListPage;

import static engine.Engine.getDriver;

public class RadioHomePageSteps {

    HomePage homePage = new HomePage(getDriver());
    RadioHomePage radioHomePage = new RadioHomePage(getDriver());

    @Given("radio screen components are visible")
    public void radioScreenComponentsAreVisible() {

        radioHomePage.checkIfUIComponentsAreVisible();

    }

}
