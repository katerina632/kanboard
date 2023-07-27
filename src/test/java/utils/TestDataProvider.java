package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name="nonExistentUsers")
    public static Object[][] nonExistentUsers() {
        return new Object[][]{
                {"admin", " "},
                {"12345", "admin"}
        };
    }
}
