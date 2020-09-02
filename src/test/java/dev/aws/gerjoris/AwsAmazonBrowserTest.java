package dev.aws.gerjoris;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AwsAmazonBrowserTest extends AwsAmazonTest {

    // This is a non-shared class variable, to avoid clashing driver management.
    private FirefoxDriver remoteWebDriver;

    /**
     * This will do the setup to use FireFox.
     */

//    @Before
    public void setUp() {
        // You can install the geckodriver using NPM: `npm install -g geckodriver`
        System.setProperty("webdriver.gecko.driver", "/Users/gerjoris/.nvm/versions/node/v12.18.3/bin/geckodriver");
        this.remoteWebDriver = new FirefoxDriver();
    }

//    @Test
    public void runTest() {
        this.testAwsDotAmazonDotCom(remoteWebDriver);
    }

//    @After
    public void tearDown() throws Exception {
        try {
            this.remoteWebDriver.close();
        } catch (Exception e) {
            //We did our best trying to stop the remote driver, but it failed for some reason.
            //Might be because of the platform we are using.
            //In a production setup, you would probably handle this better than I did here.
        }
    }

}
