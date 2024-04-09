package fgcuvladtyler;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends SetupTests {

    @Test (priority = 1)
    public void verifyHomePageTitle() {
        driver.get("https://www.craigslist.com");
        sleep(15000);
        // String title = driver.getTitle();
        // Assert.assertTrue(title.contains(""));
    }
}
