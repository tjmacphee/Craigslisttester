package fgcuvladtyler;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Signup extends Setup {
  /**
   * This test case navigates to the sign up page, creates an account, logs in,
   * and tests the forgot password functionality.
   */

  @Test(priority = 1)
  public void testSignUpPage() {
    String url = "https://accounts.craigslist.org/login";
    driver.get(url);
    Assert.assertEquals(driver.getCurrentUrl(), url, "The current URL does not match the expected URL.");
  }

  @Test(priority = 2)
  public void testSignUpFunctionality() {
    // Wait for the email input field to be visible on the page, then enter the
    // email address
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='emailAddress']")))
        .sendKeys("testemail@test.com");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='create']"))).click();

    // Wait for the success div to be visible on the page
    WebElement successDiv = wait
        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-success")));
    Assert.assertTrue(successDiv.isDisplayed(), "The success div is not displayed on the page.");
  }

  @Test(priority = 3)
  public void testLoginInFunctionality() {
    driver.get("https://accounts.craigslist.org/login");

    // Wait for the email and password input fields to be visible on the page, then
    // enter the login credentials
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputEmailHandle']")))
        .sendKeys(config.getProperty("login.username"));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputPassword']")))
        .sendKeys(config.getProperty("login.password"));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']"))).click();

    // Assert that there's a text that says "home of login.username"
    WebElement homeText = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//a[contains(text(), 'home of " + config.getProperty("login.username") + "')]")));
    Assert.assertTrue(homeText.isDisplayed(), "The home text is not displayed on the page.");
  }

  @Test(priority = 4)
  public void testForgotPasswordFunctionality() {
    // Click logout button
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'log out')]"))).click();

    // Wait for forgot password link
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Forgot password?')]")))
        .click();

    // Wait for the email input field
    WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
    emailInput.sendKeys("testemail@test.com");

    // Click the button with "Reset Password" text
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Reset password')]")))
        .click();

    // Wait for the success div to be visible on the page
    WebElement successDiv = wait
        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-success")));
    Assert.assertTrue(successDiv.isDisplayed(), "The success div is not displayed on the page.");
  }
}
