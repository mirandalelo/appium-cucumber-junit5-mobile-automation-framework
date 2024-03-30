package pages.android;

import org.openqa.selenium.By;
import pages.base.HomePageBase;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class HomePageAndroid extends HomePageBase {
    private final String selectYourLanguageLabel = "//android.widget.TextView[@text='Select your Language']";
    private final String continueButton = "//android.widget.Button[@resource-id='com.makemytrip:id/continueButton']";
    private final String languageSkipButton = "com.makemytrip:id/skipTextView";
    private final String loginScreen = "//android.widget.TextView[@text='Signup or Login ']";
    private final String dismissButton = "com.makemytrip:id/snack_bar_footer_left";
    private final String completeActionUsingDevicePopUp = "//android.widget.TextView[@resource-id='android:id/title' and @text='Complete action using']";
    private final String continueWithEmail = "com.makemytrip:id/iv_changeToEmail";
    private final String closeLoginAlert = "com.makemytrip:id/back_key";
    private final String adBar = "com.makemytrip:id/rl_ad_bar";
    private final String adBarCloseButton = "//android.widget.RelativeLayout[@resource-id='com.makemytrip:id/rl_ad_bar']/android.widget.ImageView[@resource-id='com.makemytrip:id/iv_cross']";
    private final String adText = "com.makemytrip:id/tv_ad_text";
    private final String drawerButton = "com.makemytrip:id/iv_drawer";
    private final String logo = "com.makemytrip:id/iv_mmt_icon";
    private final String header = "com.makemytrip:id/tvHeader";
    private final String subHeader = "com.makemytrip:id/tvSubHeader";
    private final String myCash = "com.makemytrip:id/tv_mycash_text";
    private final String myBiz = "com.makemytrip:id/tv_mybiz_text";
    private final String searchIcon = "com.makemytrip:id/iv_universal_search_icon";
    private final String primaryLob = "com.makemytrip:id/primaryLob";
    private final String primaryLobItems = "//android.view.ViewGroup[@resource-id='com.makemytrip:id/primaryLob']//android.widget.Button";
    private final String primaryLobItem = "//android.view.ViewGroup[@resource-id='com.makemytrip:id/primaryLob']//android.widget.Button[@text='v1']";
    private final String secondaryLob = "com.makemytrip:id/secondaryLob";
    private final String secondaryLobItems = "//android.view.ViewGroup[@resource-id='com.makemytrip:id/secondaryLob']//android.widget.Button";
    private final String secondaryLobItem = "//android.view.ViewGroup[@resource-id='com.makemytrip:id/secondaryLob']//android.widget.Button[@text='v1']";
    private final String getSecondaryLobExpand = "com.makemytrip:id/ll_more_container";
    private final String HomeTab = "//android.widget.Button[@resource-id='com.makemytrip:id/rl_images' and @text='Home']";
    private final String BottomTabs = "//android.widget.Button[@resource-id='com.makemytrip:id/rl_images' and contains(@text,'')]";
    private final String BottomTab = "//android.widget.Button[@resource-id='com.makemytrip:id/rl_images' and contains(@text,'v1')]";
    private final String backButton = "//android.widget.ImageButton[@content-desc='Back'] | //android.widget.ImageView[@content-desc='Back'] | //android.widget.TextView[@text='Trains & Bus']//preceding-sibling::android.view.ViewGroup | //android.widget.TextView[@text='Holiday Packages']//preceding-sibling::android.view.ViewGroup";

    @Override
    public By getSelectYourLanguageLabel() {
        return By.xpath(selectYourLanguageLabel);
    }

    @Override
    public By getContinueButton() {
        return By.xpath(continueButton);
    }

    @Override
    public By languageSelectionSkipButton() {
        return By.id(languageSkipButton);
    }

    @Override
    public By getLoginScreen() {
        return By.xpath(loginScreen);
    }

    @Override
    public By getDismissButton() {
        return By.id(dismissButton);
    }
    @Override
    public By getCompleteActionUsingDevicePopUp() {
        return By.xpath(completeActionUsingDevicePopUp);
    }

    @Override
    public By getContinueWithEmail() {
        return By.id(continueWithEmail);
    }

    @Override
    public By getCloseLoginAlert() {
        return By.id(closeLoginAlert);
    }
    public By getClose() {
        return By.id(closeLoginAlert);
    }

    @Override
    public By getAdBar() {
        return By.id(adBar);
    }

    @Override
    public By getAdBarCloseButton() {
        return By.xpath(adBarCloseButton);
    }

    @Override
    public By getAdContent() {
        return By.id(adText);
    }

    @Override
    public By getDrawerButton() {
        return By.id(drawerButton);
    }

    @Override
    public By getMyCash() {
        return By.id(myCash);
    }

    @Override
    public By getMyBiz() {
        return By.id(myBiz);
    }

    @Override
    public By getSearchIcon() {
        return By.id(searchIcon);
    }

    @Override
    public By getLogo() {
        return By.id(logo);
    }

    @Override
    public By getHeader() {
        return By.id(header);
    }

    @Override
    public By getSubHeader() {
        return By.id(subHeader);
    }
    @Override
    public By getPrimaryLob() {
        return By.id(primaryLob);
    }

    @Override
    public By getPrimaryLobItems() {
        return By.xpath(primaryLobItems);
    }

    @Override
    public By getPrimaryLobItem() {
        return By.xpath(primaryLobItem);
    }

    @Override
    public By getSecondaryLob() {
        return By.id(secondaryLob);
    }

    @Override
    public By getSecondaryLobItems() {
        return By.xpath(secondaryLobItems);
    }

    @Override
    public By getSecondaryLobItem() {
        return By.xpath(secondaryLobItem);
    }

    @Override
    public By getGetSecondaryLobExpand() {
        return By.id(getSecondaryLobExpand);
    }

    @Override
    public By getHomeTab() {
        return By.xpath(HomeTab);
    }

    @Override
    public By getBottomTabs() {
        return By.xpath(BottomTabs);
    }

    @Override
    public By getBottomTab() {
        return By.xpath(BottomTab);
    }

    @Override
    public By getBackButton() {
        return By.xpath(backButton);
    }
}