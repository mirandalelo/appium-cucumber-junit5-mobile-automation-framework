package utils;

import data.entity.MediaSession;
import data.type.MediaSessionAppTypes;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import logger.Log;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static engine.Engine.getDriver;
import static io.github.the_sdet.cucumber.CucumberUtils.*;
import static utils.ConfigReader.*;

/**
 * Class to handle common utilities
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
public class CommonUtils {
    /**
     * Attaches screenshot to the Cucumber report based on the configuration.
     *
     * @param scenario The Scenario object from Cucumber.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void attachScreenshotPerConfig(Scenario scenario) {
        Properties properties = ConfigReader.getProperties();
        if (properties.getProperty("screenshot").equals("only.fail")) {
            if (scenario.isFailed()) {
                logFailureToReport(scenario.getName() + " Failed...");
                attachScreenshot(getDriver());
            }
        } else if (properties.getProperty("screenshot").equals("only.pass")) {
            if (!scenario.isFailed()) {
                logSuccessToReport(scenario.getName() + " Passed...");
                attachScreenshot(getDriver());
            }
        } else {
            Log.info("Taking Screenshot.");
            attachScreenshot(getDriver());
        }
    }

    public static void tap(AppiumDriver driver, ScreenCoordinate screenCoordinates) {

        tap(driver,screenCoordinates.getX(),screenCoordinates.getY());

    }

    public static void swipe(AppiumDriver driver, ScreenCoordinate swipeFrom, ScreenCoordinate swipeTo) {

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), swipeFrom.getX(), swipeFrom.getY()))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), swipeTo.getX(), swipeTo.getY()))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));


    }

    public static void tap(AppiumDriver driver, int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(tap));
    }

    public static ScreenCoordinate loadScreenCoordinates(String propertyName) {
        Properties screenCoordinatesProperties = getScreenCoordinates();

        ScreenCoordinate screenCoordinate = new ScreenCoordinate();
        screenCoordinate.setX(Integer.parseInt(screenCoordinatesProperties.getProperty(propertyName+".x")));
        screenCoordinate.setY(Integer.parseInt(screenCoordinatesProperties.getProperty(propertyName+".y")));

        return screenCoordinate;

    }

    public static Integer getAndroidCurrentUser(AppiumDriver driver) {

        String output = (String) driver.executeScript("mobile: shell",
                new java.util.HashMap<String, String>() {{
                    put("command", ConfigReader.getAdbCommands().getProperty("get.current.user"));
                    put("args", "");
                }});

        Log.info("Active User: "+output);

        return Integer.parseInt(output.replaceAll("[\\r\\n]", "").trim());

    }


    /**
     *
     * @param driver
     * @param userId
     * @param availableApps
     * @return MediaSession
     */
    public static MediaSession getAndroidMediaSession(AppiumDriver driver, Integer userId, MediaSessionAppTypes availableApps) {

        MediaSession mediaSession = null;

        String output = (String) driver.executeScript("mobile: shell",
                new java.util.HashMap<String, String>() {{
                    put("command", ConfigReader.getAdbCommands().getProperty("get.media.session"));
                    put("args", "");
                }});


        // Regular expression pattern (matches any number in "size=XX")
        String regex = "";
        if (availableApps == MediaSessionAppTypes.TMS) {
            regex = "(?m)^\\s*bmw_tuner com\\.bmwgroup\\.apinext\\.tunermediaservice/bmw_tuner \\(userId=" + userId + "\\)(?:\\n\\s{2,}.*?)*?\\n\\s{2,}queueTitle=.*?size=\\d+$";
        }

        // Compile and match pattern
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(output);

        if (matcher.find()) {

            Log.info("Media Session data acquired: "+matcher.group(0));

            String mediaInfo = matcher.group(0);
            mediaSession = new MediaSession();
            mediaSession.setUserId(userId);

            //Extracting package
            pattern = Pattern.compile("package=([\\w\\.]+)");
            matcher = pattern.matcher(mediaInfo);

            if (matcher.find()) {
                mediaSession.setPackageName(matcher.group(1));
            }

            //Extracting active
            pattern = Pattern.compile("active=(true|false)");
            matcher = pattern.matcher(mediaInfo);

            if (matcher.find()) {
                mediaSession.setActive(Boolean.parseBoolean(matcher.group(1)));
            }

            //Extracting state: PLAYING, PAUSED
            pattern = Pattern.compile("state=([A-Z_]+)\\((\\d+)\\)");
            matcher = pattern.matcher(mediaInfo);

            if (matcher.find()) {
                mediaSession.setState(matcher.group(1).trim());
            }

            //Extracting metadata
            pattern = Pattern.compile("description=(.+)");
            matcher = pattern.matcher(mediaInfo);

            if (matcher.find()) {
                mediaSession.setMetadataDescription(matcher.group(1).trim());
            }


        } else {
            Log.info("No media session found: "+output);
        }

        return mediaSession;

    }


}
