package fgcuvladtyler;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SetupTests {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeSuite
    public static void setUp() {
       try (FileInputStream input = new FileInputStream(Objects.requireNonNull(SetupTests.class.getClassLoader().getResource("config.properties")).getFile())) {
            Properties props = new Properties();
            props.load(input);
            String webdriverPath = props.getProperty("webdriver.chrome.driver");
            System.setProperty("webdriver.chrome.driver", webdriverPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-cookies");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
