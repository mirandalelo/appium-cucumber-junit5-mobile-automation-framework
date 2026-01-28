package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.pageobjects.HomePage;
import pages.pageobjects.SettingsPage;

import java.time.Duration;

import static engine.Engine.getDriver;

public class SettingsSteps {

    HomePage homePage = new HomePage(getDriver());
    SettingsPage settingsPage = new SettingsPage(getDriver());

    @And("User taps over radio settings button")
    public void user_taps_over_radio_settings_button() {

        homePage.waitFor(Duration.ofSeconds(3));
        homePage.waitAndCheckIsVisible(settingsPage.settings.getSettingsButton(), Duration.ofSeconds(5));
        settingsPage.openSettings();

    }
    @And("User disables full screen mode from radio settings")
    public void user_disables_full_screen_mode_from_radio_settings() {

        settingsPage.disableFullScreenSwitch();

        Assert.assertFalse("Full Screen Switch is still enabled!", settingsPage.isFullScreenSwitchEnabled());

    }

    @And("User closes radio settings screen")
    public void user_closes_radio_settings_screen() {

        settingsPage.closeSettings();


    }

    @Given("Android Home Button is pressed")
    public void androidHomeButtonIsPressed() {
        settingsPage.pressAndroidHome();
    }
}
