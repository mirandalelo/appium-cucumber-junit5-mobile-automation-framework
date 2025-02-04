package utils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import logger.Log;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

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

}
