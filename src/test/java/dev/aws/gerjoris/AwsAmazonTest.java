package dev.aws.gerjoris;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AwsAmazonTest {

    /**
     * This test will just open your chosen browser (based on your driver/capabilities), and browse to the AWS website
     */
    public void testAwsDotAmazonDotCom(RemoteWebDriver remoteWebDriver) {
        //Given
        String baseUrl = "https://aws.amazon.com/";

        //When
        remoteWebDriver.get(baseUrl);

        //Then
        Assert.assertEquals("Amazon Web Services (AWS) - Cloud Computing Services", remoteWebDriver.getTitle());
    }
}
