package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.pageobjects.HomePage;
import pages.pageobjects.SettingsPage;

import java.time.Duration;

import static engine.Engine.getDriver;

public class SettingsSteps {

    HomePage homePage = new HomePage(getDriver());
    SettingsPage settingsPage = new SettingsPage(getDriver());

    @And("User taps over radio settings button")
    public void user_taps_over_radio_settings_button() {

        homePage.waitAndCheckIsVisible(settingsPage.settings.getSettingsButton(), Duration.ofSeconds(10));
        settingsPage.openSettings();

    }
    @And("User disables full screen mode from radio settings")
    public void user_disables_full_screen_mode_from_radio_settings() {

        settingsPage.waitAndCheckIsVisible(settingsPage.settings.getSettingsFullScreenSwitch(),Duration.ofSeconds(5));
        settingsPage.disableFullScreenSwitch();

        Assert.assertFalse("Full Screen Switch is still enabled!", settingsPage.isFullScreenSwitchEnabled());

    }
    @And("User closes radio settings screen")
    public void user_closes_radio_settings_screen() {

        settingsPage.closeSettings();

    }

}
