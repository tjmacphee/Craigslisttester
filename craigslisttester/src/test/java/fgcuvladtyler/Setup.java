package fgcuvladtyler;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Setup {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected WebDriverWait wait;
    protected static Properties config;

    @BeforeClass
    public void setUpClass() {
        if (config == null) {
            synchronized (Setup.class) {
                if (config == null) {
                    config = new Properties();
                    try (FileInputStream input = new FileInputStream(Objects.requireNonNull(Setup.class.getClassLoader().getResource("config.properties")).getFile())) {
                        config.load(input);
                        String webdriverPath = config.getProperty("webdriver.chrome.driver");
                        System.setProperty("webdriver.chrome.driver", webdriverPath);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        WebDriver localDriver = new ChromeDriver();
        driver.set(localDriver);
        driver.get().manage().window().maximize();
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDownClass() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
