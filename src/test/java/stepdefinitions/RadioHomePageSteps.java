package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.pageobjects.*;

import static engine.Engine.getDriver;

public class RadioHomePageSteps {

    HomePage homePage = new HomePage(getDriver());
    RadioHomePage radioHomePage = new RadioHomePage(getDriver());
    SourcePage sourcePage = new SourcePage(getDriver());

    @Given("radio screen components are visible")
    public void radioScreenComponentsAreVisible() {

        sourcePage.openMediaSource();
        sourcePage.clickOnRadio();
        //radioHomePage.checkIfUIComponentsAreVisible();

    }

}
