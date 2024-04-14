package fgcuvladtyler;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ListingsAndSearch extends Setup {
    /**
     * This test class will test the search bar, category filter, location filter, and listing details.
     */
    
    @Test (priority = 1)
    public void testSearchBar() {
        driver .get("https://www.craigslist.com");
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
        locationPicker.click();

        // Find the div.items, then click on the second button
        WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'items')]//span[contains(@class,'label')])[3]")));
        String locationText = location.getText();
        location.click();

        // Compare that the location picker crumb contains the same text as the locationText
        WebElement locationPickerCrumb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'subarea-selector')]//span[contains(@class,'label')]")));
        Assert.assertEquals(locationText, locationPickerCrumb.getText(),  "The selected location does not match the expected location.");
    }

    @Test (priority = 4)
    public void testListingDetails() {
        // Find the listing with div id='search-results', then go inside to find the first ol->li->span.priceinfo that contains
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'search-results')]//ol//li")));
        String resultPrice = searchResult.findElement(By.xpath("//span[contains(@class,'priceinfo')]")).getText();
        searchResult.findElement(By.xpath("//a[contains(@class,'main')]")).click();
        
        WebElement listingPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'price')]")));
        Assert.assertEquals(resultPrice, listingPrice.getText(), "The listing price does not match the expected price.");
    }
}
