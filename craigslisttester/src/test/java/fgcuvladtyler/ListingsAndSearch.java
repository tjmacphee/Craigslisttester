package fgcuvladtyler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListingsAndSearch extends Setup {
    
    public void gotoListings() {
        System.out.println("Navigating to listings...");
    }

    public void searchListings() {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'search craigslist')]")));
        sleep(2000);
        searchField.sendKeys("Macbook Air 13", Keys.ENTER);
        sleep(5000);

        // TODO: Add test to verify search worked, e.g. check for search results that contain "Macbook Air 13"
    }
}
