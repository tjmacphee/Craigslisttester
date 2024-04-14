package fgcuvladtyler;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Profile extends Setup {
    /*
     *  This test class will test the profile page, drafts page, searches page, and settings page.
     */

     @Test (priority = 1)
    public void testProfilePage() {
        driver.get("https://accounts.craigslist.org/login");
        sleep(8000);
        // Wait for the email and password input fields to be visible on the page, then
        // enter the login credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputEmailHandle']")))
            .sendKeys(config.getProperty("login.username"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputPassword']")))
            .sendKeys(config.getProperty("login.password"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']"))).click();

        sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://accounts.craigslist.org/login/home", "The current URL does not match the expected URL.");
    }

    @Test (priority = 2)
    public void testDraftsPage() {
        // Click on the drafts link
        WebElement draftsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'drafts')]")));
        draftsLink.click();

        sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://accounts.craigslist.org/login/home?show_tab=drafts", "The current URL does not match the expected URL.");
    }

    @Test (priority = 3)
    public void testSearchesPage() {
        // Click on the searches link
        WebElement searchesLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'searches')]")));
        searchesLink.click();

        sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://accounts.craigslist.org/login/home?show_tab=searches", "The current URL does not match the expected URL.");
    }

    @Test (priority = 4)
    public void testSettingsPage() {
        // Click on the settings link
        WebElement settingsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'settings')]")));
        settingsLink.click();

        sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://accounts.craigslist.org/login/home?show_tab=settings", "The current URL does not match the expected URL.");
    }
}
