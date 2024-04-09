package fgcuvladtyler;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends SetupTests {

    @Test (priority = 1)
    public void verifyHomePageTitle() {
        driver.get("https://www.zillow.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Zillow: Real Estate, Apartments, Mortgages & Home Values"));
    }
}
