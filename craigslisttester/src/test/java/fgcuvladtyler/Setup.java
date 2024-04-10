package fgcuvladtyler;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Setup {
    public WebDriver driver = new ChromeDriver();
    public static WebDriverWait wait;
    public static Properties config;

    @BeforeSuite
    public void setUp() {
       try (FileInputStream input = new FileInputStream(Objects.requireNonNull(Setup.class.getClassLoader().getResource("config.properties")).getFile())) {
            config = new Properties();
            config.load(input);
            String webdriverPath = config.getProperty("webdriver.chrome.driver");
            System.setProperty("webdriver.chrome.driver", webdriverPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
