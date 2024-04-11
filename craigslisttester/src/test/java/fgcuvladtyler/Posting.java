package fgcuvladtyler;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Posting extends Setup {
    /*
     * This test class will test the post listing page, post listing functionality, edit listing, and delete listing.
     */

    @Test (priority = 1)
    public void testPostListingPage() {
        driver.get().get("https://accounts.craigslist.org/login");
        // Wait for the email and password input fields to be visible on the page, then
        // enter the login credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputEmailHandle']")))
            .sendKeys(config.getProperty("login.username"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputPassword']")))
            .sendKeys(config.getProperty("login.password"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']"))).click();

        sleep(2000);

        driver.get().get("https://www.craigslist.com");

        // find & click the post tag
        WebElement postListing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='post']")));
        postListing.click();

        Assert.assertTrue(driver.get().getCurrentUrl().startsWith("https://post.craigslist.org/"), "The current URL does not match the expected URL.");
    }

    @Test (priority = 2)
    public void testPostListingFunctionality() {
        // // Wait for the presence of ul.selection-list and pick the first li
        // WebElement categoryList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'selection-list')]//li")));
        // categoryList.click();

        // // If there's a div with a span that says 'bypass this step', click it
        // try {
        //     WebElement bypassStep = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[span[text()='bypass this step']]")));
        //     bypassStep.click();
        // } catch (org.openqa.selenium.TimeoutException e) {
        //     // The element was not found within the wait time, handle as needed
        //     System.out.println("Bypass step not available, proceeding without it.");
        // }

        // // click on the li that has a span that contains 'for sale by owner'
        // WebElement saleByOwner = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[span[contains(text(),'for sale by owner')]]")));
        // saleByOwner.click();

        // // click on the label that has a div with a span that contains 'computers'
        // WebElement computers = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[div[span[contains(text(),'computers')]]]")));
        // computers.click();

        // // Find the input with id 'PostingTitle' and enter 'Macbook Air' into it
        // WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='PostingTitle']")));
        // title.sendKeys("Macbook Air");

        // // Enter description
        // WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='PostingBody']")));
        // description.sendKeys("This is a Macbook Air in great condition.");

        // // Find price and enter 200
        // WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='price']")));
        // price.sendKeys("200");

        // // Find the li.crum subarea->p text value, and in a new tab, search it, then grab the zip code for it.
        // WebElement location = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class,'crumb')]//p")));
        // String locationText = location.getText();
        // // Add ' zip code' to the location text
        // locationText += " zip code";

        // // Open a new tab and search for the location text
        // WebElement body = driver.get().findElement(By.tagName("body"));
        // body.sendKeys(Keys.CONTROL + "t");
        // List<String> tabs = new java.util.ArrayList<String>(driver.get().getWindowHandles());
        // driver.get().switchTo().window(tabs.get(1));

        // driver.get().get("https://www.google.com");
        // WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));
        // search.sendKeys(locationText, Keys.RETURN);

        // // Find the first div with a data-attrid="Munin", and get it's text value
        // WebElement zipCode = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-attrid='Munin']")));
        // String zipCodeText = zipCode.getText();

        // // Close the tab and switch back to the original tab
        // body = driver.get().findElement(By.tagName("body"));
        // body.sendKeys(Keys.CONTROL + "w");
        // driver.get().switchTo().window(tabs.get(0));

        // // Find input name 'postal' and enter the zip code
        // WebElement postal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='postal']")));
        // postal.sendKeys(zipCodeText);

        // // Enter email
        // WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='FromEMail']")));
        // email.sendKeys("test@gmail.com");

        // // Submit
        // WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='go']")));
        // submit.click();

        // // click button with continue text
        // WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'continue')]")));
        // continueButton.click();

        // // Click button with done with images
        // WebElement doneWithImages = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'done with images')]")));
        // doneWithImages.click();

        // // Click publish button
        // WebElement publish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'publish')]")));
        // publish.click();
    }

    @Test (priority = 3)
    public void testEditListing() {
    }

    @Test (priority = 4)
    public void testDeleteListing() {
    }
}
