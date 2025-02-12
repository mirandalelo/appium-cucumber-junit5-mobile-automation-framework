package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import pages.base.SettingsBase;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class SettingsAndroid extends SettingsBase {

    //UiLib:VerticalListContainer
    private final String radioSettingsButton = "IconAtom:drawable/idx_icon_settings";
    private final String radioSettingsFullScreenSwitch= "(//android.view.View[@resource-id='UiLib:ListComponent'])[3]";
    private final String radioSettingsCloseButton = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[1]";
    private final String radioSettingsCloseButtonClass = "android.widget.Button";

    @Override
    public By getSettingsButton() {
        return By.id(radioSettingsButton);
    }

    @Override
    public By getSettingsFullScreenSwitch() { return By.xpath(radioSettingsFullScreenSwitch); }

    @Override
    public By getRadioSettingsCloseButton() { return By.xpath(radioSettingsCloseButtonClass); }

}
