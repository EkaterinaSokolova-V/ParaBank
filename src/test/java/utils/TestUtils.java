package utils;

import static framework.BaseTest.getDriver;

public class TestUtils {
    public static String getUrl() {

        return getDriver().getCurrentUrl();
    }
}
