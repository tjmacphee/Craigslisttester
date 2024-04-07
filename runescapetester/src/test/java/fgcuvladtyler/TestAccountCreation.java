package fgcuvladtyler;

import java.util.Objects;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class TestAccountCreation {
    public WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
      System.out.println("in setup");
        Properties props = new Properties();
       try (FileInputStream input = new FileInputStream(
           Objects.requireNonNull(getClass().getClassLoader().getResource("config.properties")).getFile())) {
            props.load(input);
            String webdriverPath = props.getProperty("webdriver.chrome.driver");
            System.setProperty("webdriver.chrome.driver", webdriverPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*
     */
    @Test(priority = 1)
    public void test() throws InterruptedException {
        driver.get("https://secure.runescape.com/m=account-creation/create_account?theme=runescape");

        // Accept cookies
        WebElement cookieButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cookieButton.click();

        // Click new account button by finding the h1 element with "New account", then click it's parent div
        WebElement newAccountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'New account')]/..")));
        newAccountButton.click();

        // Wait for email input
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-email")));
        emailInput.sendKeys("test@gmail.com");

        // Enter date of birth by finding MM, DD, YYYY inputs xpath
        WebElement monthInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(text(), 'MM')]")));
        WebElement dayInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(text(), 'DD')]")));
        WebElement yearInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(text(), 'YYYY')]")));
        monthInput.sendKeys("01");
        dayInput.sendKeys("01");
        yearInput.sendKeys("1990");
        
        // Agree to terms and conditions
        WebElement termsCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-start-accept-agreements")));
        termsCheckbox.click();

        // Click continue button once no longer disabled
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("registration-start-form--continue-button")));
        continueButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
