package dev.aws.gerjoris;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AwsAmazonBrowserTest {

    RemoteWebDriver firefoxDriver;

    @Before
    public void setUp() throws Exception {
        // You can install the geckodriver using NPM: `npm install -g geckodriver`
        System.setProperty("webdriver.gecko.driver", "/Users/gerjoris/.nvm/versions/node/v12.18.3/bin/geckodriver");
        firefoxDriver = new FirefoxDriver();
    }

    /**
     * This test will just open your Firefox browser, and browse to the AWS website
     */
    @Test
    public void testAwsDotAmazonDotCom() {
        //Given
        String baseUrl = "https://aws.amazon.com/";

        //When
        firefoxDriver.get(baseUrl);

        //Then
        Assert.assertEquals("Amazon Web Services (AWS) - Cloud Computing Services", firefoxDriver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        firefoxDriver.close();
    }
}
