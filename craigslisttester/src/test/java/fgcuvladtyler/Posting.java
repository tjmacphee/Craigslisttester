package fgcuvladtyler;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class Posting extends Setup {
    /*
     * This test class will test the post listing page, post listing functionality, edit listing, and delete listing.
     */

    @Test (priority = 1)
    public void testPostListingPage() {   
        driver.get("https://accounts.craigslist.org/login");
        // Wait for the email and password input fields to be visible on the page, then
        // enter the login credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputEmailHandle']")))
            .sendKeys(config.getProperty("login.username"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputPassword']")))
            .sendKeys(config.getProperty("login.password"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']"))).click();

        sleep(2000);

        driver.get("https://www.craigslist.com");

        // find & click the post tag
        WebElement postListing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='post']")));
        postListing.click();

        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://post.craigslist.org/"), "The current URL does not match the expected URL.");
    }

    @Test (priority = 2)
    public void testPostListingFunctionality() {

        // Wait for the presence of strong element with text 'Re-use selected data from your previous posting', click skip button if present
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[contains(text(),'Re-use selected data from your previous posting')]")));
            WebElement skipButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'skip')]")));
            skipButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("No previous posting data found, proceeding without it.");
        }

        // If there is a <p>please limit each posting to a single area and category, once per 48 hours</p>, click the button with text 'continue' text
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'please limit each posting to a single area and category, once per 48 hours')]")));
            WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'continue')]")));
            continueButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("No limit message found, proceeding without it.");
        }

        // Wait for the presence of ul.selection-list and pick the first li
        WebElement categoryList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'selection-list')]//li")));
        categoryList.click();

        // If there's a div with a span that says 'bypass this step', click it
        try {
            WebElement bypassStep = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[span[text()='bypass this step']]")));
            bypassStep.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Bypass step not available, proceeding without it.");
        }

        // click on the li that has a span that contains 'for sale by owner'
        WebElement saleByOwner = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[span[contains(text(),'for sale by owner')]]")));
        saleByOwner.click();

        // click on the label that has a div with a span that contains 'computers'
        WebElement computers = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[div[span[contains(text(),'computers')]]]")));
        computers.click();

        // Find the input with id 'PostingTitle' and enter 'Macbook Air' into it
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='PostingTitle']")));
        title.sendKeys("Macbook Air");

        // Enter description
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='PostingBody']")));
        description.sendKeys("This is a Macbook Air in great condition.");

        // Find price and enter 200
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='price']")));
        price.sendKeys("200");

        // Find the li.crum subarea->p text value, and in a new tab, search it, then grab the zip code for it.
        WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class,'crumb')]//p")));
        String locationText = location.getText();
        // Add ' zip code' to the location text
        locationText += " zip code";

        // Open a new tab using JavaScript
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Switch to the new tab

        driver.get("https://www.google.com");
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='q']")));
        search.sendKeys(locationText, Keys.RETURN);

        // Wait for the carousel to load (use a specific identifier for your carousel)
        // TODO: Improve this, g-scrolling-carousel is not a good identifier and not always available
        WebElement carousel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("g-scrolling-carousel")));
        // General XPath to select any div elements within the carousel
        List<WebElement> allDivs = carousel.findElements(By.xpath(".//div"));

        // Scan all div elements for a 5-digit number
        String text = "";
        for (WebElement div : allDivs) {
            text = div.getText();
            if (text.matches("(?<!\\d)\\d{5}(?!\\d)")) {  // Regex to find a standalone 5-digit number
                break;
            }
        }

        driver.switchTo().window(tabs.get(0));

        // Find input name 'postal' and enter the zip code
        WebElement postal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='postal']")));
        postal.sendKeys(text);

        // Submit
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='go']")));
        submit.click();

        // click button with continue text
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'continue')]")));
        continueButton.click();

        // Click button with done with images
        WebElement doneWithImages = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'done with images')]")));
        doneWithImages.click();

        // Click publish button
        WebElement publish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'publish')]")));
        publish.click();

        // If there's a button with text 'continue', click it & sleep for 20 so user can confirm listing
        try {
            WebElement continueButton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'continue')]")));
            // find input name="pn_number" & enter config.phone
            WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pn_number']")));
            phoneNumber.sendKeys(config.getProperty("phone"));
            continueButton2.click();
            sleep(20000);
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("No continue button found, proceeding without it.");
        }

        sleep(2000);
        driver.get("https://accounts.craigslist.org/login/home");

        // Make sure table contains class accthp_postings table is present and has a row
        WebElement postingsTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'accthp_postings')]")));
        List<WebElement> rows = postingsTable.findElements(By.tagName("tr"));

        Assert.assertTrue(rows.size() > 0, "The postings table does not have any rows.");
    }

    @Test (priority = 3)
    public void testEditListing() {
        // Continue from current page, click the input where value is 'edit' button any first list in row
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='go'][@value='edit']")));
        editButton.click();

        // Find button with text 'edit post'
        WebElement editPost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'edit post')]")));
        editPost.click();

        // Find the input with id 'PostingTitle' and enter 'Macbook Air 13'' into it
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='PostingTitle']")));
        title.sendKeys("Macbook Air 13'");

        // Enter description
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='PostingBody']")));
        description.sendKeys("This is a Macbook Air in great condition. Please buy it!");

        // Find price and enter 300
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='price']")));
        price.sendKeys("300");

        // Submit
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='go']")));
        submit.click();

        // Click publish button
        WebElement publish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'publish')]")));
        publish.click();

        // Find h4 with text "Thanks for posting! We really appreciate it."
        WebElement thanks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Thanks for posting! We really appreciate it.')]")));

        Assert.assertTrue(thanks.isDisplayed(), "The 'Thanks for posting!' message is not displayed.");
    }

    @Test (priority = 4)
    public void testDeleteListing() {
        driver.get("https://accounts.craigslist.org/login/home");

        // Find the first input with value 'delete' and click it
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='go'][@value='delete']")));
        deleteButton.click();

        // Find the <b> tag that contains "This posting has been deleted from craigslist"
        WebElement deleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'This posting has been deleted from craigslist')]")));

        Assert.assertTrue(deleted.isDisplayed(), "The 'This posting has been deleted from craigslist' message is not displayed.");
    }
}
