package dev.aws.gerjoris;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AwsAmazonAndroidTest extends AwsAmazonTest {

    // This is a non-shared class variable, to avoid clashing driver management.
    private AppiumDriver<?> remoteWebDriver;
    private AppiumDriverLocalService service;

    /**
     * This will do the setup to use Appium.
     *
     */

    @Before
    public void setUp() {
        // I explicitly start the local service with the option to do an automated download of the chromedriver.
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort().withArgument(() -> "--allow-insecure", "chromedriver_autodownload"));

        // You can build out these capabilities as you see fit. By default, you can just state that you want to test Chrome on Android.
        // Reference: http://appium.io/docs/en/writing-running-appium/caps/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

        // You can add a reference to the chromedriverExecutable on your local machine, if you want to. But the service I boot above will do an automated download - while "insecure", this does take
        // away the pain of governing this driver.
        //
//        capabilities.setCapability("chromedriverExecutable", "/Users/gerjoris/.nvm/versions/node/v12.18.3/lib/node_modules/appium/node_modules/appium-chromedriver/chromedriver/mac/chromedriver");


        this.remoteWebDriver = new AppiumDriver<>(service, capabilities);
    }

    @Test
    public void runTest() {
        this.testAwsDotAmazonDotCom(remoteWebDriver);
    }

    @After
    public void tearDown() {
        this.remoteWebDriver.close();
        this.service.stop();
    }
}
