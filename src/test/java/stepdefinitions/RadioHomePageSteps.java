package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.pageobjects.*;

import static engine.Engine.getDriver;

public class RadioHomePageSteps {

    HomePage homePage = new HomePage(getDriver());
    RadioHomePage radioHomePage = new RadioHomePage(getDriver());
    SourcePage sourcePage = new SourcePage(getDriver());

    @Given("radio screen components are visible")
    public void radioScreenComponentsAreVisible() {

        //Improve this logic ...
        radioHomePage.checkIfUIComponentsAreVisible();

    }

    @Given("all popups are closed after startup")
    public void allPopupsAreClosedAfterStartup() {

        homePage.closeAllPopups();

    }

    @And("media source menu is opened")
    public void mediaSourceMenuIsOpened() {

        sourcePage.openMediaSource();

    }

    @And("radio is selected from media source")
    public void radioIsSelectedFromMediaSource() {

        sourcePage.clickOnRadio();

    }



}
