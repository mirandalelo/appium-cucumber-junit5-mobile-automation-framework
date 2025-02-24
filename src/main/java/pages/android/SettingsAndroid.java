package pages.android;

import org.openqa.selenium.By;
import pages.base.SettingsBase;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class SettingsAndroid extends SettingsBase {

    //UiLib:VerticalListContainer
    private final String radioSettingsButton = "IconAtom:drawable/idx_icon_settings";
    private final String radioSettingsFullScreenSwitch= "//android.widget.TextView[@resource-id='TextAtom:string/media_app_auto_media_fullscreen_toggle_bt']/preceding-sibling::android.view.View[1]";
    private final String radioSettingsFullScreenSwitchArea = "//android.view.View[@resource-id='InternalEntry-Switch automatically to fullscreen mode']";
    private final String getRadioSettingsButtonGlowEffect = "//android.view.View[@content-desc='Glow effect']";
    private final String radioSettingsCloseButton = "//android.view.View[@resource-id=\"uilib_root_test_tag\"]/android.view.View/android.view.View[3]";
    private final String radioSettingsCloseButtonClass = "android.widget.Button";

    @Override
    public By getSettingsButton() {
        return By.id(radioSettingsButton);
    }

    @Override
    public By getSettingsFullScreenSwitch() { return By.xpath(radioSettingsFullScreenSwitch); }

    @Override
    public By getSettingsFullScreenSwitchArea() { return By.xpath(radioSettingsFullScreenSwitchArea); }

    @Override
    public By getSettingsFullScreenSwitchGlowEffect() {
        return By.xpath(getRadioSettingsButtonGlowEffect);
    }

    @Override
    public By getRadioSettingsCloseButton() { return By.xpath(radioSettingsCloseButtonClass); }

}
