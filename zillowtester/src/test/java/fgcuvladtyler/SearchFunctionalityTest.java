package fgcuvladtyler;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class SearchFunctionalityTest extends SetupTests {
    
    @Test (priority = 2)
    public void testSearch() {
        // Wait until the input with placeholder "Enter an address, neighborhood, city, or ZIP code" is present
        driver.get("https://www.zillow.com/homes/california_rb/");
        sleep(5000);

        // Click on the button with text "Sort: Homes for You"
        WebElement sortButton = driver.findElement(By.xpath("//button[contains(text(), 'Sort: Homes for You')]"));
        sortButton.click();
        sleep(2000);

        // Click on the button with text "Price (High to Low)"
        WebElement priceHighToLowButton = driver.findElement(By.xpath("//button[contains(text(), 'Price (High to Low)')]"));
        priceHighToLowButton.click();
        sleep(2000);

        Assert.assertTrue(driver.getTitle().contains("Seattle WA"));
    }
}
