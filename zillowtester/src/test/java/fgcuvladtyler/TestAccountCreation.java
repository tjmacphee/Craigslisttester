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
       try (FileInputStream input = new FileInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("config.properties")).getFile())) {
            Properties props = new Properties();
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
        driver.get("");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
