package fgcuvladtyler;

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
    private WebDriver driver;
    private WebDriverWait wait;
    private Login login;

    public static class Login {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    @BeforeClass
    public void setUp() {
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream(getClass().getClassLoader().getResource("config.properties").getFile())) {
            props.load(input);
            String webdriverPath = props.getProperty("webdriver.chrome.driver");
            System.setProperty("webdriver.chrome.driver", webdriverPath);

            login = new Login();
            login.setUsername(props.getProperty("login.username"));
            login.setPassword(props.getProperty("login.password"));

            driver = new ChromeDriver();
            driver.manage().window().maximize();

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
        emailInput.sendKeys(login.getUsername());

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

        // Wait for user to enter verification code from email into terminal
        System.out.println("Enter verification code from email: ");
        String code = System.console().readLine();
        // Enter verification code & submit
        WebElement verificationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-verify-form--input-code")));
        verificationInput.sendKeys(code);
        continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("registration-verify-form-continue-button")));
        continueButton.click();

        // Wait for user to enter username into terminal
        System.out.println("Enter username: ");
        String username = System.console().readLine();
        // Enter username & submit
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("displayName")));
        usernameInput.sendKeys(username);
        continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("registration-account-name-form--continue-button")));
        continueButton.click();

        // enter password into input
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement confirmPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repassword")));
        passwordInput.sendKeys(login.getPassword());
        confirmPasswordInput.sendKeys(login.getPassword());

        // Click continue button once no longer disabled
        continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("registration-password-form--create-account-button")));
        continueButton.click();

        // Wait until h1 tag with "All done!" is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'All done!')]")));

        // Finished
        System.out.println("Account created successfully!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
