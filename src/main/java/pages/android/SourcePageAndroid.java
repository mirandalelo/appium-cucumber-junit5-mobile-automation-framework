package pages.android;

import org.openqa.selenium.By;
import pages.base.SourcePageBase;

public class SourcePageAndroid extends SourcePageBase {
    @Override
    public By getSourceButton() {
        return By.id("com.bmwgroup.apinext.mediaapp:id/source_name");
    }

    @Override
    public By getRadioButton() {
        return By.xpath(".//node[normalize-space(@resource-id) = \"SourceAvailableInList_DynamicString(text='Radio')\"]");
    }

    @Override
    public By getMediaMenu() { return By.xpath("//*[@resource-id='IconicBar.Det.Media']"); }

    @Override
    public By getHomeMenu() { return By.xpath(".//node[@resource-id='IconicBar.Det.Home']"); }

}
