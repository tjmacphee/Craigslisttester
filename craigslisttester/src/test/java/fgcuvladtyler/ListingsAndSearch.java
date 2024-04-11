package fgcuvladtyler;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListingsAndSearch extends Setup {
    /**
     * This test class will test the search bar, category filter, location filter, and listing details.
     */
    
    @Test (priority = 1)
    public void testSearchBar() {
        driver.get().get("https://www.craigslist.com");
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'search craigslist')]")));
        searchBar.sendKeys("macbook air", Keys.RETURN);
        
        // Wait for presence of div.search-results-page-1 and that it has <ol><li> at least 1
        WebElement searchResults = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'search-results-page-1')]//ol//li")));
        Assert.assertTrue(searchResults.isDisplayed(), "The search results div is not displayed on the page.");
    }

    @Test (priority = 2)
    public void testCategoryFilter() {
        // Click on the div that has 'category-selector' in its class
        WebElement categorySelector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'category-selector')]")));
        categorySelector.click();

        // TODO: Error not interactable?
        WebElement category = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(text(),'appliances')]")));
        String categoryText = category.getText();
        category.click();

        // Wait to see if the div.category-selector->div->button->span.label has the same text as the categoryLabel
        WebElement selectedCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'category-selector')]//div//button//span[contains(@class,'label')]")));
        Assert.assertEquals(categoryText, selectedCategory.getText(), "The selected category does not match the expected category.");
    }

    @Test (priority = 3)
    public void testLocationFilter() {
        // Reset the category from above to test to first index
        WebElement categorySelector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'category-selector')]")));
        categorySelector.click();

        WebElement category = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(text(),'all')]")));
        category.click();

        // Click on the location picker and capture text value
        WebElement locationPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'subarea-selector')]")));
        locationPicker.click();

        // TODO: Vlad to make this selector more dynamic
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(text(),'collier co')]")));
        String locationText = location.getText();
        location.click();

        // Compare that the location picker crumb contains the text 'Cape Coral'
        WebElement locationPickerCrumb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'subarea-selector')]//div//button//span[contains(@class,'label')]")));
        Assert.assertEquals(locationPickerCrumb.getText(), locationText,  "The selected location does not match the expected location.");
    }

    @Test (priority = 4)
    public void testListingDetails() {
        
    }
}
