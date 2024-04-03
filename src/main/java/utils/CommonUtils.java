package utils;

import io.cucumber.java.Scenario;
import logger.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static engine.Engine.getDriver;
import static io.github.the_sdet.cucumber.CucumberUtils.*;

/**
 * Class to handle common utilities
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
public class CommonUtils {
    /**
     * Extracts the feature name from the given Scenario object.
     *
     * @param scenario        The Scenario object from Cucumber.
     * @param withPackageName A boolean indicating whether to include package name along with feature name.
     * @return The feature name extracted from the Scenario.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static String getFeatureNameFromScenario(Scenario scenario, boolean withPackageName) {
        String[] test = scenario.getUri().toString().split("/");
        String featureName = test[1].split("\\.")[0];
        String packageName = test[0].split(":")[1];
        Log.info("Feature: " + featureName);
        Log.info("Package: " + packageName);
        if (withPackageName)
            return packageName + " - " + featureName;
        else return featureName;
    }

    /**
     * Enum representing the status of a test scenario.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public enum STATUS {
        PASS("PASS"), FAIL("FAIL");
        public final String status;

        STATUS(String status) {
            this.status = status;
        }
    }

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

    /**
     * Format a date string from one format to another.
     *
     * @param inputDateStr     The input date string.
     * @param inputDateFormat  The input date format.
     * @param outputDateFormat The output date format.
     * @return the formatted date string.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static String formatDate(String inputDateStr, String inputDateFormat, String outputDateFormat) {
        DateFormat inputFormatter = new SimpleDateFormat(inputDateFormat);
        DateFormat outputFormatter = new SimpleDateFormat(outputDateFormat);
        try {
            Date inputDate = inputFormatter.parse(inputDateStr);
            return outputFormatter.format(inputDate);
        } catch (ParseException e) {
            Log.error("Parse Exception...", e);
            return null;
        }
    }
}
