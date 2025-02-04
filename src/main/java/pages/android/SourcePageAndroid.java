package pages.android;

import org.openqa.selenium.By;
import pages.base.SourcePageBase;

public class SourcePageAndroid extends SourcePageBase {
    @Override
    public By getSourceButton() {
        return By.id("media_source_header_component");
    }

    @Override
    public By getRadioButton() {
        return By.id("ImageFrameAtom:drawable/internal_idx_image_source_background_radio");
    }
}
