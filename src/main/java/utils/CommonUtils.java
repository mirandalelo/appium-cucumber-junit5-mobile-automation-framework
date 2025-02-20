package utils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import logger.Log;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.*;

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


}
